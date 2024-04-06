package generelization.calculator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.*/
public class Calculator {
    private static int classNumber;

    private static <T extends Number> void checkClass(T number){
        if (checkInteger(number)) {
            classNumber = 1;
            return;
        }
        if (checkDouble(number)) {
            classNumber = 2;
            return;
        }
        if (checkLong(number)) {
            classNumber = 3;
            return;
        }
        if (checkFloat(number)) {
            classNumber = 4;
            return;
        }
        if (checkByte(number)) {
            classNumber = 5;
            return;
        }
        if (checkShort(number)) {
            classNumber = 6;
        }
    }
    private static <T extends Number> Boolean checkInteger(T number){
        return (number.getClass().getSimpleName().equalsIgnoreCase("Integer"))||
                (number.getClass().getSimpleName().equalsIgnoreCase("int"));
    }
    private static <T extends Number> Boolean checkDouble(T number){
        return (number.getClass().getSimpleName().equalsIgnoreCase("Double"));
    }
    private static <T extends Number> Boolean checkLong(T number){
        return number.getClass().getSimpleName().equalsIgnoreCase("Long");
    }
    private static <T extends Number> Boolean checkFloat(T number){
        return number.getClass().getSimpleName().equalsIgnoreCase("Float");
    }
    private static <T extends Number> Boolean checkByte(T number){
        return number.getClass().getSimpleName().equalsIgnoreCase("Byte");
    }
    private static <T extends Number> Boolean checkShort(T number){
        return number.getClass().getSimpleName().equalsIgnoreCase("Short");
    }
    private static <T extends Number> void calculation(T firstT, T secondT,Character operation) {
        checkClass(firstT);
        int firstClassNumber = classNumber;
        checkClass(secondT);
        if ((firstClassNumber==3)||(classNumber==3)){
            Long result = 0L;
            switch (operation) {
                case '+' -> {
                    result = (firstT.longValue()) + secondT.longValue();
                }
                case '-' -> {
                    result = (firstT.longValue()) - secondT.longValue();
                }
                case '/' -> {
                    result = (firstT.longValue()) / secondT.longValue();
                }
                case '*' -> {
                    result = (firstT.longValue()) * secondT.longValue();
                }
            }
            System.out.println(firstT + operation.toString() + secondT + " = "
                    + result);
            return;
        }
        if ((firstClassNumber==2)||(classNumber==2)){
            Double result = null;
            switch (operation) {
                case '+' -> {
                    result = (firstT.doubleValue()) + secondT.doubleValue();
                }
                case '-' -> {
                    result = (firstT.doubleValue()) - secondT.doubleValue();
                }
                case '/' -> {
                    result = (firstT.doubleValue()) / secondT.doubleValue();
                }
                case '*' -> {
                    result = (firstT.doubleValue()) * secondT.doubleValue();
                }
            }
            System.out.println(firstT + operation.toString() + secondT + " = "
                    + result);
            return;
        }
        if ((firstClassNumber==4)||(classNumber==4)){
            Float result = null;
            switch (operation) {
                case '+' -> {
                    result = firstT.floatValue() + secondT.floatValue();
                }
                case '-' -> {
                    result = firstT.floatValue() - secondT.floatValue();
                }
                case '/' -> {
                    result = firstT.floatValue() / secondT.floatValue();
                }
                case '*' -> {
                    result = firstT.floatValue() * secondT.floatValue();
                }
            }
            System.out.println(firstT + operation.toString() + secondT + " = "
                    + result);
            return;
        }
        if ( (new ArrayList<>(Arrays.asList(1,5,6)).contains(firstClassNumber))) {
            Integer result = null;
            switch (operation) {
                case '+' -> {
                    result = firstT.intValue() + secondT.intValue();
                }
                case '-' -> {
                    result = firstT.intValue() - secondT.intValue();
                }
                case '/' -> {
                    result = firstT.intValue() / secondT.intValue();
                }
                case '*' -> {
                    result = firstT.intValue() * secondT.intValue();
                }
            }
            System.out.println(firstT + " + " + secondT + " = " + result);
        }
    }
    public static <T extends Number> void sum(T first, T secondT) {
        calculation(first,secondT,'+');
    }
    public static <T extends Number> void multiply(T first, T secondT) {
        calculation(first,secondT,'*');
    }
    public static <T extends Number> void  divide(T first, T secondT) {
        calculation(first,secondT,'/');
    }
    public static <T extends Number> void  subtract(T first, T secondT) {
        calculation(first,secondT,'-');
    }
}
