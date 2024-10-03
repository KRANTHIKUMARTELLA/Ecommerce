package com.ecommerce.requestwrapper;

import com.ecommerce.model.Catogery;
import lombok.Data;

@Data
public class ProductRequest {

    private String productName;
    private Integer price;
    private String productPic;
    private Integer productQuantity;
    private Catogery catogery;

}
