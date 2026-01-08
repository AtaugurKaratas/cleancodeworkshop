package com.workshop.deadcode;

import java.nio.file.Path;
import java.util.List;

public class UserService {
    private final FileUserRepository repo;

    public UserService(Path store) {
        this.repo = new FileUserRepository(store);
    }

    public void register(String id, String email, String role) {
        repo.add(List.of(new User(id, email, role)));
    }

    public void bulkRegister(List<User> users) {
        repo.add(users);
    }
}
