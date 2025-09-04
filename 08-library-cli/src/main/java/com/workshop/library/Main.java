package com.workshop.library;

import java.io.*;
import java.util.*;

public class Main {
    // Dirty: everything in main
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> books = new ArrayList<>();
        while(true){
            System.out.print("cmd> ");
            String line = in.readLine();
            if(line==null || line.equals("quit")) break;
            if(line.startsWith("add ")){
                books.add(line.substring(4));
                System.out.println("added");
            } else if(line.equals("list")){
                for(String b: books) System.out.println(b);
            } else if(line.startsWith("find ")){
                String q = line.substring(5);
                for(String b: books) if(b.toLowerCase().contains(q.toLowerCase())) System.out.println(b);
            } else if(line.startsWith("remove ")){
                books.remove(line.substring(7));
                System.out.println("removed");
            } else {
                System.out.println("unknown");
            }
        }
    }
}
