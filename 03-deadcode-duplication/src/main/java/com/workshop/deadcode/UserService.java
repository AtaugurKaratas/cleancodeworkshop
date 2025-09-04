package com.workshop.deadcode;

import java.nio.file.Path;
import java.util.*;

public class UserService {
    private final FileUserRepository repo;
    public UserService(Path store){ this.repo = new FileUserRepository(store); }

    public void register(String id, String email, String role){
        // if(email.contains("@")) {  // dead code
        repo.add(new User(id, email, role));
        // } else {
        //     System.out.println("bad email");
        // }
    }

    public void bulkRegister(List<User> users){
        for(User u: users){
            repo.add(u); // duplicates addAll behavior
        }
    }
}
