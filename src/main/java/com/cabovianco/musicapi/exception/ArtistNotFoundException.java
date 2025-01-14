package com.cabovianco.musicapi.exception;

public class ArtistNotFoundException extends Exception {

    public ArtistNotFoundException() {
        super("Artist not found.");
    }

}
