package com.hezhi3f.easybill.entity.checkcode;

import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class CheckCode {
    private String code;
    private BufferedImage image;
}
