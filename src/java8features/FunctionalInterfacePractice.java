package java8features;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FunctionalInterfacePractice {
    public static void main(String[] args) {
    Car vh=()->System.out.println("Vehicle");
    vh.start();

    //Predefined Functional Interfaces in Java
        BiFunction<Integer,Integer,Integer> bi=(a,b)->{return a+b;};
      System.out.println(bi.apply(10,20));
        Consumer<Integer> con=a->System.out.println(a);
        con.accept(10);
    }
}
@java.lang.FunctionalInterface
interface Vehicle{
    void start();
}

interface Car extends Vehicle{

}