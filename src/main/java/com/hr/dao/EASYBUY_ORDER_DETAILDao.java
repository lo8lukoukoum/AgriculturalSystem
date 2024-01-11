package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_ORDER_DETAIL;

// �����������ݷ�����
public class EASYBUY_ORDER_DETAILDao {

	// ��ѯ���ж�������
	public static ArrayList<EASYBUY_ORDER_DETAIL> selectAll() {
		ArrayList<EASYBUY_ORDER_DETAIL> list = new ArrayList<EASYBUY_ORDER_DETAIL>();
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ׼����ѯ���
			ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL");
			rs = ps.executeQuery();  // ִ�в�ѯ
			// ���������װ���������������
			while (rs.next()) {
				EASYBUY_ORDER_DETAIL c = new EASYBUY_ORDER_DETAIL(
						rs.getInt("EOD_ID"),
						rs.getInt("EO_ID"),
						rs.getInt("EP_ID"),
						rs.getInt("EOD_QUANTITY"),
						rs.getInt("EOD_COST")
				);
				list.add(c);  // ���������������ӵ�������
			}
		} catch (SQLException e) {
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // ���ض������鼯��
	}

	// ���ݶ�������ID��ѯ������������
	public static EASYBUY_ORDER_DETAIL selectById(int id) {
		EASYBUY_ORDER_DETAIL c = null;
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ׼����ѯ���
			ps = conn.prepareStatement("select * from EASYBUY_ORDER_DETAIL where EOD_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();  // ִ�в�ѯ
			// ���������װ���������������
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
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return c;  // ���ض����������
	}

	// ���붩������
	public static int insert(EASYBUY_ORDER_DETAIL od) {
		String sql = "insert into EASYBUY_ORDER_DETAIL values(null,?,?,?,?)";
		Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_COST() };
		return Basedao.exectuIUD(sql, params);  // ִ�в��������������Ӱ������
	}

	// ���¶�������
	public static int update(EASYBUY_ORDER_DETAIL od) {
		String sql = "update EASYBUY_ORDER_DETAIL set EO_ID=?,EP_ID=?,EOD_QUANTITY=?,EOD_COST=? where EOD_ID=?";
		Object[] params = { od.getEO_ID(), od.getEP_ID(), od.getEOD_QUANTITY(), od.getEOD_COST(), od.getEOD_ID() };
		return Basedao.exectuIUD(sql, params);  // ִ�и��²�����������Ӱ������
	}

	// ɾ����������
	public static int del(int id) {
		String sql = "delete from EASYBUY_ORDER_DETAIL where EOD_ID=?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);  // ִ��ɾ��������������Ӱ������
	}
}
