package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserFavorite;
import xyz.victorl.scrontch.users.entity.UserIngredient;

import java.util.List;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredient, Integer> {

    List<UserIngredient> findByUserid(User user);

    @Modifying
    @Query("DELETE FROM UserIngredient ui WHERE ui.userid.id = :userId AND ui.ingredientid = :ingredientId")
    void deleteByUserIdAndIngredientId(@Param("userId") Integer userId, @Param("ingredientId") Integer ingredientId);

    @Query("SELECT COUNT(ui) > 0 FROM UserIngredient ui WHERE ui.userid.id = :userId AND ui.ingredientid = :ingredientId")
    boolean existsByUserIdAndIngredientId(@Param("userId") Integer userId, @Param("ingredientId") Integer ingredientId);

}

