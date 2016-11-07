package com.shine.util.validate;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ttf字体文件
 *
 */
public class ImgFontByte {

    public Font getFont(int fontHeight) {
        try {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(getFontByteStr())));
            return baseFont.deriveFont(Font.PLAIN, fontHeight);
        } catch (Exception e) {
            return new Font("Arial", Font.PLAIN, fontHeight);
        }
    }

    private byte[] hex2byte(String str) {
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ttf字体文件的十六进制字符串
     *
     * @return
     */
    private String getFontByteStr() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/xidian/neptune/smsplatform/util/validate/Validate.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return p.getProperty("font");
    }
}