package com.example.project1;

public class Test1 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                a = func(10);
                System.out.println(a);
            }
        });
        thread.start();
    }
    public static int func(int a){
        return a + 1;
    }
}
