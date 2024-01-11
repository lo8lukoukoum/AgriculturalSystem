package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

// ��Ʒ�������ݷ�����
public class EASYBUY_PRODUCT_CATEGORYDao {

	/**
	 * ��ѯ������Ʒ����
	 * @return ��Ʒ���༯��
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY");
			rs = ps.executeQuery();
			// ����ѯ�����װ����Ʒ���������
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // ����Ʒ���������ӵ�������
			}
		} catch (SQLException e) {
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // ������Ʒ���༯��
	}

	/**
	 * ������Ʒ����ID��ѯ������Ʒ����
	 * @param id ��Ʒ����ID
	 * @return ��Ʒ�������
	 */
	public static EASYBUY_PRODUCT_CATEGORY selectById(int id) {
		EASYBUY_PRODUCT_CATEGORY pc = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			// ����ѯ�����װ����Ʒ���������
			while (rs.next()) {
				pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
			}
		} catch (SQLException e) {
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return pc;  // ������Ʒ�������
	}

	/**
	 * ������Ʒ����
	 * @param pc ��Ʒ�������
	 * @return ��Ӱ������
	 */
	public static int insert(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,?)";
		Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID() };
		return Basedao.exectuIUD(sql, params);  // ִ�в��������������Ӱ������
	}

	/**
	 * ������Ʒ���ࣨ�޸����ࣩ
	 * @param pc ��Ʒ�������
	 * @return ��Ӱ������
	 */
	public static int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,0)";
		Object[] params = { pc.getEPC_NAME() };
		return Basedao.exectuIUD(sql, params);  // ִ�в��������������Ӱ������
	}

	/**
	 * ������Ʒ����
	 * @param pc ��Ʒ�������
	 * @return ��Ӱ������
	 */
	public static int update(EASYBUY_PRODUCT_CATEGORY pc) {
		String sql = "update EASYBUY_PRODUCT_CATEGORY set EPC_NAME=?," +
				"EPC_PARENT_ID=?" +
				" where EPC_ID=?";
		Object[] params = { pc.getEPC_NAME(), pc.getEPC_PARENT_ID(), pc.getEPC_ID() };
		return Basedao.exectuIUD(sql, params);  // ִ�и��²�����������Ӱ������
	}

	/**
	 * ɾ����Ʒ����
	 * @param id ��Ʒ����ID
	 * @return ��Ӱ������
	 */
	public static int del(int id) {
		String sql = "delete from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);  // ִ��ɾ��������������Ӱ������
	}

	/**
	 * ��ѯ������
	 * @return �����༯��
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_PARENT_ID = 0");
			rs = ps.executeQuery();
			// ����ѯ�����װ�������������
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // �������������ӵ�������
			}
		} catch (SQLException e) {
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // ���ظ����༯��
	}

	/**
	 * ��ѯ�ӷ���
	 * @return �ӷ��༯��
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild() {
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();  // ��ȡ���ݿ�����
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID!=EPC_PARENT_ID");
			rs = ps.executeQuery();
			// ����ѯ�����װ���ӷ��������
			while (rs.next()) {
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(
						rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"),
						rs.getInt("EPC_PARENT_ID")
				);
				list.add(pc);  // ���ӷ��������ӵ�������
			}
		} catch (SQLException e) {
			// ��ӡ�쳣��Ϣ
			e.printStackTrace();
		} finally {
			// �ر���Դ
			Basedao.closeall(rs, ps, conn);
		}
		return list;  // �����ӷ��༯��
	}
}
