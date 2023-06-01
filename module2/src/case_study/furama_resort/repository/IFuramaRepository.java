package case_study.furama_resort.repository;

import java.util.List;

public interface IFuramaRepository<E>{
    List<E> getAll();
    void addNew(E e);
    void edit(String id);
    E findByID(String id);
    void delete(E e);
    List<E> findByName(String name);
    String getInfoToCSV(E e);
}
