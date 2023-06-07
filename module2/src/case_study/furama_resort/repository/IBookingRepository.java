package case_study.furama_resort.repository;

import case_study.furama_resort.model.facility.Facility;
import case_study.furama_resort.model.human.Customer;
import case_study.furama_resort.model.services.Booking;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface IBookingRepository {
    Set<Booking> getAll();
    void add(Booking booking);
    List<Customer> getCustomerBookingInYear();
}
   
   






































