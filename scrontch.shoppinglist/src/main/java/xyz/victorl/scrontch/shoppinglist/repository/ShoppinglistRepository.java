package xyz.victorl.scrontch.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;

public interface ShoppinglistRepository extends JpaRepository<Shoppinglist, Integer> {
}
