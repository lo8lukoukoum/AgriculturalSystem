package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_ORDER_DETAIL;

// 订单详情数据访问类
public class EASYBUY_ORDER_DETAILDao {

	// 查询所有订单详情
	public static ArrayList<EASYBUY_ORDER_DETAIL> selectAll() {
		ArrayList<EASYBUY_ORDER_DETAIL> list = new ArrayList<EASYBUY_ORDER_DETAIL>();
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句
			ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL");
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到订单详情对象中
			while (rs.next()) {
				EASYBUY_ORDER_DETAIL c = new EASYBUY_ORDER_DETAIL(
						rs.getInt("EOD_ID"),
						rs.getInt("EO_ID"),
						rs.getInt("EP_ID"),
						rs.getInt("EOD_QUANTITY"),
						rs.getInt("EOD_COST")
				);
				list.add(c);  // 将订单详情对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回订单详情集合
	}

	// 根据订单详情ID查询单条订单详情
	public static EASYBUY_ORDER_DETAIL selectById(int id) {
		EASYBUY_ORDER_DETAIL c = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句
			ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL where EOD_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到订单详情对象中
			while (rs.next()) {
				c = new EASYBUY_ORDER_DETAIL(
						rs.getInt("EOD_ID"),
						rs.getInt("EO_ID"),
						rs.getInt("EP_ID"),
						rs.getInt("EOD_QUANTITY"),
						rs.getInt("EOD_COST")
				);
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return c;  // 返回订单详情对象
	}

	// 插入订单详情
	public static int insert(EASYBUY_ORDER_DETAIL od) {
		String sql = "insert into EASYBUY_ORDER_DETAIL values(null,?,?,?,?)";
		Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_COST() };
		return Basedao.exectuIUD(sql, params);  // 执行插入操作并返回受影响行数
	}

	// 更新订单详情
	public static int update(EASYBUY_ORDER_DETAIL od) {
		String sql = "update EASYBUY_ORDER_DETAIL set EO_ID=?,EP_ID=?,EOD_QUANTITY=?,EOD_COST=? where EOD_ID=?";
		Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_COST(), od.getEOD_ID() };
		return Basedao.exectuIUD(sql, params);  // 执行更新操作并返回受影响行数
	}

	// 删除订单详情
	public static int del(int id) {
		String sql = "delete from EASYBUY_ORDER_DETAIL where EOD_ID=?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);  // 执行删除操作并返回受影响行数
	}
}
