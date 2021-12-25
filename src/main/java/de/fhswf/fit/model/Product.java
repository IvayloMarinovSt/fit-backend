package de.fhswf.fit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Document
public class Product {

    @Id
    private String id;

    private String productNumber;

    private String name;

    private BigDecimal price;

    private List<String> imageIds;

    private List<String> categoryIds;

    private Integer inStock;

    private String description;

    public Product() {
    }

    public Product(String id, String productNumber, String name, BigDecimal price, List<String> imageIds, List<String> categoryIds, Integer inStock, String description) {
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
