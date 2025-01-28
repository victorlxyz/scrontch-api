package xyz.victorl.scrontch.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.common.entity.Shoppinglist;

import java.util.List;

public interface ShoppinglistRepository extends JpaRepository<Shoppinglist, Integer> {
    List<Shoppinglist> findByUserid(Integer userid);

    boolean existsByUseridAndName(Integer userId, String listeDeCourses);
}
