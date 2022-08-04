package com.hezhi3f.easybill.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hezhi3f.easybill.entity.user.UserDTO;

import java.util.Map;

public class TokenUtils {
    private static final Map<String, Object> TOKEN_HEADER = Map.of("alg", "HMAC256", "typ", "JWT");

    public static String getToken(UserDTO userDTO) {
        return JWT.create()
                .withHeader(TOKEN_HEADER)
                .withClaim("username", userDTO.getUsername())
                .withClaim("secret", userDTO.getSecret())
                .sign(Algorithm.HMAC256(userDTO.getPassword()));
    }
}
