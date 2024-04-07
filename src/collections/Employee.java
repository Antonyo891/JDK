package collections;
/*Каждый сотрудник должен иметь следующие атрибуты:
Табельный номер, Номер телефона, Имя, Стаж*/
public class Employee implements Comparable<Employee>{
    private static Integer count = 1;
    private final Integer IdNumber;
    private String phoneNumber;
    private String name;
    private Integer experience;

    public Employee(String phoneNumber, String name, Integer experience, Integer id) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
        this.IdNumber = id;
    }

    public Employee(String phoneNumber, String name, Integer experience) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
        this.IdNumber = count++;
    }

    public Employee(String phoneNumber, String name) {
        this(phoneNumber,name,0);
    }

    public Integer getIdNumber() {
        return IdNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getExperience() {
        return experience;
    }

    public Employee(Integer idNumber, String phoneNumber, String name, Integer experience) {
        IdNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "IdNumber=" + IdNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return this.getName().equalsIgnoreCase(employee.getName());
    }

    @Override
    public int hashCode() {
        return getIdNumber();
    }
}
