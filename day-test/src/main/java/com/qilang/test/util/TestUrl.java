package com.qilang.test.util;

import org.springframework.util.AntPathMatcher;

public class TestUrl {

    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("/gld/*/callback","/gld/1934826963943120898/callback "));
    }
}
