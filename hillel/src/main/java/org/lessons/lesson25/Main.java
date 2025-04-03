package org.lessons.lesson25;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getInstance();
        log.log("Message from Main");
        MyClass.doSomething();
        Logger log2 = Logger.getInstance();
        System.out.println(log == log2);
    }
}
