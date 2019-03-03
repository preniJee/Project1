package com.example.project1;

import android.annotation.SuppressLint;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Observable;

public class MessageController {

    private NotificationCenter notificationCenter;
    ArrayList<Integer> messages;
    Storage storage1;
    Cloud cloud1;
    public MessageController(final NotificationCenter notificationCenter) {
        storage1 = new Storage();
        cloud1 = new Cloud();
        storage1.start();
        cloud1.start();
        this.notificationCenter = notificationCenter;
        messages = new ArrayList();
    }

    public void fetch(boolean fromCache){
        int[] answer;
        if(fromCache){
            storage1.setFirstMessage(messages.size());
            storage1.setFetchFromCache(true);
            answer=storage1.getMessages();

            for (int i = 0; i <answer.length ; i++) {
                messages.add(answer[i]);

            }
            storage1.setLastMessage(messages.size());

            notificationCenter.data_loaded(answer);
//           TODO: set last message
        }
        else{
            System.out.println("heree");
            cloud1.setFirstMessage(messages.size());
            cloud1.setFetchFromServer(true);
            answer=cloud1.getMessages();
            for (int i = 0; i <answer.length ; i++) {
                messages.add(answer[i]);
            }
            notificationCenter.data_loaded(answer);
        }


    }


}
