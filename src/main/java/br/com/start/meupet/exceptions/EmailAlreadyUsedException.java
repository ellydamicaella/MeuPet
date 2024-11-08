package br.com.start.meupet.exceptions;

import java.io.Serial;

public class EmailAlreadyUsedException extends RuntimeException {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public EmailAlreadyUsedException() {
        super();
    }

    public EmailAlreadyUsedException(String message) {
        super(message);
    }

}
