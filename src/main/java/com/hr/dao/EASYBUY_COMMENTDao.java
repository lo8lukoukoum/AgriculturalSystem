package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_COMMENT;

// 导入基础操作类和评论实体类
import com.hr.dao.Basedao;
import com.hr.entity.EASYBUY_COMMENT;

// 评论数据访问类
public class EASYBUY_COMMENTDao {

    // 查询所有评论
    public static ArrayList<EASYBUY_COMMENT> selectAll() {
        ArrayList<EASYBUY_COMMENT> list = new ArrayList<EASYBUY_COMMENT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 准备查询语句，查询所有评论
            ps = conn.prepareStatement("select * from EASYBUY_COMMENT");
            rs = ps.executeQuery();
            // 封装结果集到Comment对象
            while (rs.next()) {
                EASYBUY_COMMENT c = new EASYBUY_COMMENT(rs.getInt("EC_ID"), rs.getString("EC_CONTENT"),
                        rs.getString("EC_CREATE_TIME"), rs.getString("EC_REPLY"), rs.getString("EC_REPLY_TIME"),
                        rs.getString("EC_NICK_NAME"));
                list.add(c);
            }
        } catch (SQLException e) {
            // 打印异常信息
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return list;
    }

    // 根据id查询单条评论
    public static EASYBUY_COMMENT selectById(int id) {
        EASYBUY_COMMENT c = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 准备查询语句，根据ID查询评论
            ps = conn.prepareStatement("select * from EASYBUY_COMMENT where EC_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new EASYBUY_COMMENT(rs.getInt("EC_ID"), rs.getString("EC_CONTENT"),
                        rs.getString("EC_CREATE_TIME"), rs.getString("EC_REPLY"), rs.getString("EC_REPLY_TIME"),
                        rs.getString("EC_NICK_NAME"));
            }
        } catch (SQLException e) {
            // 打印异常信息
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return c;
    }

    // 新增评论
    public static int insert(EASYBUY_COMMENT c) {
        String sql = "insert into EASYBUY_COMMENT values(null,?,NOW(),?,?,?)";
        Object[] params = { c.getEC_CONTENT(), c.getEC_REPLY(), c.getEC_REPLY_TIME(), c.getEC_NICK_NAME() };
        return Basedao.exectuIUD(sql, params);
    }

    // 更新评论
    public static int update(EASYBUY_COMMENT c) {
        String sql = "update EASYBUY_COMMENT set EC_REPLY=?,EC_REPLY_TIME=DATE_FORMAT(?,'%Y-%m-%d') where EC_ID=?";
        Object[] params = { c.getEC_REPLY(), c.getEC_REPLY_TIME(), c.getEC_ID() };
        return Basedao.exectuIUD(sql, params);
    }

    // 删除评论
    public static int del(int id) {
        String sql = "delete from EASYBUY_COMMENT where EC_ID=?";
        Object[] params = { id };
        return Basedao.exectuIUD(sql, params);
    }

    // 分页查询所有评论
    public static ArrayList<EASYBUY_COMMENT> selPage(int page, int pagesize) {
        ArrayList<EASYBUY_COMMENT> list = new ArrayList<EASYBUY_COMMENT>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int min = (page - 1) * pagesize;
        int max = pagesize;
        try {
            conn = Basedao.getconn();
            // 分页查询语句，按创建时间降序排序
            String sql = "select * from easybuy_comment order by Ec_create_time desc limit " + min + "," + max;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                EASYBUY_COMMENT comment = new EASYBUY_COMMENT();
                comment.setEC_ID((rs.getInt("ec_id")));
                comment.setEC_CONTENT(rs.getString("Ec_content"));
                comment.setEC_CREATE_TIME(rs.getString("Ec_create_time"));
                comment.setEC_REPLY(rs.getString("Ec_reply"));
                comment.setEC_REPLY_TIME(rs.getString("Ec_reply_time"));
                comment.setEC_NICK_NAME(rs.getString("Ec_nick_name"));
                list.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, pst, conn);
        }
        return list;
    }

    // 根据id查询单条评论
    public static EASYBUY_COMMENT selOne(int id) {
        EASYBUY_COMMENT comment = new EASYBUY_COMMENT();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Basedao.getconn();
            // 根据ID查询评论
            String sql = "select * from EASYBUY_COMMENT where Ec_id=?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                comment.setEC_ID(rs.getInt("ec_id"));
                comment.setEC_CONTENT(rs.getString("Ec_content"));
                comment.setEC_CREATE_TIME(rs.getString("Ec_create_time"));
                comment.setEC_REPLY(rs.getString("Ec_reply"));
                comment.setEC_REPLY_TIME(rs.getString("Ec_reply_time"));
                comment.setEC_NICK_NAME(rs.getString("Ec_nick_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, pst, conn);
        }
        return comment;
    }

    // 更新评论
    public static int u(EASYBUY_COMMENT comment) {
        int num = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Basedao.getconn();
            // 执行更新语句
            String sql = "update EASYBUY_COMMENT set EC_NICK_NAME=?,EC_REPLY=? where EC_ID=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, comment.getEC_NICK_NAME());
            pst.setString(2, comment.getEC_REPLY());
            pst.setInt(3, comment.getEC_ID());
            num = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Basedao.closeall(null, pst, conn);
        }
        return num;
    }

    // 获取总页数
    public static int getMax(int pagesize) {
        int max = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = Basedao.getconn();
            // 查询总记录数
            String sql = "select count(*) from EASYBUY_COMMENT";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                if (count % pagesize == 0) {
                    max = (count / pagesize);
                } else {
                    max = (count / pagesize) + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, pst, conn);
        }
        return max;
    }

    // 根据用户名分页查询
    public static ArrayList<EASYBUY_COMMENT> selPages(String name, int page, int pages) {
        ArrayList<EASYBUY_COMMENT> al = new ArrayList<EASYBUY_COMMENT>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int min = (page - 1) * pages;
        int max = pages;
        try {
            conn = Basedao.getconn();
            // 分页查询语句，按创建时间降序排序
            String sql = "select * from easybuy_comment where ec_nick_name=? order by ec_create_time desc limit "
                    + min + "," + max;
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while (rs.next()) {
                EASYBUY_COMMENT com = new EASYBUY_COMMENT();
                com.setEC_ID(rs.getInt("ec_id"));
                com.setEC_CONTENT(rs.getString("ec_content"));
                com.setEC_CREATE_TIME(rs.getString("ec_create_time"));
                com.setEC_NICK_NAME(rs.getString("ec_nick_name"));
                com.setEC_REPLY(rs.getString("ec_reply"));
                com.setEC_REPLY_TIME(rs.getString("ec_reply_time"));
                al.add(com);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, pst, conn);
        }
        return al;
    }
}
