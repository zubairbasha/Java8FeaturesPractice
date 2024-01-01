package java8features;



public class MethodReferences {
    public static void main(String[] args) {
        MethodReferences method=new MethodReferences();
    SayableInterface say=Message::new;
    say.say();
    }
    public static void saySomething(){
        System.out.println("Hello, Say something");
    }
    public void Saysomthing(){
        System.out.println("Hello, Say something");
    }
}
interface SayableInterface{
    Message say();
}
class Message{
    private String msg;

    public Message(){
    System.out.println("msg");
    }
}
