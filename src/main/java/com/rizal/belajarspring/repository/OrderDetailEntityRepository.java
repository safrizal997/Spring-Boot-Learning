package com.rizal.belajarspring.repository;

import com.rizal.belajarspring.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, String> {

    /*
    =NATIVE QUERY
    @Query(value = "select * from order_detail_tbl where order_id = ?1 and order_detail_id = ?2", nativeQuery = true)

    =JPQL (Java Persistence Query Language)
    @Query(value = "select o from OrderDetailEntity o where o.orderId = ?1 and o.orderDetailId = ?2")
     */

    List<OrderDetailEntity> findByOrderId(String orderId);

}
