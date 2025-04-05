package com.example.learn;

/*
incrementCounter() and getCounter() use synchronized (MyClass.class) to ensure
 that access to the static counter variable is thread-safe.
Only one thread can be inside either of these synchronized blocks at any given time
 */

class MyClass {
    private static int counter = 0;

    public static void incrementCounter() {
        synchronized (MyClass.class) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        }
    }

    public static int getCounter() {
        synchronized (MyClass.class) {
            return counter;
        }
    }

    public void doSomething() {
        synchronized (MyClass.class) {
            // This block is also synchronized on the class-level lock
            System.out.println(Thread.currentThread().getName() + " inside doSomething (class-level lock)");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static synchronized void anotherStaticMethod() {
        // This method also acquires the class-level lock
        System.out.println(Thread.currentThread().getName() + " inside anotherStaticMethod");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(MyClass::incrementCounter, "Thread-1");
        Thread t2 = new Thread(MyClass::incrementCounter, "Thread-2");
        Thread t3 = new Thread(() -> new MyClass().doSomething(), "Thread-3");
        Thread t4 = new Thread(MyClass::anotherStaticMethod, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}