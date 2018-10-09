package org.product.service;



import org.product.domain.Product;

import java.util.List;


public interface ProductService {
    //通过名字查找
    List<Product> selectProductByName(String name);
    //通过type_id查找
    List<Product> selectProductByTypeId( long id);

    //通过id查找
    Product selectProductById( long id);
    //通过id更新状态
    void  updatePorductById( long id);

    List<Product> selectProductFindAll();

}
