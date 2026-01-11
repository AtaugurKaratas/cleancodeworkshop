package com.workshop.library;

public enum ConsoleCommands {
    CMD("cmd> "),
    ADD("add "),
    LIST("list"),
    FIND("find "),
    REMOVE("remove ");

    public final String command;

    ConsoleCommands(String command) {
        this.command = command;
    }
}
