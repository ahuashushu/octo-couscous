package org.product.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.product.domain.Warehouse;

import java.util.Date;
import java.util.List;

@Mapper
public interface WarehouseDao {
    //通过用户id找账单
    @Select("select * from warehouse where user_id like #{id} ")
    List<Warehouse> selectWarehouseByUserId(@Param("id") long id);

    //插入商品
    @Insert("insert into warehouse(uid,name,num,price,"
            + "type_id,sub_images,direction,detail,create_time,user_id) "
            + " values(#{uid},#{name},#{num}, #{price}, " +
            "#{type_id},#{sub_images},#{direction},#{detail}," +
            "#{create_time},#{direction},#{user_id})")
    int insertWarehouse(
                         @Param("uid") long uid,
                         @Param("user_id") long user_id,
                         @Param("name") String name,
                         @Param("num") int num,
                         @Param("price") double price,
                         @Param("type_id") long type_id,
                         @Param("sub_images") String sub_images,
                         @Param("direction") boolean direction,
                         @Param("detail") String detail,
                         @Param("create_time") Date create_time
//                         @Param("update_time") Data update_time,
//                         @Param("old_price") double old_price
    );
}
