package com.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ���ݿ����������
public class Basedao {
    // ��̬����飬���ڼ������ݿ�����
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // ��ӡ��������ʧ�ܵ��쳣��Ϣ
            e.printStackTrace();
        }
    }

    // ��ȡ���ݿ����ӵķ���
    public static Connection getconn() {
        Connection conn = null;
        try {
            // �������ݿ����ӣ���Ҫ�ṩ���ݿ�URL���û���������
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AgriclturalSystem?useUnicode=true&characterEncoding=UTF-8", "root", "root");
        } catch (SQLException e) {
            // ��ӡ��ȡ����ʧ�ܵ��쳣��Ϣ
            e.printStackTrace();
        }
        return conn;
    }

    // �ر���Դ�ķ���
    public static void closeall(ResultSet rs, Statement ps, Connection conn) {
        try {
            // �жϲ��ر�ResultSet��Statement��Connection
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // ��ӡ�ر���Դʧ�ܵ��쳣��Ϣ
            e.printStackTrace();
        }
    }

    // ִ����ɾ��SQL���ķ���
    public static int exectuIUD(String sql, Object[] params) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        // ��ȡԤ�������
        try {
            ps = conn.prepareStatement(sql);
            // ���ò���
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            // ִ����䣬��ȡ��Ӱ�������
            count = ps.executeUpdate();
        } catch (SQLException e) {
            // ��ӡִ��SQL���ʧ�ܵ��쳣��Ϣ
            e.printStackTrace();
        } finally {
            // �ر���Դ
            Basedao.closeall(null, ps, conn);
        }
        return count;
    }
}
