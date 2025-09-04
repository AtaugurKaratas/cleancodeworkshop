package com.workshop.longmethod;

import java.util.HashSet;
import java.util.Set;

/** Dirty: flags, deep nesting, mixed responsibilities, inconsistent returns */
public class PasswordValidator {
    private final Set<String> blacklist = new HashSet<>(Set.of("password","12345678","qwerty","letmein","welcome"));

    public String validate(String p){
        boolean ok = true;
        String msg = "OK";
        if(p!=null){
            if(p.length()>=8){
                boolean hasUpper=false, hasDigit=false, hasSpecial=false, hasRepeat=false;
                int repeat=1;
                char last=0;
                for(char c: p.toCharArray()){
                    if(Character.isUpperCase(c)) hasUpper = true;
                    if(Character.isDigit(c)) hasDigit = true;
                    if("!@#$%^&*".indexOf(c)>=0) hasSpecial = true;
                    if(c==last){ repeat++; if(repeat>=3) hasRepeat=true; } else { repeat=1; last=c; }
                }
                if(blacklist.contains(p)) { ok=false; msg="BLACKLISTED"; }
                else if(!hasUpper){ ok=false; msg="NO_UPPER"; }
                else {
                    if(!hasDigit){ ok=false; msg="NO_DIGIT"; }
                    else {
                        if(!hasSpecial){ ok=false; msg="NO_SPECIAL"; }
                        else {
                            if(hasRepeat){ ok=false; msg="REPEATING_CHARS"; }
                        }
                    }
                }
            } else { ok=false; msg="TOO_SHORT"; }
        } else { ok=false; msg="NULL"; }
        return ok? "OK" : msg;
    }
}
