package com.hezhi3f.easybill.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hezhi3f.easybill.entity.user.UserPO;

public class TokenUtils {

    public static String getToken(UserPO userDTO) {
        return JWT.create()
                .withClaim("username", userDTO.getUsername())
                .sign(Algorithm.HMAC256(userDTO.getSecret()));
    }
}
