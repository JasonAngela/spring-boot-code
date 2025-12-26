package com.qilang.test.email;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmailTest {
    public static void main(String[] args) {
        // 配置发件人信息
        /*MailAccount mailAccount = new MailAccount();
        mailAccount.setHost("mail.itgholding.com.cn"); // 以163邮箱为例，如果是CoreMail，请替换为相应的SMTP服务器地址
        mailAccount.setPort(465); // SMTP端口，根据邮箱服务商调整，例如163邮箱通常为465或994（SSL）
        mailAccount.setFrom("formflow@itgholding.com.cn"); // 你的CoreMail邮箱地址
        mailAccount.setAuth(true);
        mailAccount.setSslEnable(true);
        mailAccount.setStarttlsEnable(false);
        mailAccount.setUser("formflow@itgholding.com.cn"); // 你的CoreMail邮箱地址
        mailAccount.setPass("BKVWwjHUyk2BxIAr"); // 你的CoreMail邮箱的授权码，不是登录密码

        // 发送邮件
        try {
            MailUtil.send(mailAccount, "huql@xindeco.com.cn", "邮件标题", "<h1>邮件内容</h1>", true);
            System.out.println("邮件发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("邮件发送失败！");
        }*/

        /*List<String> strs = new ArrayList<>();
        strs.add("1");
        strs.add("2");
        List<String> str2 = strs;
        strs.add("3");
        strs.add("4");
        System.out.println(JSON.toJSONString(str2));*/

/*
        String oFileName = "aaa.pdf";
        System.out.println(FilenameUtils.getBaseName(oFileName));
        System.out.println(FilenameUtils.getExtension(oFileName));*/

        /*System.out.println(new Date().toString());*/


        /*List<String> allList = new ArrayList<>();
        allList.add("1");
        allList.add("2");
        allList.add("3");
        allList.add("4");

        List<String> list1 = allList.stream().filter(m -> !m.equals("1")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list1));
        System.out.println(JSON.toJSONString(allList));*/

        System.out.println(DateUtil.offsetDay(new Date(), -15).toString(DatePattern.PURE_DATE_PATTERN));

    }
}
