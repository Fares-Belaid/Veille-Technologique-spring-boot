package com.stage.veilleTech.exception;

public enum ErrorCodes {

    FORMATION_NOT_FOUND(1000),
    FORMATION_NOT_VALID(1001),

    COLLABORATEUR_NOT_FOUND(2000),
    COLLABORATEUR_NOT_VALID(2001),

    COMMENTAIRE_NOT_FOUND(3000),
    COMMENTAIRE_VALID(3001),

    RATING_NOT_FOUND(4000),
    RATING_CLIENT_NOT_VALID(4001),


    RESSOURCE_NOT_FOUND(5000),
    RESSOURCE_NOT_VALID(5001),

    UPDATE_PHOTO_EXCEPTION(6000),

    UNKNOWN_CONTEXT(7000)
    ;

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
