package com.ali.demo.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

    private static final String LOCALHOST_IPV4 = "127.0.0.1";
    private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    public static String getAlphaNumericString()
    {
    int n =8;
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static String autoGenProdCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(100000));
    }

    public static boolean objectValidation(Object obj, ResponseStatus status) {
        try {
            Class myClass = obj.getClass();
            for (Method method : myClass.getDeclaredMethods()) {
                if (method.getName().contains("get")) {
                    Object value = obj.getClass().getMethod(method.getName()).invoke(obj);
                    if (null == value) {
                        status.setMsg(firstCharToLowerCase(method.getName().substring(3) + " should not be null"));
                        return false;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String passwordToString(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++)
            sb.append("*");
        return sb.toString();
    }

    private static String firstCharToLowerCase(String str) {

        if (str == null || str.length() == 0)
            return "";
        if (str.length() == 1)
            return str.toLowerCase();
        char[] chArr = str.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);
        return new String(chArr);
    }

    public static String getClientIp(HttpServletRequest request) {

        String ipAddress = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

    public static boolean validateDate(String date) {
        if (date.trim().equals("")) {
            return false;
        }
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
        sdfrmt.setLenient(false);
        try {
            Date javaDate = sdfrmt.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;

    }

    public static boolean keyValidate(String key) {
        if (key.equalsIgnoreCase("PO") || key.equalsIgnoreCase("AN") || key.equalsIgnoreCase("PP")) {
            return true;
        }
        return false;
    }



    public static boolean isAddressValidate(String address) {
        if (address.contains("&")) {
            return true;
        }
        return false;
    }


    public static boolean isCharMatch(String establishmentType,char[] chars) {
        for (char ch : chars){
            if (establishmentType.charAt(0) == ch ) { //|| establishmentType.charAt(0) == 'B'
                return true;
            }
        }
        return false;
    }

    public static boolean isCityCode(int cityCode) {
        int length = String.valueOf(cityCode).length();
        if (length > 5 || length < 0) {
            return false;
        }
        return true;
    }

    public static boolean isTextLength(String text, int inputLength) {
        int length = String.valueOf(text).length();
        if (length > inputLength || length < 0) {
            return false;
        }
        return true;
    }
    public static boolean isTextMatch(String text, String[] strings) {
        for(String s:strings){
            if(!text.equals(s)){
                return false;
            }
        }
        return true;
    }
    public static boolean isNumberLength(String text, int inputLength) {
        int length = String.valueOf(text).length();
        if (length > inputLength || length < 0) {
            return false;
        }
        if (!text.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static boolean isMainCode(String mainCode) {
        String firstThree = "";
        String lastFive = "";
        if (mainCode.length() > 3) {
            firstThree = mainCode.substring(0, 3);
            if (firstThree.contains("\\d+")) {
                return false;
            }
            lastFive = mainCode.substring(3);
            if (!lastFive.matches("[0-9]+")) {
                return false;
            }
            int length = String.valueOf(lastFive).length();
            if (length > 5 || length < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWebsite(String webSiteUrl){
        try {
            URL url = new URL(webSiteUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
        } catch (MalformedURLException e) {
            return false;
            // the URL is not in a valid form
        } catch (IOException e) {
            // the connection couldn't be established
            return false;
        }
        return true;
    }
}
