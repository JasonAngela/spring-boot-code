package com.qilang.test.kyc;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.crypto.digest.MD5;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>流水号生成</p>
 *
 * @author yml
 * @since 2023/10/9
 */
@Slf4j
public class TidUtil {

    private static final String REGULAR = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";

    private static final Pattern PATTERN = Pattern.compile(REGULAR);

    private static final Random RANDOM = new Random();

    /**
     * 获取IP地址
     *
     * @return 本地IP地址
     */
    public static String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            log.warn("获取host ip地址失败");
        }
        return "127.0.0.1";
    }
    public static String generateTid() {
        String hostIp = getHostIp();
        String ipHex = "";
        if (checkIpByRegexp(hostIp)) {
            ipHex = ipToHex(hostIp);
        } else {
            ipHex = new MD5().digestHex16(hostIp);
        }
        int random = RANDOM.nextInt(9000) + 1000;
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        return ipHex + System.currentTimeMillis() + random + pid;
    }

    private static boolean checkIpByRegexp(String ip) {
        Matcher matcher = PATTERN.matcher(ip);
        return matcher.matches();
    }

    public static String ipToHex(String ipString) {
        if (CharSequenceUtil.isBlank(ipString)) {
            return null;
        }
        String[] ip = ipString.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String str : ip) {
            sb.append(String.format("%02x", Integer.parseInt(str)));
        }
        return sb.toString();
    }
}
