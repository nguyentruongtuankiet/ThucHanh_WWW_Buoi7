package vn.edu.iuh.fit.thwww_buoi7.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Order;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
