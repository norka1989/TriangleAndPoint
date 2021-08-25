package com.epam.jwd.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataValidation {
    private static final Logger LOG = LogManager.getLogger(DataValidation.class);
    private static final String REGEX = "-?\\d+\\.-?\\d+\\s-?\\d+\\.-?\\d+\\s-?\\d+\\.-?\\d+";

    public DataValidation(){}

    public boolean isCorrectData(String line) {
        if (line.matches(REGEX)) {
            LOG.info("The dates from the line are correct");
            return true;
        } else {
            LOG.info("The dates from the line are not correct");
            return false;
        }
    }
}
