package com.example.project1;

public class ConnectionManager {

    public int[] load(int firstMessage) throws InterruptedException {
        Thread.sleep(100);
        int[] message = new int[10];
        for(int i = 0; i < 10; ++i){
            message[i] = firstMessage + i + 1;
        }
        System.out.println(message[3]);
        System.out.println("mamdgmdfakhmadf");
        return message;
    }
}
