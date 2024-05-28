package com.infosupport.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        futureDemo();            // blocks for a minimum of 1000 ms

        completableFutureDemo(); // takes a minimum of 1000 ms
        Thread.sleep(1100);      // wait for completableFutureDemo to finish before shutting down the main thread
    }

    private static void futureDemo() throws InterruptedException, ExecutionException {
        Future<String> questionsFuture = findAll(); // takes 1000+ ms
        // ...
        // ... do something else
        // ...
        String questions = questionsFuture.get();// ... blocking the main thread
        System.out.println(questions);
    }

    private static Future<String> findAll() {
        return new Future<>() {
            @Override public boolean cancel(boolean mayInterruptIfRunning) { return false; }

            @Override public boolean isCancelled() { return false; }

            @Override public boolean isDone() { return true; }

            @Override public String get() { return findAllSync() + " from future"; }

            @Override public String get(long timeout, TimeUnit unit) throws InterruptedException { return get(); }
        };
    }

    private static void completableFutureDemo() {
        serviceFindAll()
                .thenApply(r -> r + " from completable future") // map, optional
                .thenApply(String::toUpperCase) // map, optional
                .thenAccept(System.out::println); // finishing the results
    }

    private static CompletableFuture<String> serviceFindAll() {
        return CompletableFuture.supplyAsync(() -> findAllSync());
    }

    private static String findAllSync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello World";
    }
}
