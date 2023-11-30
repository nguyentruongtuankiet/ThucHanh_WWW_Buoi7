package vn.edu.iuh.fit.thwww_buoi7.frontend.dto;

import lombok.*;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;


import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem implements Serializable {
    private Product product;
    private int amount;
}