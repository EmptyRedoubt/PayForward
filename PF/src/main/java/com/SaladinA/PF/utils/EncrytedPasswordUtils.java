package com.SaladinA.PF.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
	   // Encrypt Password with BCryptPasswordEncoder
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
 
//    public static void main(String[] args) {
//        String password = "montana05";
//        String encryptedPassword = encryptPassword(password);
// 
//        System.out.println("Encryted Password: " + encryptedPassword);
//    }
}
