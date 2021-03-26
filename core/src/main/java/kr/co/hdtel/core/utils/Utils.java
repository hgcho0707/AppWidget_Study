package kr.co.hdtel.core.utils;

import java.text.DecimalFormat;

public class Utils {

    public static String randomData(int num1, int num2){
        return String.valueOf((int)(Math.random() * (num2 - num1 + 1)) + num1);
    }

    public static String randomFee(int num1, int num2){
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format((int)(Math.random() * (num2 - num1 + 1)) + num1);
    }

    public static String usageRate(double num1, double num2){
        return String.valueOf((int) Math.round(num2 / num1 * 100.0));
    }

}
