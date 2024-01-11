package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_DD;

// 订单详情数据访问类
public class EASYBUY_DDDao {

	// 根据订单ID查询订单详情
	public static ArrayList<EASYBUY_DD> selectById(int id) {
		ArrayList<EASYBUY_DD> dd = new ArrayList<EASYBUY_DD>();
		Connection conn = Basedao.getconn();  // 获取数据库连接
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 准备查询语句，关联三个表查询订单详情相关信息
			ps = conn.prepareStatement("select * from EASYBUY_ORDER eo, EASYBUY_ORDER_DETAIL eod, EASYBUY_PRODUCT ep where eo.eo_id=? and eod.eo_id=eo.eo_id and eod.ep_id=ep.ep_id");
			ps.setInt(1, id);
			rs = ps.executeQuery();  // 执行查询
			// 将结果集封装到订单详情对象中
			while (rs.next()) {
				EASYBUY_DD d = new EASYBUY_DD(
						rs.getString("EP_NAME"),
						rs.getString("EP_FILE_NAME"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EOD_QUANTITY"),
						rs.getInt("EP_STOCK")
				);
				dd.add(d);  // 将订单详情对象添加到集合中
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭资源
			Basedao.closeall(rs, ps, conn);
		}
		return dd;  // 返回订单详情集合
	}
}
