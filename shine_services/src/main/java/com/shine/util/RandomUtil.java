package com.shine.util;

import java.awt.*;
import java.util.Random;

/**
 * 随机工具
 *
 * @author fhj 2016/2/23
 */
public class RandomUtil {

    /**
     * 比较常用的随机色组合
     */
    private static int[] RGB_RED = {114, 69, 20, 254, 3, 25};
    private static int[] RGB_GREEN = {83, 137, 68, 67, 38, 60};
    private static int[] RGB_BLUE = {52, 148, 106, 101, 58, 170};

    /**
     * 获取随机颜色
     *
     * @return
     */
    public static Color getRandomColor() {
        int randomNum = new Random().nextInt(6);
        return new Color(RGB_RED[randomNum], RGB_GREEN[randomNum], RGB_BLUE[randomNum]);
    }
}
