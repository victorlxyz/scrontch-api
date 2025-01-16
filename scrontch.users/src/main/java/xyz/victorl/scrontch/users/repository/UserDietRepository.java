package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserDiet;

import java.util.List;

public interface UserDietRepository extends JpaRepository<UserDiet, Integer> {
    List<UserDiet> findByUserid(User user);

    @Modifying
    @Query("DELETE FROM UserDiet ui WHERE ui.userid.id = :userId AND ui.dietid = :dietId")
    void deleteByUserIdAndDietId(@Param("userId") Integer userId, @Param("dietId") Integer dietId);

    @Query("SELECT COUNT(ui) > 0 FROM UserDiet ui WHERE ui.userid.id = :userId AND ui.dietid = :dietId")
    boolean existsByUserIdAndDietId(@Param("userId") Integer userId, @Param("dietId") Integer dietId);

}
