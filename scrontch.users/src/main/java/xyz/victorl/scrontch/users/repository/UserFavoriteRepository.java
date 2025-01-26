package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.victorl.scrontch.common.entity.User;
import xyz.victorl.scrontch.users.entity.UserFavorite;

import java.util.List;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer> {
    List<UserFavorite> findByUserid(User user);

    @Modifying
    @Query("DELETE FROM UserFavorite ui WHERE ui.userid.id = :userId AND ui.recipeid = :recipeId")
    void deleteByUserIdAndRecipeId(@Param("userId") Integer userId, @Param("recipeId") Integer recipeId);

    @Query("SELECT COUNT(ui) > 0 FROM UserFavorite ui WHERE ui.userid.id = :userId AND ui.recipeid = :recipeid")
    boolean existsByUserIdAndRecipeId(@Param("userId") Integer userId, @Param("recipeId") Integer ingredientId);

}
