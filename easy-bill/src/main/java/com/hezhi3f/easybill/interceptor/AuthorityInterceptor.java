package com.hezhi3f.easybill.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    private static final String TOKEN = "token";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN);
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getClaim("username").asString();
        UserPO userPO = userService.getOne(Wrappers.<UserPO>query().eq("username", username));
        if (userPO == null) {
            throw new BillException("无效的token信息");
        }

        if (!userPO.getSecret().equals(jwt.getClaim("secret").asString())) {
            throw new BillException("验证信息出错");
        }

        return true;
    }
}
