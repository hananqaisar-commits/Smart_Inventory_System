package com.example.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Password_Hasher {
    public String hashAlgorithm(String password) {

        try {

            MessageDigest message = MessageDigest.getInstance("SHA-256");// use sha-256 algorithm

            byte[] bytes = message.digest(password.getBytes());// digest mine password with algorithm sha-256
            String hex = HexFormat.of().formatHex(bytes);// convert bytes into hexadecimal formatt
            return hex;

        } catch (NoSuchAlgorithmException e) {// catch excemtion if not available algorithm
            e.printStackTrace();// to display erroe reason msg
            return null;
        }
    }
}