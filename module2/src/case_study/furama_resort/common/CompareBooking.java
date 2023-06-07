package case_study.furama_resort.common;

import case_study.furama_resort.model.services.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareBooking implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date oFirstBookingDay = simpleDateFormat.parse(o1.getBookingDay());
            Date oSecondDayBooking =simpleDateFormat.parse(o2.getBookingDay());
            Date oFirstEndDay = simpleDateFormat.parse(o1.getEndDay());
            Date oSecondEndDay = simpleDateFormat.parse(o2.getEndDay());
            if (oFirstBookingDay.equals(oSecondEndDay)) {
                return oSecondEndDay.compareTo(oFirstEndDay);
            } else {
                return oFirstBookingDay.compareTo(oSecondDayBooking);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
