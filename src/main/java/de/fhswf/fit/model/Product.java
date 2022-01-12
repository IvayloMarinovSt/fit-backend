package de.fhswf.fit.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String productNumber;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    @OneToMany
    private Integer imageIds;

    @Column
    @OneToMany
    private Integer categoryIds;

    @Column
    private Integer inStock;

    @Column
    private String description;


}
