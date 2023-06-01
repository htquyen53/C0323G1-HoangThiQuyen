package case_study.furama_resort.service;

public interface IFuramaService<E> {
    void displayList();
    void addNew();
    void delete();
    E findByID(String id);
    E findByName(String name);

    void editInfo();
}
