package org.product.dao;

import org.apache.ibatis.annotations.*;
import org.product.domain.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:具体商品
 * @author zjc
 */
@Mapper
public interface ProductDao {

    //查找所有商品
    @Select("select * from product ")
    List<Product> selectProductFindAll();

    //通过名字查找商品
    @Select("select * from product where name like #{name} ")
    List<Product> selectProductByName(@Param("name") String name);

    //通过type_id查找商品
    @Select("select * from product where type_id=#{id}")
    List<Product> selectProductByTypeId(@Param("id") long id);

    //通过id查找商品
    @Select("select * from product where id=#{id}")
    Product selectProductById(@Param("id") long id);

    //通过userId查找商品
    @Select("select * from product where user_id=#{userId}")
    List<Product> selectProductByUserId(@Param("userId") int userId);


    //通过分类ID查找商品
    @Select("select * from product where category_id=#{categoryId}  and status=1  order by update_time desc limit  0,4 ")
    List<Product> selectProductByCategoryId(@Param("categoryId") Integer categoryId);


    //通过分类ID查找商品
    @Select("select * from product where category_id=#{categoryId}  and status=1")
    List<Product> selectProductBySearchCategoryId(@Param("categoryId") Integer categoryId);

    //更改产品状态
    @Update(" update product set  status=‘等待出仓’  where id=#{id}")
    void  updatePorductById(@Param("id") long id);

    //删除产品状态
    @Delete(" delete  from product where id=#{id}")
    void  deletePorductById(@Param("id") Integer id);

    //插入商品
    @Insert("insert into product(user_id,category_id,name ,subtitle,main_image,"
            + "sub_images,detail,price,old_price) "
            + " values(#{userId},#{categoryId},#{name}, #{subtitle}, #{mainImage},#{subImages},#{detail},#{price},#{oldPrice})")

    void insertProduct(@Param("userId") Integer userId,
                       @Param("categoryId") Integer categoryId,
                       @Param("name") String name,
                       @Param("subtitle") String subtitle,
                       @Param("mainImage") String mainImage,
                       @Param("subImages") String subImages,
                       @Param("detail") String detail,
                       @Param("price") BigDecimal price,
                       @Param("oldPrice") BigDecimal oldPrice);



}
