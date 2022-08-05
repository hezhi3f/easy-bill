package com.hezhi3f.easybill.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.hezhi3f.easybill.entity.user.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenUtilsTest {

    @Test
    void getToken() {
        UserPO userPO = new UserPO();
        userPO.setUsername("guomq");
        userPO.setSecret("f4c3f8ff-1414-419e-b691-28fb8fd16859");
        String token = TokenUtils.getToken(userPO);
        System.out.println(token);
    }

    @Test
    void decode() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imd1b21xIn0.eaFIWbtvP0QlHMJnlhdDsXjp6NIOYbZKqw5hUj4yHWU";
        DecodedJWT decode = JWT.decode(token);
        decode.getClaims().forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("decode.getAlgorithm() = " + decode.getAlgorithm());
        System.out.println("decode.getSignature() = " + decode.getSignature());
        System.out.println("decode.getSubject() = " + decode.getSubject());
        System.out.println("decode.getType() = " + decode.getType());
    }

    @Test
    void require() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imd1b21xIn0.eaFIWbtvP0QlHMJnlhdDsXjp6NIOYbZKqw5hUj4yHWU";
        Verification require = JWT.require(Algorithm.HMAC256("f4c3f8ff-1414-419e-b691-28fb8fd16859"));
        JWTVerifier build = require.build();
        DecodedJWT decode = build.verify(token);
        decode.getClaims().forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("decode.getAlgorithm() = " + decode.getAlgorithm());
        System.out.println("decode.getSignature() = " + decode.getSignature());
        System.out.println("decode.getSubject() = " + decode.getSubject());
        System.out.println("decode.getType() = " + decode.getType());
    }

    @Test
    void test() {
        String token = "eyJ0eXAiOiJKV1QiLCJ0cHkiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Imd1b21xIn0.99Hc6fl_qIHXVVjar4Pqf8TDU7LGEB-9FtGkHNhWg3g";
        Verification require = JWT.require(Algorithm.HMAC256("f4c3f8ff-1414-419e-b691-28fb8fd16859"));
        JWTVerifier build = require.build();
        DecodedJWT decode = build.verify(token);
        String userdog = decode.getClaim("userdog").asString();
        System.out.println(userdog);
    }
}
