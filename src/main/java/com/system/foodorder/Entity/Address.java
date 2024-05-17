package com.system.foodorder.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Address {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name ="country")
    private String country;

}
