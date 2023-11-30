package vn.edu.iuh.fit.thwww_buoi7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    @Query("SELECT o.order_id, o.orderDate, o.customer.id, o.employee.id, od.note, od.price, od.quantity, od.product.id " +
            "FROM Order o INNER JOIN o.orderDetails od " +
            "WHERE YEAR(o.orderDate) = :year AND MONTH(o.orderDate) = :month")
    List<Object[]> getOrderDetailsByYearAndMonth(
            @Param("year") int year,
            @Param("month") int month
    );
    @Query("SELECT DISTINCT MONTH(o.orderDate) AS orderMonth, YEAR(o.orderDate) AS orderYear " +
            "FROM Order o")
    List<Object[]> getAllOrderMonthsAndYears();


}
