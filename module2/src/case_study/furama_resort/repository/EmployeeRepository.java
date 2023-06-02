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
        for (String str : strings) {
            info = str.split(",");
            employeeList.add(new Employee(info[0], info[1], info[2], Boolean.getBoolean(info[3]), info[4], info[5], info[6], info[7], info[8], Float.parseFloat(info[9])));
        }
        return employeeList;
    }


    @Override
    public void addNew(Employee employee) {
        List<String> employeeString = new ArrayList<>();
        employeeString.add(getInfoToCSV(employee));
        ReadAndWriteCSV.writeFile(employeeString, EMPLOYEES_LIST_PATH, true);
    }

    @Override
    public void edit(Employee employee) {
        employeeList = getAll();
        for (Employee temp: employeeList) {
            if (temp.getId().equals(employee.getId())) {
                temp.setName(employee.getName());
                temp.setBirthday(employee.getBirthday());
                temp.setGender(employee.isGender());
                temp.setCitizenID(employee.getCitizenID());
                temp.setNumberPhone(employee.getNumberPhone());
                temp.setEmail(employee.getEmail());
                temp.setAcademicLevel(employee.getAcademicLevel());
                temp.setSalary(employee.getSalary());
            }
        }
        List<String> strings = new ArrayList<>();
        for (Employee temp: employeeList) {
            strings.add(getInfoToCSV(temp));
        }
        ReadAndWriteCSV.writeFile(strings, EMPLOYEES_LIST_PATH, false);
    }

    @Override
    public void delete(Employee employee) {
        employeeList = getAll();
        employeeList.remove(employee);
        List<String> strings = new ArrayList<>();
        for (Employee e: employeeList) {
            strings.add(getInfoToCSV(e));
        }
        ReadAndWriteCSV.writeFile(strings, EMPLOYEES_LIST_PATH, false);
    }

    @Override
    public Employee findByID(String id) {
        employeeList = getAll();
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        employeeList = getAll();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee: employeeList) {
            if (employee.getName().equals(name)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public String getInfoToCSV(Employee employee) {
        return employee.getId() + "," + employee.getName() + "," + employee.getBirthday() + "," +
                employee.isGender() + "," + employee.getCitizenID() + "," + employee.getNumberPhone() + "," +
                employee.getEmail() + "," + employee.getAcademicLevel() + "," + employee.getJobPosition() + "," +
                employee.getSalary();
    }
}
