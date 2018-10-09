package org.product.service;

import org.product.dao.ProductDao;
import org.product.domain.Product;
import org.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> selectProductByName(String name) {
        return productDao.selectProductByName(name);
    }

    @Override
    public List<Product> selectProductByTypeId(long id) {
        return productDao.selectProductByTypeId(id);
    }

    @Override
    public Product selectProductById(long id) {
        return productDao.selectProductById(id);
    }

    @Override
    public void updatePorductById(long id) {
        productDao.updatePorductById(id);
    }

    @Override
    public List<Product> selectProductFindAll() {
        return productDao.selectProductFindAll();
    }
}
