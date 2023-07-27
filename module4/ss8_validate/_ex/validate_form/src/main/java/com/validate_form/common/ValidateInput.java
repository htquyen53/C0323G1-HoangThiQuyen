package com.validate_form.common;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ValidateInput {
    public static boolean checkAge(Date birthday) {
        Instant instant = birthday.toInstant();
        LocalDate localBD = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(localBD,currentDate).getYears() >= 18;
    }
}

