package com.cabovianco.musicapi.exception;

public class SongNotFoundException extends Exception {

    public SongNotFoundException() {
        super("Song not found.");
    }

}
