package innowise.internship.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column
    private String comment;

    @Column(length = 50)
    private String status = "In process";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("user=" + user)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("phone='" + phone + "'")
                .add("email='" + email + "'")
                .add("address='" + address + "'")
                .add("comment='" + comment + "'")
                .add("status='" + status + "'")
                .add("createdAt=" + createdAt)
                .add("orderItems=" + orderItems.stream().map(el -> el.getProduct().getId()).toList())
                .toString();
    }
}

