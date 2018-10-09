package org.product.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long uid;  //8位随机数 s b
    private long user_id;
    private double price;
    private int num;
    private boolean direction; // 1卖 0买
    private Date create_time;
    private String name;
    private String detail;  //详情
    private long type_id;
    private String sub_images;
    private double old_price;
    private Date update_time;
}
