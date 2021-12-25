package de.fhswf.fit.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Image {
    @Id
    private String id;

    private String name;

    private Binary data;

    private ImageType type;

    public Image(String id, String name, Binary data, ImageType type) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.type = type;
    }
}
