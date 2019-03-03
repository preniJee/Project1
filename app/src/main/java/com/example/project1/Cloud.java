package com.example.project1;

public class Cloud extends Thread{

    boolean fetchFromServer;
    int firstMessage;
    ConnectionManager connectionManager;
    int[] messages;

    public Cloud(){
        connectionManager=new ConnectionManager();
        this.fetchFromServer=false;
        firstMessage=0;
        messages=new int[10];

    }

    public int[] getMessages() {
        return messages;
    }

    public void setFetchFromServer(boolean fromServer){
        this.fetchFromServer=fromServer;
    }
    public void setFirstMessage(int firstMessage){
        this.firstMessage=firstMessage;
    }

    public void run(){

        while (this.fetchFromServer){
            fetchFromServer=false;
            try {
                System.out.println("in cloud");
                messages=connectionManager.load(firstMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
