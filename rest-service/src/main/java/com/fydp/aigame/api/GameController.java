package com.fydp.aigame.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fydp.aigame.core.dao.CardRepository;
import com.fydp.aigame.core.dao.impl.CardRepositoryImpl;
import com.fydp.aigame.core.model.Card;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@RestController
public class GameController {
    private CardRepository cardRepository = new CardRepositoryImpl();
    private RatingRepository ratingRepository = new RatingRepositoryImpl();

    @CrossOrigin
    @GetMapping("/card")
    public Card getRandomCard() {
        Card card = cardRepository.getRandomCard();
        return card;
    }

    @CrossOrigin
    @PostMapping("/rating")
    public ResponseEntity<?> createRating(@Valid @RequestBody RatingParam ratingParam) {
        Rating rating = new Rating(ratingParam.getArchetype(),
                ratingParam.getRating(),
                ratingParam.getComment(),
                ratingParam.getCardId());
        ratingRepository.save(rating);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

@JsonRootName("rating")
class RatingParam {
    @NotBlank(message = "can't be empty")
    private String archetype;
    private String rating;
    private String comment;
    private String cardId;

    public RatingParam() {
        this.archetype = null;
        this.rating = null;
        this.comment = null;
        this.cardId = null;
    }

    public RatingParam(String archetype, String rating, String comment, String cardId) {
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