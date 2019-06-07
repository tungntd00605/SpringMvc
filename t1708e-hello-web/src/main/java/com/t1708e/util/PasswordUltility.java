package com.t1708e.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUltility {

    public static String getSalt() throws NoSuchAlgorithmException
    {
        String saltStr = "";
        try {
            final SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            final byte[] salt = new byte[16];
            sr.nextBytes(salt);
            saltStr = Base64.getEncoder().encodeToString(salt);
        } catch (NoSuchAlgorithmException ignored) { }
        return saltStr;
    }

    public static String hashPassword(String password, String salt)
    {
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-512");

            // hash password and salt
            md.update(password.getBytes());
            md.update(salt.getBytes());
            final byte[] hash = md.digest();

            // convert byte array to hex string
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; ++i) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException ignored) { return ""; }
    }
}
