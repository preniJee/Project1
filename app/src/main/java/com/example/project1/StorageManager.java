package com.example.project1;

public class StorageManager {
    private int lastmessage = 0;
    int[] messages = new int[10];
    public int[] load(int firstmessage){
        if(firstmessage < lastmessage) {
            int[] messages = new int[10];
            for (int i = firstmessage; i < firstmessage + 10; ++i) {
                messages[i] = firstmessage + i + 1;
            }
        }
        return messages;
    }
    public void save(int lastmessage){
        this.lastmessage = lastmessage;
    }
}
