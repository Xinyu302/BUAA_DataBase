package com.yxy.market1.mapper;

import com.yxy.market1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductMapper extends JpaRepository<Product,Integer> {
    @Query
    List<Product> findByIdIn(List<Integer> ids);

    @Query
    List<Product> findProductsByCategory(String category);

//    @Query(value = "select t from Product t where t.name like '?1'")
    @Query
    List<Product> findProductsByNameLike(String name);

    @Query(value = "select p.sellerid FROM Product p where p.id=?1")
    Integer findSellerIdById(Integer id);

    @Modifying
    @Transactional
    @Query("update Product p set p.status=?2 where p.id=?1")
    void updateStatusById(Integer id, String status);
}
