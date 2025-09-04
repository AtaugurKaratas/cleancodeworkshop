package com.workshop.switchcase;

public class NotificationService {
    // Dirty: type code switch, duplicate formatting
    public String send(String type, String to, String msg){
        if("email".equals(type)){
            return "EMAIL to "+to+": "+msg;
        } else if("sms".equals(type)){
            return "SMS to "+to+": "+msg;
        } else if("push".equals(type)){
            return "PUSH to "+to+": "+msg;
        } else if("slack".equals(type)){
            return "SLACK @"+to+": "+msg;
        } else {
            return "UNKNOWN";
        }
    }
}
