package de.fhswf.fit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String productNumber;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private List<String> imageIds;

    @Column
    private List<String> categoryIds;

    @Column
    private Integer inStock;

    @Column
    private String description;

    public Product() {
    }

    public Product(Long id, String productNumber, String name, BigDecimal price, List<String> imageIds, List<String> categoryIds, Integer inStock, String description) {
        this.id = id;
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.imageIds = imageIds;
        this.categoryIds = categoryIds;
        this.inStock = inStock;
        this.description = description;
    }
}
