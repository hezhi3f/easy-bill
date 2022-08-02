package com.hezhi3f.easybill.controller;

import com.hezhi3f.easybill.entity.CheckCode;
import com.hezhi3f.easybill.util.CheckCodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CheckCodeController {

    @GetMapping("/checkcode")
    public void getCheckCode(HttpServletResponse response) throws IOException {

        CheckCode checkCode = CheckCodeUtils.newCheckCode();
        response.setContentType("image/jpeg");
        ImageIO.write(checkCode.getImage(), "JPEG", response.getOutputStream());
        System.out.println(checkCode.getCode());
    }

}
