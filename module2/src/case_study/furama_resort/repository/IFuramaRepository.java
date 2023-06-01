package case_study.furama_resort.repository;

import java.util.List;
import java.util.Objects;

public interface IFuramaRepository<E>{
    List<E> getAll();
    void addNew(E e);
    void edit(String id);
    E getByID(String id);
    String getInfoToCSV(E e);
}
