package com.workshop.deadcode;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class FileUserRepository {

    private static final Logger logger =  Logger.getLogger(FileUserRepository.class);
    private static final String DELIMITER = ",";
    private static final String USER_ROLE = "user";

    private final Path file;
    public FileUserRepository(Path file){ this.file = file; }

    public void add(List<User> users){
        try {
            Files.createDirectories(file.getParent());
            try(BufferedWriter w = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
                for(User user: users){
                    w.write(writeUser(user));
                    w.newLine();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findById(String id) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .filter(line -> readLine(line, id))
                    .findFirst()
                    .flatMap(line -> readUser(line, id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String writeUser(User user){
        return String.join(DELIMITER, user.id(), user.email(), user.role());
    }

    private boolean readLine(String line, String id){
        String[] userText = line.split(DELIMITER);
        return userText[0].equals(id);
    }

    private Optional<User> readUser(String line, String id){
        String[] userText = line.split(DELIMITER);
        if(userText.length > 1 && userText[0].equals(id)){
            String email = userText[1];
            String role = userText.length > 2 ? userText[2] : USER_ROLE;
            return Optional.of(new User(id, email, role));
        }
        logger.error("There is insufficient data on the line: " + line);
        return Optional.empty();
    }
}
