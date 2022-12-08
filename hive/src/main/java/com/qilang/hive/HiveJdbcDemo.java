package com.qilang.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author huql
 **/
public class HiveJdbcDemo {


    public static void main(String[] args) throws SQLException {

        String jdbcUrl = "jdbc:hive2://114.116.71.114:10000";

        Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");




    }

}
