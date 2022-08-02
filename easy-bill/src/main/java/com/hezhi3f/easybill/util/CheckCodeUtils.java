package com.hezhi3f.easybill.util;

import com.hezhi3f.easybill.entity.CheckCode;

import java.awt.image.BufferedImage;
import java.util.Random;

public class CheckCodeUtils {
    private static final char[] CODE_SOURCE = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final Random r = new Random();

    public static CheckCode newCheckCode() {
        final int len = CODE_SOURCE.length;
        char[] code = new char[4];
        for (int i = 0; i < code.length; i++) {
            code[i] = CODE_SOURCE[r.nextInt(len)];
        }

        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);

        String codeStr = String.valueOf(code);
        image.createGraphics().drawString(codeStr, 0, 50);


        CheckCode checkCode = new CheckCode();
        checkCode.setCode(codeStr);
        checkCode.setImage(image);
        return checkCode;

    }


}
