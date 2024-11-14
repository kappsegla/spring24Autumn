package org.example.spring24.apiauth;

import jakarta.persistence.*;

@Entity
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
