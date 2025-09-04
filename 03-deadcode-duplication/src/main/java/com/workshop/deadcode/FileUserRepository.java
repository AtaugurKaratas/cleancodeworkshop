package com.workshop.deadcode;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUserRepository {
    private final Path file;
    public FileUserRepository(Path file){ this.file = file; }

    // Dirty: duplicate write logic, commented-out code, silent failures, inconsistent CSV
    public void add(User u){
        try {
            Files.createDirectories(file.getParent());
            try(BufferedWriter w = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
                w.write(u.id()+","+u.email()); // role missing!
                w.newLine();
            }
        } catch(Exception e){
            // e.printStackTrace();
        }
    }

    public void addAll(List<User> users){
        try {
            Files.createDirectories(file.getParent());
            try(BufferedWriter w = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
                for(User u: users){
                    w.write(String.join(";", u.id(), u.email(), u.role())); // different delimiter
                    w.newLine();
                }
            }
        } catch(Exception e){
            // TODO handle
        }
    }

    public Optional<User> findById(String id){
        try {
            List<String> lines = Files.readAllLines(file);
            for(String line: lines){
                String[] p = line.contains(";") ? line.split(";") : line.split(",");
                if(p[0].equals(id)){
                    String role = p.length>2 ? p[2] : "user";
                    return Optional.of(new User(p[0], p[1], role));
                }
            }
        } catch(IOException e){
            return Optional.empty();
        }
        return Optional.empty();
    }
}
