package org.product.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.product.domain.Types;

import java.util.List;

/**
 * @Description:商品分类
 * @author zjc
 */
@Mapper
public interface TypesDao {


    //通过父类id找到子类名字
    @Select("select name from types where parent_id=#{id}")
    List<String> selectSeName(@Param("id") long id);

    //通过名字找到对应id
    @Select("select id from types where name=#{name}")
    long selectNameid(@Param("name") String name);

    //通过父类id找子类id
    @Select("select id from types where parent_id=#{id}")
    long[] selectSeid(@Param("id") long id);

    @Select("select * from types ")
    Types selectfindAll();


    @Select("Select name from types where parent_id is null")
    List<String> selectName();

}
