package innowise.internship.onlineshop.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


}
