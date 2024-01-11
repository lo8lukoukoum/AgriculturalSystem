package com.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 数据库操作基础类
public class Basedao {
    // 静态代码块，用于加载数据库驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // 打印加载驱动失败的异常信息
            e.printStackTrace();
        }
    }

    // 获取数据库连接的方法
    public static Connection getconn() {
        Connection conn = null;
        try {
            // 建立数据库连接，需要提供数据库URL、用户名和密码
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AgriclturalSystem?useUnicode=true&characterEncoding=UTF-8", "root", "root");
        } catch (SQLException e) {
            // 打印获取连接失败的异常信息
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭资源的方法
    public static void closeall(ResultSet rs, Statement ps, Connection conn) {
        try {
            // 判断并关闭ResultSet、Statement和Connection
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // 打印关闭资源失败的异常信息
            e.printStackTrace();
        }
    }

    // 执行增删改SQL语句的方法
    public static int exectuIUD(String sql, Object[] params) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        // 获取预处理语句
        try {
            ps = conn.prepareStatement(sql);
            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // 执行语句，获取受影响的行数
            count = ps.executeUpdate();
        } catch (SQLException e) {
            // 打印执行SQL语句失败的异常信息
            e.printStackTrace();
        } finally {
            // 关闭资源
            Basedao.closeall(null, ps, conn);
        }
        return count;
    }
}
