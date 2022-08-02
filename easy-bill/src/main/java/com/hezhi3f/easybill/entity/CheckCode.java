package com.hezhi3f.easybill.entity;

import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class CheckCode {
    private String code;
    private BufferedImage image;
}
