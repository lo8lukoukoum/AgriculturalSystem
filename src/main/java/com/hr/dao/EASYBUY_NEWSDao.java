package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_NEWS;

// 新闻数据访问类
public class EASYBUY_NEWSDao {

	// 查询所有新闻
	public static ArrayList<EASYBUY_NEWS> selectAll() {
		ArrayList<EASYBUY_NEWS> list = new ArrayList<EASYBUY_NEWS>();
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句
			ps = conn.prepareStatement("select * from EASYBUY_NEWS");
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到新闻对象中
			while (rs.next()) {
				EASYBUY_NEWS c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
				list.add(c);  // 将新闻对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回新闻集合
	}

	// 根据新闻ID查询单条新闻
	public static EASYBUY_NEWS selectById(int id) {
		EASYBUY_NEWS c = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句
			ps = conn.prepareStatement("select * from EASYBUY_NEWS where EN_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到新闻对象中
			while (rs.next()) {
				c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return c;  // 返回新闻对象
	}

	// 分页查询所有新闻
	public static ArrayList<EASYBUY_NEWS> selectAll(int cpage, int count) {
		ArrayList<EASYBUY_NEWS> list = new ArrayList<EASYBUY_NEWS>();
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句，按ID降序排序进行分页查询
			ps = conn.prepareStatement("select * from EASYBUY_NEWS order by EN_ID desc limit ?, ?");
			ps.setInt(1, count * (cpage - 1));
			ps.setInt(2, count);
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到新闻对象中
			while (rs.next()) {
				EASYBUY_NEWS c = new EASYBUY_NEWS(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"), rs.getString("EN_CREATE_TIME"));
				list.add(c);  // 将新闻对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回新闻集合
	}

	// 获取新闻总页数
	public static int totalPage(int count) {
		int tpage = 1;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 查询新闻总记录数
			ps = conn.prepareStatement("select count(*) from EASYBUY_NEWS");
			rs = ps.executeQuery();  // 执行查询
			while (rs.next()) {
				int sum = rs.getInt(1);
				// 计算总页数
				if (sum % count == 0) {
					tpage = sum / count;
				} else {
					tpage = sum / count + 1;
				}
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;  // 返回总页数
	}

	// 插入新闻
	public static int insert(EASYBUY_NEWS n) {
		String sql = "insert into EASYBUY_NEWS values(null,?,?,NOW())";
		Object[] params = { n.getEN_TITLE(), n.getEN_CONTENT() };
		return Basedao.exectuIUD(sql, params);  // 执行插入操作并返回受影响行数
	}

	// 更新新闻
	public static int update(EASYBUY_NEWS n) {
		String sql = "update EASYBUY_NEWS set EN_TITLE=?,EN_CONTENT=? where EN_ID=?";
		Object[] params = { n.getEN_TITLE(), n.getEN_CONTENT(), n.getEN_ID() };
		return Basedao.exectuIUD(sql, params);  // 执行更新操作并返回受影响行数
	}

	// 删除新闻
	public static int del(int id) {
		String sql = "delete from EASYBUY_NEWS where EN_ID=?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);  // 执行删除操作并返回受影响行数
	}
}
