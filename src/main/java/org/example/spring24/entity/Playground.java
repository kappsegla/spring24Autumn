package org.example.spring24.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

@Entity
@Setter
@Getter
@Table(name = "playground", schema = "mydatabase")
public class Playground {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Point<G2D> coordinate;

}
