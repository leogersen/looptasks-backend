package com.leogersen.looptasks.task;

@SuppressWarnings("serial")
public class DuplicateTaskException extends Exception {

    public DuplicateTaskException(String message) {
        super(message);
    }
}
