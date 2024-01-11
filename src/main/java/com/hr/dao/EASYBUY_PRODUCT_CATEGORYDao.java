package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

// 商品分类数据访问类
public class EASYBUY_PRODUCT_CATEGORYDao {

	/**
	 * 查询所有商品分类
	 * @return 商品分类集合
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY");
			rs = ps.executeQuery();
			// 将查询结果封装到商品分类对象中
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // 将商品分类对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回商品分类集合
	}

	/**
	 * 根据商品分类ID查询单个商品分类
	 * @param id 商品分类ID
	 * @return 商品分类对象
	 */
	public static EASYBUY_PRODUCT_CATEGORY selectById(int id) {
		EASYBUY_PRODUCT_CATEGORY pc = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			// 将查询结果封装到商品分类对象中
			while (rs.next()) {
				pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return pc;  // 返回商品分类对象
	}

	/**
	 * 插入商品分类
	 * @param pc 商品分类对象
	 * @return 受影响行数
	 */
	public static int insert(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,?)";
		Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID() };
		return Basedao.exectuIUD(sql, params);  // 执行插入操作并返回受影响行数
	}

	/**
	 * 插入商品分类（无父分类）
	 * @param pc 商品分类对象
	 * @return 受影响行数
	 */
	public static int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,0)";
		Object[] params = { pc.getEPC_NAME() };
		return Basedao.exectuIUD(sql, params);  // 执行插入操作并返回受影响行数
	}

	/**
	 * 更新商品分类
	 * @param pc 商品分类对象
	 * @return 受影响行数
	 */
	public static int update(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "update EASYBUY_PRODUCT_CATEGORY set EPC_NAME=?," +
				"EPC_PARENT_ID=?" +
				" where EPC_ID=?";
		Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID(), pc.getEPC_ID() };
		return Basedao.exectuIUD(sql, params);  // 执行更新操作并返回受影响行数
	}

	/**
	 * 删除商品分类
	 * @param id 商品分类ID
	 * @return 受影响行数
	 */
	public static int del(int id) {
		String sql = "delete from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);  // 执行删除操作并返回受影响行数
	}

	/**
	 * 查询父分类
	 * @return 父分类集合
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_PARENT_ID = 0");
			rs = ps.executeQuery();
			// 将查询结果封装到父分类对象中
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // 将父分类对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回父分类集合
	}

	/**
	 * 查询子分类
	 * @return 子分类集合
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID!=EPC_PARENT_ID");
			rs = ps.executeQuery();
			// 将查询结果封装到子分类对象中
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // 将子分类对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // 返回子分类集合
	}
}
