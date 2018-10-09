package org.product.service;

import java.util.Date;
import java.util.List;

public interface WarehouseService {
    List selectWarehouseByUserId(long id);
    int insertWarehouse(long uid, String name, int num, double price, long type_id,
                        String sub_images, boolean direction, String detail,
                        Date create_time, long user_id);
}
