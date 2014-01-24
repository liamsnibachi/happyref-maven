package com.soat.happyref.exceptions;

/**
 * @author formation
 *
 */
public class FonctionnelleException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public FonctionnelleException() {
    }

    /**
     * @param message
     */
    public FonctionnelleException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public FonctionnelleException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public FonctionnelleException(String message, Throwable cause) {
        super(message, cause);
    }
}