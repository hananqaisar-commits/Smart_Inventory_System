package com.NexStock.security;

import java.util.Random;

public class passwrod_generator {
    
    public StringBuilder generate(int length) {
        String chars = "qpa!IOPA@whsdT;fgFjkl:'[D3S#$KLZHio{]rtyu}JX5CVBNM,<.>/e]YU84?|=+-_09zxcvbnmQWER21`~7QW6%^&*()";

        StringBuilder password_generated = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {

            int j = random.nextInt(chars.length());
            password_generated.append(chars.charAt(j));

        }
        return password_generated;
    }
}
