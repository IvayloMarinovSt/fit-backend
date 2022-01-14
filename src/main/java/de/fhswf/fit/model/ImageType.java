package de.fhswf.fit.model;

public enum ImageType
{
    JPEG("jpeg"),
    PNG("png"),
    JPG("jpg"),
    GIF("gif");

    private final String label;

    private ImageType(String label)
    {
        this.label = label;
    }
}
