package br.com.webflux.poc.commons;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleepSeconds(int seconds){
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void logThreadInfo(String localName) {
        String log = String.format("%s Thread Name: %s, Id: %s group: %s, state: %s", localName, Thread.currentThread().getName(),
                Thread.currentThread().getId(), Thread.currentThread().getThreadGroup(), Thread.currentThread().getState());
        System.out.println(log);
    }
}
