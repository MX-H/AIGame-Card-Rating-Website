package com.fydp.aigame.core.model;

public class Card {
    private String id;
    private String name;
    private String description;
    private Image image;

    public Card(String id, String name, String description, Image image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return this.id
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Image getImage() {
        return this.image;
    }

}

