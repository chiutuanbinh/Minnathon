package com.minnathon.stresskiller;

import java.io.Serializable;

/**
 * Created by Anh on 1/20/2018.
 */

public class Film implements Serializable {
    private int filmId;
    private String filmTitle;
    private String filmLink;

    public Film(String filmTitle, String filmLink){
        this.filmTitle = filmTitle;
        this.filmLink = filmLink;
    }
    public Film(int filmId, String filmTitle, String filmLink) {
        this.filmId= filmId;
        this.filmTitle = filmTitle;
        this.filmLink= filmLink;
    }

    public String getFilmTitle(){
        return this.filmTitle;
    }
    public String getFilmLink(){
        return this.filmLink;
    }

}
