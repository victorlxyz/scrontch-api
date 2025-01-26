package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.victorl.scrontch.users.entity.EssentialIngredient;
import xyz.victorl.scrontch.common.entity.User;

import java.util.List;

public interface EssentialIngredientRepository extends JpaRepository<EssentialIngredient, Integer> {
    List<EssentialIngredient> findByUserid(User user);

    @Modifying
    @Query("DELETE FROM EssentialIngredient ui WHERE ui.userid.id = :userId AND ui.ingredientid = :ingredientId")
    void deleteByUserIdAndIngredientId(@Param("userId") Integer userId, @Param("ingredientId") Integer ingredientId);

    @Query("SELECT COUNT(ui) > 0 FROM EssentialIngredient ui WHERE ui.userid.id = :userId AND ui.ingredientid = :ingredientId")
    boolean existsByUserIdAndIngredientId(@Param("userId") Integer userId, @Param("ingredientId") Integer ingredientId);

}
