package com.soat.happyref.exceptions;

/**
 * @author formation
 *
 */
public class TechniqueException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public TechniqueException() {
    }

    /**
     * @param message
     */
    public TechniqueException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public TechniqueException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public TechniqueException(String message, Throwable cause) {
        super(message, cause);
    }
}