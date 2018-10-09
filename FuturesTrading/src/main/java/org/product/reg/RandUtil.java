package org.product.reg;

import java.util.Random;

/*
* 设置随机六位验证码
* */
public class RandUtil {
    public  String getRand(){
        String rand;
        while (true) {
            rand = new Random().nextInt(1000000) + "";
            if (rand.length() == 6) {
                System.out.println(rand);
                return rand;
            }
        }
    }
}
