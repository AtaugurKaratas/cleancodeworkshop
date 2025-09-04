package com.workshop.deadcode;

import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FileUserRepositoryTest {
    @Test
    void writes_and_reads_users() throws Exception {
        Path tmp = Files.createTempDirectory("users");
        Path file = tmp.resolve("users.csv");
        FileUserRepository repo = new FileUserRepository(file);
        repo.add(new User("1","a@x.com","admin"));
        repo.addAll(List.of(new User("2","b@x.com","user")));
        assertTrue(repo.findById("1").isPresent());
        assertEquals("user", repo.findById("2").get().role());
    }
}
