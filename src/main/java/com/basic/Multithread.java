package com.basic;

// Java code for thread creation by extending
// the Thread class
class MultithreadingDemo extends Thread {
    public void run()
    {
        try {
            for(int i=1;i<4;i++){
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    System.out.println("Exception is caught");
                }
                System.out.print(i+" ");
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

// Main Class
public class Multithread {
    public static void main(String[] args)
    {
        MultithreadingDemo t1 = new MultithreadingDemo();
        MultithreadingDemo t2 = new MultithreadingDemo();
        t1.start();
        try{
            t1.join();
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
        t2.start();

    }
}

