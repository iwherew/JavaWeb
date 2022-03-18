package com.amadeus.mapper;

import com.amadeus.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    // 查询所有
    List<Brand> selectAll();

    // 查询单条数据
    Brand selectById(int id);

    // 查询多个条件
    // 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
//    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);
    // 对象参数，在同一个实体类中
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    // 单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    // 添加
    void add(Brand brand);

    // 全量修改
    void fullUpdate(Brand brand);

    // 动态修改字段
    void update(Brand brand);

    // 单个删除
    void deleteById(int id);

    // 批量删除
    void deleteByIds(@Param("ids") int[] ids);

    // 注解写简单sql
    // 查询 @Select
    // 添加 @Insert
    // 修改 @Update
    // 删除 @Delete
    @Select("select * from tb_brand where id = #{id}")
    Brand selectByIdThroughAnnotate(int id);
}
