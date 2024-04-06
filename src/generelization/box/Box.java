package generelization.box;

import java.io.DataInput;
import java.io.InputStream;

public class Box <T extends Comparable,V extends InputStream & DataInput,K extends Number> {
    private T firstParameter;
    private V secondParameter;
    private K thirdParameter;

    public Box(T firstParameter, V secondParameter, K thirdParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.thirdParameter = thirdParameter;
    }

    public T getFirstParameter() {
        return firstParameter;
    }

    public V getSecondParameter() {
        return secondParameter;
    }

    public K getThirdParameter() {
        return thirdParameter;
    }

    public void getClassName(){
        System.out.println("T -" +  getFirstParameter().getClass().getSimpleName() +
                ", V -" + getSecondParameter().getClass().getSimpleName() +
                ", K -" + getThirdParameter().getClass().getSimpleName() + ";");
    }
}
