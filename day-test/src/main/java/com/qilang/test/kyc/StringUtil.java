package com.qilang.test.kyc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.Character.UnicodeBlock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    private static Logger log = LoggerFactory.getLogger(StringUtil.class);
    private static final int DEFAULT_LENGTH = 32;

    private StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isChinese(char c) {
        UnicodeBlock ub = UnicodeBlock.of(c);
        return ub == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == UnicodeBlock.GENERAL_PUNCTUATION || ub == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|t*|r*|n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = (float)ch.length;
        float count = 0.0F;

        for(int i = 0; i < ch.length; ++i) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c) && !isChinese(c)) {
                ++count;
            }
        }

        float result = count / chLength;
        if ((double)result > 0.4D) {
            return true;
        } else {
            return false;
        }
    }
}
