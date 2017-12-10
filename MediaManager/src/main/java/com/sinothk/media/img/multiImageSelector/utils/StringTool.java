package com.sinothk.media.img.multiImageSelector.utils;

import java.io.UnsupportedEncodingException;

/**
 * String处理
 * Created by tijn on 2016/6/27.
 */
public class StringTool {
    /**
     * 截取带中文的String
     *
     * @param str
     * @param subSLength
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String subStr(String str, int subSLength) {
        if (str == null)
            return "";
        else {
            try {
                int tempSubLength = subSLength;// 截取字节数
                String subStr = str.substring(0,
                        str.length() < subSLength ? str.length() : subSLength);// 截取的子串
                int subStrByetsL = subStr.getBytes("GBK").length;// 截取子串的字节长度
                // int subStrByetsL = subStr.getBytes().length;//截取子串的字节长度
                // 说明截取的字符串中包含有汉字
                while (subStrByetsL > tempSubLength) {
                    int subSLengthTemp = --subSLength;
                    subStr = str.substring(0,
                            subSLengthTemp > str.length() ? str.length()
                                    : subSLengthTemp);
                    subStrByetsL = subStr.getBytes("GBK").length;
                    // subStrByetsL = subStr.getBytes().length;
                }
                return subStr;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return str;
            }
        }
    }
}
