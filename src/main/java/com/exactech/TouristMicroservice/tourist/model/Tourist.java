package com.exactech.TouristMicroservice.tourist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="phone", nullable = false)
    private String phone;
    @Column(name="address", nullable = false)
    private String address;
}
