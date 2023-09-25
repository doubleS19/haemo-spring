package com.example.haemo.haemo.Service.User;

import com.example.haemo.haemo.Controller.User.EclassController;
import com.example.haemo.haemo.Controller.User.LoginController;
import com.example.haemo.haemo.Repository.User.EclassRepository;
import com.example.haemo.haemo.Repository.User.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Service
public class EclassService {

    @Autowired
    EclassRepository eclassRepository;

    @Autowired
    EclassController eclassController;

    public EclassService(EclassRepository eclassRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.eclassRepository = eclassRepository;
    }

//    private final RestTemplate restTemplate;
//
//    public LoginService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

//    public void getLoginResponse(Login loginBody) throws Exception {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("usr_id", loginBody.getStudentId());
//        body.add("usr_pwd", loginBody.getPwd());
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "https://eclass.tukorea.ac.kr/ilos/lo/login.acl",
//                HttpMethod.POST,
//                requestEntity,
//                String.class
//        );
//
//        if (responseEntity.getStatusCode() != HttpStatus.OK) {
//            throw new RuntimeException("Status code error: " + responseEntity.getStatusCodeValue());
//        }
//
//        String responseString = responseEntity.getBody();
//
//        if (responseString.contains("document.location.href=\"https://eclass.tukorea.ac.kr/ilos/main/main_form.acl\"")) {
//            // 로그인 성공 처리
//            // 여기서 쿠키 설정 등의 작업을 수행할 수 있습니다.
//        } else if (responseString.contains("로그인 정보가 일치하지 않습니다.")) {
//            throw new RuntimeException("아이디 또는 비밀번호가 잘못되었습니다.");
//        } else {
//            throw new RuntimeException("알 수 없는 에러");
//        }
//    }

//    public void login(String rsaPrivateKeyPEM, String encryptedKey, User user) throws Exception {
//        // RSA 복호화
//        PrivateKey privateKey = getPrivateKeyFromPEM(rsaPrivateKeyPEM);
//        String aesKey = decryptWithRSA(privateKey, encryptedKey);
//
//        byte[] iv = aesKey.substring(0, 16).getBytes();
//        String decryptedPassword = decryptWithAES(aesKey, iv, user.getAesPassword());
//
//        Login loginBody = new Login();
//        loginBody.setStudentId(user.getStudentId());
//        loginBody.setPwd(decryptedPassword);
//
//        // 로그인
//        loginController.login(loginBody);
//    }

    private PrivateKey getPrivateKeyFromPEM(String rsaPrivateKeyPEM) throws Exception {
        rsaPrivateKeyPEM = rsaPrivateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] keyBytes = Base64.getDecoder().decode(rsaPrivateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    private String decryptWithRSA(PrivateKey privateKey, String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    private String decryptWithAES(String aesKey, byte[] iv, String encryptedText) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}