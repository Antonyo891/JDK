package collections;

import java.util.HashMap;
import java.util.HashSet;

/*Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список).
Добавить метод, который ищет сотрудника по табельному номеру.
Добавить метод добавление нового сотрудника в справочник сотрудников.*/
public class Staff {
    private HashSet<Employee> employees;

    public Staff(HashSet<Employee> employees) {
        this.employees = employees;
    }

    public Staff() {
        this(new HashSet<>());
    }

    public void add(Employee employee){
        if (this.employees == null) this.employees.add(employee);
        for (Employee tempEmployee:
             this.employees) {
            if (tempEmployee.equals(employee)) {
                System.out.println("Employee already EXIST");
                return;
            }
        } this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employees=" + employees +
                '}';
    }

    public HashSet<Employee> findByExperience(Integer experience){
        HashSet<Employee> findResult = new HashSet<>();
        for (Employee employee: employees
             ) {
            if (employee.getExperience() == experience) findResult.add(employee);
        }
        return findResult;
    }
    public Employee findById(Integer id){
        for (Employee employee: employees
        ) {
            if (employee.getIdNumber() == id) return employee;
        }
        return null;
    }

    public String findByPhone(String phoneNumber){
        for (Employee employee: employees
        ) {
            if (employee.getPhoneNumber().equalsIgnoreCase(phoneNumber)) return employee.getName();
        }
        return null;
    }

}
