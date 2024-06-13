package com.infosupport.concurrency;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadLockingDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                c.incrementValue();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                c.incrementValue();
            }
        });

        long start = System.nanoTime();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long stop = System.nanoTime();

        System.out.println(c.getValue());
        System.out.println("Took " + (stop - start));
    }

    private static class Counter {
        ReentrantReadWriteLock plasketting = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock plaskettingRead = plasketting.readLock();

        private int value;

        public Counter(int i) { this.value = i; }

        public void incrementValue() {
            plasketting.writeLock().lock();
            int oldValue = this.value;
            Thread.yield();

            this.value = oldValue + 1;
            plasketting.writeLock().unlock();
        }

        public int getValue() {
            return value;
        }
    }
}
