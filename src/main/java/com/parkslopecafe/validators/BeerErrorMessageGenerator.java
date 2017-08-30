package com.parkslopecafe.validators;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeerErrorMessageGenerator {
    String[] errorMessages = new String[3];


    public String[] getErrorMessages(boolean nameValidation, boolean categoryValidation, boolean descriptionValidation) {
        if(!nameValidation) {
            errorMessages[0] = "Enter at least 1 character. No special characters allowed.";
        } else {
            errorMessages[0] = null;
        }

        if(!categoryValidation) {
            errorMessages[1] = "No special characters allowed";
        } else {
            errorMessages[1] = null;
        }

        if(!descriptionValidation) {
            errorMessages[2] = "No special characters allowed";
        } else {
            errorMessages[2] = null;
        }

        return errorMessages;
    }
}
