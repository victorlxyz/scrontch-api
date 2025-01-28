package xyz.victorl.scrontch.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.common.entity.Nonfooditem;

public interface NonfooditemRepository extends JpaRepository<Nonfooditem, Integer> {
}
