package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "useringredient")
public class UserIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "useringredient_id_gen")
    @SequenceGenerator(name = "useringredient_id_gen", sequenceName = "useringredient_useringredientid_seq", allocationSize = 1)
    @Column(name = "useringredientid", nullable = false)
    private Integer id;

    @Column(name = "ingredientid", nullable = false)
    private Integer ingredientid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;
}