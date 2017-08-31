package com.parkslopecafe.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class StringValidator {

    public boolean checkIfStringIsValid(String string) {
        return (StringUtils.isNotEmpty(string) && StringUtils.containsNone(string, "<>#%{}|^~[]`"));
    }

    public boolean checkForSpecialCharacters(String string) {
        return (StringUtils.containsNone(string, "<>#%{}|^~[]`"));
    }

    public boolean checkLengthOfString(String string, int length) {
        return (string.length() >= length);
    }
}
