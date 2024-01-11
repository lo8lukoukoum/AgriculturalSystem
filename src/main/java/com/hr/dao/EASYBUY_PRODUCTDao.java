package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_PRODUCT;

public class EASYBUY_PRODUCTDao {


    /**
     * 查询所有
     *
     * @return
     */
	// 查询所有商品
	public static ArrayList<EASYBUY_PRODUCT> selectAll() {
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT");
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return list;
    }

    /**
     * 名字模糊查询
     *
     * @return
     */
    // 根据名称模糊查询
    public static ArrayList<EASYBUY_PRODUCT> selectAllByName(String name) {
        // 创建列表
        // 获取连接
        // 创建语句对象
        // 执行查询,遍历结果封装Product对象
        // 关闭资源
        // 返回列表
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_NAME like ?");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return list;
    }

    /**
     * 根据id查询单个
     *
     * @param id
     * @return
     */
    // 根据id查询单个商品
    public static EASYBUY_PRODUCT selectById(int id) {
        // 获取连接
        // 创建语句对象,设置id查询条件
        // 执行查询,封装Product对象
        // 关闭资源
        // 返回商品对象
        EASYBUY_PRODUCT p = null;
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return p;
    }

    /**
     * 根据fid查询所有
     *
     * @param fid
     * @return
     */
    // 根据分类id查询商品
    public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(int fid) {
        // 代码结构同上
        // 设置分类id条件查询
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_ID=?");
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return list;
    }

