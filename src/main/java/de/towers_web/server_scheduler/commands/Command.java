package de.towers_web.server_scheduler.commands;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Command {
    private String name;
    private String program;
    private ArrayList<String> arguments;
    private String directory;
    private String user;
}
