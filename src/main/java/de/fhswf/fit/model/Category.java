package de.fhswf.fit.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
public class Category
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ManyToOne
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}
