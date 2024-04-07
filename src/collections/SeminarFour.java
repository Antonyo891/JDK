package collections;

import java.util.HashSet;

public class SeminarFour {
    public static void main(String[] args) {
        Staff staff = new Staff();
        for (int i = 1; i < 10; i++) {
            staff.add(new Employee("+37533" + 1111111*i,"Employee" + i,i+5));
        }
        System.out.println(staff);
        System.out.println(staff.findByExperience(7));
        System.out.println(staff.findByPhone("+375331111111"));
        System.out.println(staff.findById(2));
        staff.add(new Employee("+375332222224","Employee23",5,2));
        staff.add(new Employee("+375332222222","Employee2"));
        System.out.println(staff);
    }

}
