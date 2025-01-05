package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_gen")
    @SequenceGenerator(name = "recipe_id_gen", sequenceName = "recipe_recipeid_seq", allocationSize = 1)
    @Column(name = "recipeid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @Column(name = "portions", nullable = false)
    private Double portions;

    @Column(name = "notes", length = 2000)
    private String notes;

    @Column(name = "image", nullable = false, length = 150)
    private String image;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeid", nullable = false)
    private Type typeid;

    @ManyToMany
    @JoinTable(name = "recipecountry",
            joinColumns = @JoinColumn(name = "recipeid"),
            inverseJoinColumns = @JoinColumn(name = "countryid"))
    private Set<Country> countries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recipeid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Recipediet> recipediets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recipeid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Step> steps = new LinkedHashSet<>();

    @PrePersist
    public void prePersist() {
        if (createdat == null) {
            createdat = Instant.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedat = Instant.now();
    }

    @Transient
    public String getFormattedTotalTime() {
        if (steps == null || steps.isEmpty()) {
            return "0 m";
        }

        // Calculate total time in minutes
        int totalMinutes = steps.stream()
                .mapToInt(Step::getLength)
                .sum();

        // Convert to hours and minutes
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        // Format in French style
        if (hours > 0) {
            return minutes > 0 ? String.format("%d h %d", hours, minutes) : String.format("%d h", hours);
        } else {
            return String.format("%d m", minutes);
        }
    }
}
