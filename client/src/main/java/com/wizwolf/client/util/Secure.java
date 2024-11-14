package com.wizwolf.client.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Secure {
    private static Cipher s_cipher = null;
    private static SecretKey s_key = null;
    public static final String CLEARTEXT = "xyz";

    public Secure() {
    }

    private static void initCipher() {
        try {
            s_cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            s_key = new SecretKeySpec(new byte[]{100, 25, 28, -122, -26, 94, -3, -26}, "DES");
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }

    public static String encrypt(String value) {
        String clearText = value;
        if (value == null) {
            clearText = "";
        }

        if (s_cipher == null) {
            initCipher();
        }

        if (s_cipher != null) {
            try {
                s_cipher.init(1, s_key);
                byte[] encBytes = s_cipher.doFinal(clearText.getBytes());
                String encString = convertToHexString(encBytes);
                return encString;
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        return "xyz" + value;
    }

    public static String decrypt(String value) {
        if (value == null) {
            return null;
        } else if (value.length() == 0) {
            return value;
        } else if (value.startsWith("xyz")) {
            return value.substring(3);
        } else {
            if (s_cipher == null) {
                initCipher();
            }

            if (s_cipher != null && value != null && value.length() > 0) {
                try {
                    AlgorithmParameters ap = s_cipher.getParameters();
                    s_cipher.init(2, s_key, ap);
                    byte[] out = s_cipher.doFinal(convertHexString(value));
                    return new String(out);
                } catch (Exception var3) {
                    System.err.println("Secure.decrypt=" + value);
                    var3.printStackTrace();
                }
            }

            return value;
        }
    }

    public static int hash(String key) {
        long tableSize = 2147483647L;
        long hashValue = 0L;

        for(int i = 0; i < key.length(); ++i) {
            hashValue = 37L * hashValue + (long)(key.charAt(i) - 31);
        }

        hashValue %= tableSize;
        if (hashValue < 0L) {
            hashValue += tableSize;
        }

        int retValue = (int)hashValue;
        return retValue;
    }

    public static String getDigest(String message) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
        }

        md.reset();
        byte[] input = message.getBytes();
        md.update(input);
        byte[] output = md.digest();
        md.reset();
        return convertToHexString(output);
    }

    public static boolean isDigest(String value) {
        if (value != null && value.length() == 32) {
            return convertHexString(value) != null;
        } else {
            return false;
        }
    }

    private static String convertToHexString(byte[] bytes) {
        int size = bytes.length;
        StringBuffer buffer = new StringBuffer(size * 2);

        for(int i = 0; i < size; ++i) {
            int x = bytes[i];
            if (x < 0) {
                x += 256;
            }

            String tmp = Integer.toHexString(x);
            if (tmp.length() == 1) {
                buffer.append("0");
            }

            buffer.append(tmp);
        }

        return buffer.toString();
    }

    private static byte[] convertHexString(String hexString) {
        int size = hexString.length() / 2;
        byte[] retValue = new byte[size];
        String inString = hexString.toLowerCase();

        try {
            for(int i = 0; i < size; ++i) {
                int index = i * 2;
                int ii = Integer.parseInt(inString.substring(index, index + 2), 16);
                retValue[i] = (byte)ii;
            }

            return retValue;
        } catch (Exception var7) {
            System.err.println("Secure.convertHexString error - " + var7.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String[] testString = new String[]{"This is a test!", "", "This is a verly long test string 1624$%"};
        String[] digestResult = new String[]{"702edca0b2181c15d457eacac39de39b", "d41d8cd98f00b204e9800998ecf8427e", "934e7c5c6f5508ff50bc425770a10f45"};

        String in;
        for(int i = 0; i < testString.length; ++i) {
            in = getDigest(testString[i]);
            if (digestResult[i].equals(in)) {
                System.out.println("OK - digest");
            } else {
                System.err.println("Digest=" + in + " <> " + digestResult[i]);
            }
        }

        System.out.println("IsDigest true=" + isDigest(digestResult[0]));
        System.out.println("IsDigest false=" + isDigest("702edca0b2181c15d457eacac39DE39J"));
        System.out.println("IsDigest false=" + isDigest("702e"));
        in = "4115da655707807F00FF";
        byte[] bb = convertHexString(in);
        String out = convertToHexString(bb);
        if (in.equalsIgnoreCase(out)) {
            System.out.println("OK - conversion");
        } else {
            System.err.println("Conversion Error " + in + " <> " + out);
        }

        String test = "This is a test!!";
        String result = "28bd14203bcefba1c5eaef976e44f1746dc2facaa9e0623c";
        String test_1 = decrypt(result);
        if (test.equals(test_1)) {
            System.out.println("OK - dec_1");
        } else {
            System.out.println("TestDec=" + test_1 + " <> " + test);
        }

        String testEnc = encrypt(test);
        if (result.equals(testEnc)) {
            System.out.println("OK - enc");
        } else {
            System.err.println("TestEnc=" + testEnc + " <> " + result);
        }

        String testDec = decrypt(testEnc);
        if (test.equals(testDec)) {
            System.out.println("OK - dec");
        } else {
            System.out.println("TestDec=" + testDec + " <> " + test);
        }

    }
}