    /**
     * 根据cid查询所有
     *
     * @param fid
     * @return
     */
    // 根据子分类id查询商品
    public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cid) {
        // 代码结构同上
        // 设置子分类id条件查询
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return list;
    }

    // 新增商品
    public static int insert(EASYBUY_PRODUCT p) {
        // 定义sql语句
        // 封装参数
        // 执行插入操作
        // 返回受影响行数
        String sql = "insert into EASYBUY_PRODUCT values(null,?,?,?,?,?,?,?)";
        Object[] params = {p.getEP_NAME(),
                p.getEP_DESCRIPTION(),
                p.getEP_PRICE(),
                p.getEP_STOCK(),
                p.getEPC_ID(),
                p.getEPC_CHILD_ID(),
                p.getEP_FILE_NAME()};
        return Basedao.exectuIUD(sql, params);
    }

    // 更新商品
    public static int update(EASYBUY_PRODUCT p) {
        // 判断文件是否更新
        // 构建sql语句,包含文件
        // 或不包含文件
        // 封装参数
        // 执行更新操作
        // 返回受影响行数
        if (!p.getEP_FILE_NAME().equals("")) {
            String sql = "update EASYBUY_PRODUCT set EP_NAME=?," +
                    "EP_DESCRIPTION=?," +
                    "EP_PRICE=?," +
                    "EP_STOCK=?," +
                    "EPC_ID=?," +
                    "EPC_CHILD_ID=?," +
                    "EP_FILE_NAME=? " +
                    " where EP_ID=?";

            Object[] params = {p.getEP_NAME(),
                    p.getEP_DESCRIPTION(),
                    p.getEP_PRICE(),
                    p.getEP_STOCK(),
                    p.getEPC_ID(),
                    p.getEPC_CHILD_ID(),
                    p.getEP_FILE_NAME(),
                    p.getEP_ID()};
            return Basedao.exectuIUD(sql, params);
        } else {
            String sql = "update EASYBUY_PRODUCT set EP_NAME=?," +
                    "EP_DESCRIPTION=?," +
                    "EP_PRICE=?," +
                    "EP_STOCK=?," +
                    "EPC_ID=?," +
                    "EPC_CHILD_ID=? " +
                    " where EP_ID=?";
            Object[] params = {p.getEP_NAME(),
                    p.getEP_DESCRIPTION(),
                    p.getEP_PRICE(),
                    p.getEP_STOCK(),
                    p.getEPC_ID(),
                    p.getEPC_CHILD_ID(),
                    p.getEP_ID()};
            return Basedao.exectuIUD(sql, params);
        }


    }

    // 删除商品
    public static int del(int id) {
        // 定义SQL
        // 封装参数
        // 执行删除操作
        // 返回受影响行数
        String sql = "delete from EASYBUY_PRODUCT where EP_ID=?";
        Object[] params = {id};
        return Basedao.exectuIUD(sql, params);
    }

    // 计算总页数
    public static int totalPage(int count) {
        // 执行查询统计总记录数
        // 计算总页数
        // 返回结果
        int tpage = 1;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT");
            rs = ps.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt(1);//获得表的总行数
                if (sum % count == 0) {
                    tpage = sum / count;//总行数是每页行数的整倍数
                } else {
                    tpage = sum / count + 1;//不是整倍数要加一
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return tpage;
    }

    // 根据条件计算总页数
    public static int totalPageByFid(int count, int fid) {
        // 代码结构同上
        // 加入分类条件
        int tpage = 1;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_ID=?");
            ps.setInt(1, fid);
            rs = ps.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt(1);//获得表的总行数
                if (sum % count == 0) {
                    tpage = sum / count;//总行数是每页行数的整倍数
                } else {
                    tpage = sum / count + 1;//不是整倍数要加一
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return tpage;
    }

    public static int totalPageByCid(int count, int cid) {
        int tpage = 1;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt(1);//获得表的总行数
                if (sum % count == 0) {
                    tpage = sum / count;//总行数是每页行数的整倍数
                } else {
                    tpage = sum / count + 1;//不是整倍数要加一
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return tpage;
    }

    public static int totalPageByName(int count, String name) {
        int tpage = 1;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EP_NAME like ?");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                int sum = rs.getInt(1);//获得表的总行数
                if (sum % count == 0) {
                    tpage = sum / count;//总行数是每页行数的整倍数
                } else {
                    tpage = sum / count + 1;//不是整倍数要加一
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return tpage;
    }

    /**
     * 分页查询
     *
     * @param cpage
     * @param count
     * @return
     */
    public static ArrayList<EASYBUY_PRODUCT> selectAll(int cpage, int count) {
        // 计算开始行和结束行
        // 执行分页查询
        // 封装结果集
        // 返回列表
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from EASYBUY_PRODUCT order by EP_ID desc limit ?,? ";
        try {
            ps = conn.prepareStatement(sql);
            //设置数据区间
            ps.setInt(1, count * (cpage - 1));
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * fid分页查询
     *
     * @param cpage
     * @param count
     * @return
     */
    public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(int cpage, int count, int fid) {
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from EASYBUY_PRODUCT where EPC_ID = ? order by EP_ID desc limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            //设置数据区间
            ps.setInt(1, fid);
            ps.setInt(2, count * (cpage - 1));
            ps.setInt(3, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * cid分页查询
     *
     * @param cpage
     * @param count
     * @return
     */
    // 根据分类分页查询
    public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cpage, int count, int cid) {
        // 代码结构同上
        // 加入分类条件
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from EASYBUY_PRODUCT where EPC_CHILD_ID = ? order by EP_ID desc limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            //设置数据区间
            ps.setInt(1, cid);
            ps.setInt(2, count * (cpage - 1));
            ps.setInt(3, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * 根据id数组查询单个，并放入集合
     *
     * @param id
     * @return
     */
    // 根据id集合批量查询
    public static ArrayList<EASYBUY_PRODUCT> selectById(ArrayList<Integer> ids) {
        // 遍历id集合
        // 执行单个查询并添加到结果列表中
        // 返回列表
        ArrayList<EASYBUY_PRODUCT> lastlylist = new ArrayList<EASYBUY_PRODUCT>();
        EASYBUY_PRODUCT p = null;
        ResultSet rs = null;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        try {
            for (int i = 0; i < ids.size(); i++) {
                ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
                ps.setInt(1, ids.get(i));
                rs = ps.executeQuery();
                while (rs.next()) {
                    p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                            rs.getString("EP_NAME"),
                            rs.getString("EP_DESCRIPTION"),
                            rs.getInt("EP_PRICE"),
                            rs.getInt("EP_STOCK"),
                            rs.getInt("EPC_ID"),
                            rs.getInt("EPC_CHILD_ID"),
                            rs.getString("EP_FILE_NAME"));
                    lastlylist.add(p);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }
        return lastlylist;
    }

    /**
     * 查询特价商品
     *
     * @return
     */
    public static ArrayList<EASYBUY_PRODUCT> selectAllByT() {
        // 使用数据库排序和限制查询特价商品
        // 封装并返回结果列表
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from EASYBUY_PRODUCT order by EP_PRICE asc limit 0,9";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }

        return list;
    }

    /**
     * 查询热卖商品
     *
     * @return
     */
    public static ArrayList<EASYBUY_PRODUCT> selectAllByHot() {
        // 使用数据库多表关联查询热卖商品
        // 封装并返回结果列表
        ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ( select tab1.* from  (  select * from easybuy_product a,  (select ep_id eod_ep_id,sum(EOD_QUANTITY) buysum from EASYBUY_ORDER_DETAIL  group by EP_id order by sum(EOD_QUANTITY) desc) b  where a.ep_id=b.eod_ep_id order by buysum desc  ) tab1) tab2 limit 0,8";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
                        rs.getString("EP_NAME"),
                        rs.getString("EP_DESCRIPTION"),
                        rs.getInt("EP_PRICE"),
                        rs.getInt("EP_STOCK"),
                        rs.getInt("EPC_ID"),
                        rs.getInt("EPC_CHILD_ID"),
                        rs.getString("EP_FILE_NAME"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }

        return list;
    }
}
