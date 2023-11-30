package vn.edu.iuh.fit.thwww_buoi7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.ProductPrice;

import java.util.List;
import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Product>, JpaSpecificationExecutor<ProductPrice> {

    @Query("SELECT pp FROM ProductPrice pp WHERE pp.product = :product")
    List<ProductPrice> findByProduct(Product product);
}
