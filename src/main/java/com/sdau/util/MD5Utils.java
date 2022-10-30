package com.sdau.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {


    public static String getMD5(String pass) {
        /*随机盐值 随机加密次数 a-->z*/
        int ran_count = (int) (Math.random() * 26 + 97);        // 区间[97,123)
        int ran_salt = (int) (Math.random() * 26 + 97);        // 区间[97,123)
        String result_pass = (pass == null) ? SYS.DEFAULTPASS + (char) ran_salt : pass + (char) ran_salt;
        for (int i = 0; i < ran_count; i++) {
            result_pass = DigestUtils.md5DigestAsHex(result_pass.getBytes());
        }
        result_pass = result_pass + (char) ran_count + (char) ran_salt;

        return result_pass;
    }


    /**
     * 验证登录页面中传入的密码参数是否和数据库中的数据相匹配
     *
     * @param pass_data  数据库中加密后的内容	加密后的字符串 + 加密次数字符 + 加密盐值
     * @param pass_param
     * @return
     */
    // 随机次数随机盐值
    public static boolean LoginPass(String pass_data, String pass_param) {
        // 加密后的结果
        String hex_data = pass_data.substring(0, pass_data.length() - 2);
        // as
        String hex_code = pass_data.substring(pass_data.length() - 2);
        // ['循环次数','盐值']
        char[] code_arr = hex_code.toCharArray();
        String salt_pass = pass_param + code_arr[1];


        for (int i = 0; i < code_arr[0]; i++) {
            salt_pass = DigestUtils.md5DigestAsHex(salt_pass.getBytes());
        }
        // salt_pass 加密后结果

        // salt_pass与数据库结果比对
        return hex_data.equals(salt_pass);

    }


    public static void main(String[] args) {
        String pass = "";
        int count = 'd';
        for (int i = 0; i < count; i++) {
            pass = DigestUtils.md5DigestAsHex(SYS.DEFAULTPASS.getBytes());
        }

        System.out.println(pass);
    }


}
