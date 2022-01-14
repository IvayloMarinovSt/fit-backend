package de.fhswf.fit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "product_id")
    private Integer id;

    @Column(unique = true)
    private String productNumber;

    private String name;

    private BigDecimal price;

    private Integer inStock;

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_product", referencedColumnName = "product_id")
    //    @ElementCollection
    private List<Image> images = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "category_product", referencedColumnName = "product_id")
    private List<Category> categories = new ArrayList<>();
}
