package xyz.victorl.scrontch.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.shoppinglist.entity.Recipelist;

import java.util.List;

public interface RecipelistRepository extends JpaRepository<Recipelist, Integer> {
    List<Recipelist> findByUserid(Integer userid);
}
