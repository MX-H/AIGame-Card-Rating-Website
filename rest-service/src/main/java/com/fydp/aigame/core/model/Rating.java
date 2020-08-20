package com.fydp.aigame.core.model;

class Rating {
    private String archetype;
    private String rating;
    private String comment;
    private String cardId;

    public Rating(String archetype, String rating, String comment, String cardId) {
        this.archetype = archetype;
        this.rating = rating;
        this.comment = comment;
        this.cardId = cardId;
    }

    public String getArchetype() {
        return this.archetype;
    }

    public String getRating() {
        return this.rating;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCardId() {
        return this.cardId;
    }
}