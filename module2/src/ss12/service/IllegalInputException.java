package ss12.service;

import ss15.bai_tap.triangle.IllegalTriangleException;

public class IllegalInputException extends Exception{
    public IllegalInputException (String message) {
        super(message);
    }
}
