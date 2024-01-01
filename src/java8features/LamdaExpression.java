package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class LamdaExpression {
    public static void main(String[] args) {
        /*WE can write the lamda expression using functional interface.
        A Functional interface is an interface which has only one abstract method
        * */
        FunctionalInterface fn=(a)->System.out.println(a);
        fn.add(10);
        /*
        * Why use lambda expression?
        * To implement the functional interface.
        * Less coding*/
        Sayable say=(name)-> {return "My name is "+name;};//Lambda Expression with One Parameter
        System.out.println(say.say("Zubair"));
        Addable add=(a,b)-> (a+b);
        System.out.println(add.add(10,20));
        //For Each Loop
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(5);
        list.forEach(a->System.out.println(a));
        //Running Lambda Expression Using Thread
        Runnable r1=()->{
          System.out.println("Thread is Running");
        };
        Thread t=new Thread(r1);
        t.start();
        Collections.sort(list,(o1,o2)->o2.compareTo(o1));
        System.out.println(list);
    }
}
/**/
interface Sayable{
    public String say(String name);
}
interface Addable{
    int add( int a,int b);
}