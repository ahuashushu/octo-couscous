package org.product.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LN on 20/08/2018.
 * 商品
 */
@Entity
@Data
public class Product implements Serializable {

//    private static final long serialVersionUID = 1L;
    //相当于java类的身份证.保证序列化的成功，版本的兼容性


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;

    private long type_id;  //商品类别Id

    private long user_id;
    private String status;  //状态
    private String sub_images; //商品图片
    private String detail;  //商品信息
    private double price;
    private double old_price;
    private Date create_time;
    private Date update_time;

}
