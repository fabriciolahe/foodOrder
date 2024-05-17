package com.system.foodorder.Entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

import java.time.OffsetDateTime;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Order {

    @Id
    @EqualsAndHashCode.Include
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id" ,referencedColumnName = "id" ,nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "address_id" ,referencedColumnName ="id" ,nullable = false)
    private Address deliveryAddress;

    @Column(name = "pilotes_number")
    private Integer pilotesNumber;

    @Column(name = "order_total")
    private double orderTotal;

    @Column(name = "email")
    private String email;

    @Column(name ="create_at")
    private OffsetDateTime createdAt;

    public boolean isRightPilotasNumber(List<Integer> possibleValue) {
        return possibleValue.contains(this.pilotesNumber);
    }
}
