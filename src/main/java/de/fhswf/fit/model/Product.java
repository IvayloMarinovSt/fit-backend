package de.fhswf.fit.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

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
    private Long id;

//    @Column(unique = true)
    private String productNumber;

    private String name;

    private BigDecimal price;

    private Integer inStock;

    private String description;

    @ManyToMany
    private List<Image> images;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}
