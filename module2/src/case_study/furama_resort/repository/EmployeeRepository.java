package case_study.furama_resort.repository;

import case_study.furama_resort.common.ReadAndWriteCSV;
import case_study.furama_resort.model.human.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String EMPLOYEES_LIST_PATH = "module2/src/case_study/furama_resort/data/employees.csv";
//    Employee(String id, String name, String birthday, boolean gender, String citizenID, String numberPhone, String email, String academicLevel, String jobPosition, Float salary)
    @Override
    public List<Employee> getAll() {
        List<String> strings = ReadAndWriteCSV.readFile(EMPLOYEES_LIST_PATH);
        employeeList.clear();
        String[] info;
        for (String str: strings) {
            info = str.split(",");
            employeeList.add(new Employee(info[0], info[1], info[2], Boolean.getBoolean(info[3]), info[4], info[5], info[6],info[7], info[8], Float.parseFloat(info[9])));
        }
        return employeeList;
    }

    @Override
    public Employee getByID(String id) {
        return null;
    }

    @Override
    public void addNew(Employee employee) {


    }

    @Override
    public void edit(String id) {

    }

    @Override
    public String getInfoToCSV(Employee employee) {
        return null;
    }
}
