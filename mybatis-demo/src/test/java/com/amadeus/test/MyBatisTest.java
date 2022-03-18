package com.amadeus.test;

import com.amadeus.mapper.BrandMapper;
import com.amadeus.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 接收参数
        int id = 1;

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "公司";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        // 封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "公司";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        // 封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "步步高";
        String brandName = "oppo";
        int ordered = 20;
        String description = "拍照";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.add(brand);

        // 手动提交事务
//        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "步步高";
        String brandName = "oppo";
        int ordered = 20;
        String description = "拍照";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.add(brand);
        // 获取新增数据的id，需要设置 useGeneratedKeys="true" keyProperty="id"
        Integer id = brand.getId();
        System.out.println(id);

        // 手动提交事务
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    // 全量修改
    @Test
    public void testFullUpdate() throws IOException {
        // 接收参数
        int id = 9;
        int status = 1;
        String companyName = "步步高";
        String brandName = "vivo";
        int ordered = 30;
        String description = "音乐";

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setId(id);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.fullUpdate(brand);

        // 手动提交事务
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    // 动态修改
    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        int id = 8;
        int status = 1;
        String companyName = "步步高";
        String brandName = "vivo";
        int ordered = 30;
        String description = "音乐";

        // 封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
//        brand.setOrdered(ordered);
//        brand.setDescription(description);
        brand.setId(id);

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.update(brand);

        // 手动提交事务
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    // 单个删除
    @Test
    public void testDeleteById() throws IOException {
        // 接收参数
        int id = 8;

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.deleteById(id);

        // 手动提交事务
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    // 批量删除
    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数
        int[] ids = {9,10};

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        brandMapper.deleteByIds(ids);

        // 手动提交事务
        sqlSession.commit();

        // 5、释放资源
        sqlSession.close();
    }

    // 批量删除
    @Test
    public void testSelectByIdThroughAnnotate() throws IOException {
        int id = 2;

        // 1、获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取 SqlSession对象，用它执行SQL
        // 需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4、执行方法
        Brand brand = brandMapper.selectByIdThroughAnnotate(id);
        System.out.println(brand);

        // 5、释放资源
        sqlSession.close();
    }
}
