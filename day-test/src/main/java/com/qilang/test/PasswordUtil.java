package com.qilang.test;

import cn.hutool.crypto.digest.BCrypt;

import java.util.regex.Pattern;

public class PasswordUtil {

    // 哈希计算的工作因子（默认10，范围4-31），值越大安全性越高但性能越低
    private static final int BCRYPT_WORKLOAD = 12;

    /**
     * 生成哈希密码（用于用户注册或修改密码）
     * @param plainPassword 明文密码
     * @return 哈希后的密码（自动包含盐值）
     */
    public static String hashPassword(String plainPassword) {
        // 自动生成盐 + 哈希计算
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(BCRYPT_WORKLOAD));
    }

    /**
     * 验证密码是否正确（用于登录校验）
     * @param plainPassword 用户输入的明文密码
     * @param hashedPassword 数据库存储的哈希密码
     * @return 是否匹配
     */
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }


    // ----------------------- 示例用法 ------------------------
    public static void main(String[] args) {
        // 模拟用户注册
        /*String userPassword = "Aa123456";
        String hashedPassword = hashPassword(userPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        // 输出示例：$2a$12$s4B7q5UZ5T5Z9QzJ7XQwOeX9uY6J7XQwOeX9uY6J7XQwOeX9uY6

        // 模拟用户登录验证
        String inputPassword = "Aa123456";
        boolean isMatch = verifyPassword(inputPassword, hashedPassword);
        System.out.println("Password Match: " + isMatch); // 输出 true

        // 错误密码测试
        isMatch = verifyPassword("WrongPassword", hashedPassword);
        System.out.println("Password Match: " + isMatch); // 输出 false*/

        String PASSWORD_REGEX = "^(?=[^A-Za-z]*[A-Za-z])[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        System.out.println(pattern.matcher("@@").matches());
    }
}
