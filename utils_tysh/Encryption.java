package com.wbg.tianyi_sj.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import it.sauronsoftware.base64.Base64;

/**
 * 加密，解密
 */
public class Encryption {


    static final String key = "YbtGTfgh";
    static final String iv = "12345678";

    public static void main(String[] args) {
        try {

            System.out.println(encryptDES("wenrui"));
            System.out.println(decryptDES("WSb3ypsrYvwwUJqoRLq3H0C3ZjemzyFxGlsGPPcFR29nXwO+79e1wNOPnyGPT5dp"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 加密
     * @param encryptString
     * @return
     * @throws Exception
     */
    public static String encryptDES(String encryptString)
            throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
        SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skey, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return new String(Base64.encode(encryptedData));
    }

    /**
     * 解密
     * @param decryptString
     * @return
     * @throws Exception
     */
    public static String decryptDES(String decryptString)
            throws Exception {
        byte[] byteMi = Base64.decode(decryptString.getBytes());
        IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
        SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skey, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData);
    }

}
