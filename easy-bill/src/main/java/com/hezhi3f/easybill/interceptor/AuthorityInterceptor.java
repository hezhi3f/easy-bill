package com.hezhi3f.easybill.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    private static final String TOKEN = "token";

    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN);
        if (token == null) {
            throw new BillException(ExceptionEnum.TOKEN_NOT_EXIST);
        }

        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getClaim("username").asString();

        if (username == null) {
            throw new BillException(ExceptionEnum.TOKEN_INFO_INCOMPLETE);
        }

        UserPO userPO = userService.getOne(Wrappers.<UserPO>query().eq("username", username));

        if (userPO == null) {
            throw new BillException(ExceptionEnum.USER_NOT_EXIST);
        }

        // 出错就被拦截
        Algorithm.HMAC256(userPO.getSecret()).verify(jwt);

        return true;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
