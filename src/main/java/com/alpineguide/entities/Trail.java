package com.alpineguide.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "trails")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private double distance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
