package case_study.furama_resort.repository;

import case_study.furama_resort.model.human.Customer;

import java.util.List;

public interface IFuramaRepository<E>{
    List<E> getAll();
    void addNew(E e);
    void edit(E e);
    E findByID(String id);
    void delete(E e);
    E getByCitizenID(String citizenID);
    List<E> findByName(String name);
    String getInfoToCSV(E e);
}
