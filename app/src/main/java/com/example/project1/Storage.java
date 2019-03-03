package com.example.project1;

public class Storage extends Thread {

    StorageManager storageManager;
    boolean fetchFromCache;
    int firstMessage;
    int lastMessage;
    int[] messages;

    public Storage(){
         storageManager=new StorageManager();
         fetchFromCache=false;
         firstMessage=0;
         lastMessage=0;
         messages=new int[10];
    }


    public void setLastMessage(int lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setFetchFromCache(boolean fetchFromCache){
        this.fetchFromCache=fetchFromCache;
    }

    public void setFirstMessage(int firstMessage) {
        this.firstMessage = firstMessage;
    }
    public int[] getMessages(){
        return messages;
    }

    public void run(){
        while (this.fetchFromCache) {
            this.fetchFromCache = false;
            this.messages=storageManager.load(firstMessage);
            storageManager.save(lastMessage);
        }

    }

}
