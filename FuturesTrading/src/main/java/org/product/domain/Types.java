package org.product.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LN on 20/08/2018.
 * 商品类别
 */

@Data
@Entity
//@Table(name ="types")
public class Types implements Serializable {

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long parent_id; //父类id
    private String name; //

}
