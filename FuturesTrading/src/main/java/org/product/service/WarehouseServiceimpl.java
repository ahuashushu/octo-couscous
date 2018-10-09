package org.product.service;

import org.product.dao.WarehouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class WarehouseServiceimpl implements WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public List selectWarehouseByUserId(long id) {
        return warehouseDao.selectWarehouseByUserId(id);
    }

    @Override
    public int insertWarehouse(long uid, String name, int num, double price,
                               long type_id, String sub_images, boolean direction,
                               String detail, Date create_time, long user_id) {
        return warehouseDao.insertWarehouse(uid,user_id,name,num,price,type_id,
                sub_images,direction,detail,create_time);
    }
}
