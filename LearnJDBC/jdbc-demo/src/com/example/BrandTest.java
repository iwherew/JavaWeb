package com.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 增删改查
 * */

public class BrandTest {

    /**
     * 查询所有
     * 1、SQL: select * from tb_brand;
     * 2、参数：不需要
     * 3、结果： List<Brand>
     * */
    @Test
    public void testSelectAll() throws Exception {
        // 1、获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // 2、定义sql
        String sql = "select * from tb_brand";

        // 3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4、设置参数

        // 5、执行SQL
        ResultSet rs = pstmt.executeQuery();

        List<Brand> list = new ArrayList<>();
        // 6、处理结果
        while(rs.next()){
            Brand brand = new Brand();
            brand.setId(rs.getInt("id"));
            brand.setBrandName(rs.getString("brand_name"));
            brand.setCompanyName(rs.getString("company_name"));
            brand.setOrdered(rs.getInt("ordered"));
            brand.setDescription(rs.getString("description"));
            brand.setStatus(rs.getInt("status"));
            list.add(brand);
        }

        System.out.println(list);

        // 7、释放资源
        pstmt.close();
        rs.close();
        conn.close();


    }

    /**
     * 新增
     * 1、SQL: insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
     * 2、参数：需要，除了id之外的所有信息
     * 3、结果：boolean
     * */
    @Test
    public void testAdd() throws Exception {
        // 接受页面提交的参数
        String brandName = "IPhone";
        String companyName = "Apple";
        Integer ordered = 1;
        String description = "苹果";
        Integer status = 1;

        // 1、获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // 2、定义sql
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";

        // 3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4、设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        // 5、执行SQL
        int count = pstmt.executeUpdate();

        // 6、处理结果
        System.out.println(count > 0 ? "成功": "失败");

        // 7、释放资源
        pstmt.close();
        conn.close();
    }

    /**
     * 修改
     * 1、SQL: update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?;
     * 2、参数：需要，所有信息
     * 3、结果：boolean
     * */
    @Test
    public void testUpdate() throws Exception {
        // 接受页面提交的参数
        String brandName = "IPhone 4";
        String companyName = "Apple";
        Integer ordered = 10;
        String description = "苹果全家桶";
        Integer status = 1;
        Integer id = 4;

        // 1、获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // 2、定义sql
        String sql = "update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?";

        // 3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4、设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        // 5、执行SQL
        int count = pstmt.executeUpdate();

        // 6、处理结果
        System.out.println(count > 0 ? "成功": "失败");

        // 7、释放资源
        pstmt.close();
        conn.close();
    }

    /**
     * 删除
     * 1、SQL: delete from tb_brand where id = ?;
     * 2、参数：需要，id
     * 3、结果：boolean
     * */
    @Test
    public void testDeleteById() throws Exception {
        // 接受页面提交的参数
        Integer id = 4;

        // 1、获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        // 2、定义sql
        String sql = "delete from tb_brand where id = ?";

        // 3、获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 4、设置参数
        pstmt.setInt(1,id);

        // 5、执行SQL
        int count = pstmt.executeUpdate();

        // 6、处理结果
        System.out.println(count > 0 ? "成功": "失败");

        // 7、释放资源
        pstmt.close();
        conn.close();
    }
}
