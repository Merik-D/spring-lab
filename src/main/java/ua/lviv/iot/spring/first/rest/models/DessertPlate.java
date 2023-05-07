package ua.lviv.iot.spring.first.rest.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DessertPlate extends Plate {
    private boolean picture;
    private int sections;
    private Integer id;

    public DessertPlate(final double diameter,
                        final String material,
                        final String color,
                        final boolean isClean,
                        final boolean hasFood,
                        final boolean picture,
                        final int sections) {
        super(diameter, material, color, isClean, hasFood);
        this.picture = picture;
        this.sections = sections;
    }

    @Override
    public final double getMaxFoodWeight() {
        return Math.PI * getDiameter() * getDiameter() * getDiameter() / 24;
    }

//    public final String getHeaders() {
//        return super.getHeaders() + ", picture, sections";
//    }
//
//    public final String toCSV() {
//        return super.toCSV() + ", " + picture + ", " + sections;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
