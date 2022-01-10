package de.fhswf.fit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Lob
    @Column
    private byte[] data;

    @Column
    private ImageType type;

    public Image() {
    }

    public Image(Long id, String name, byte[] data, ImageType type) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.type = type;
    }

}
