package de.fhswf.fit.model;

public enum ImageType {
    JPEG("jpeg"),
    PNG("png"),
    GIF("gif");

    private String label;

    private ImageType(String label){
        this.label = label;
    }
}
