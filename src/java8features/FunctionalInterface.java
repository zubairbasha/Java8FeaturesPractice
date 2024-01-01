package java8features;
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void add(int a);
    static void println(){
        System.out.println("Printing");
    }
    String toString();

    int hashCode();
}
