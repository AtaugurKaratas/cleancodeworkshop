package com.workshop.deadcode;

import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUserRepositoryTest {
    @Test
    void shouldReturnUserWhenUserIsRegistered() throws Exception {
        Path tmp = Files.createTempDirectory("users");
        Path file = tmp.resolve("users.csv");
        FileUserRepository repo = new FileUserRepository(file);
        UserService userService = new UserService(file);
        userService.register("1","a@x.com","admin");
        assertTrue(repo.findById("1").isPresent());
    }

    @Test
    void shouldReturnUserWhenUsersAreBulkRegistered() throws Exception {
        Path tmp = Files.createTempDirectory("users");
        Path file = tmp.resolve("users.csv");
        FileUserRepository repo = new FileUserRepository(file);
        UserService userService = new UserService(file);
        userService.bulkRegister(List.of(new User("2","b@x.com","user")));
        assertEquals("user", repo.findById("2").get().role());
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotExist() throws Exception {
        Path tmp = Files.createTempDirectory("users");
        Path file = tmp.resolve("users.csv");
        FileUserRepository repo = new FileUserRepository(file);
        assertThrows(RuntimeException.class, () -> repo.findById("1"));
    }
}
