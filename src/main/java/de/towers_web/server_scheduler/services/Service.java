package de.towers_web.server_scheduler.services;


import de.towers_web.server_scheduler.commands.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Service {
    Command touch = new Command();

    public Service() {
        createNewVTouchCommand();
        executeFirstCommand();
        executeSecondCommand();
    }

    public void createNewVTouchCommand() {
        touch.setName("touch");
        touch.setProgram("touch");

    }

    public void executeFirstCommand() {
        StringBuffer output = new StringBuffer();
        String command = "touch first.txt";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executeSecondCommand() {
        ProcessBuilder pb = new ProcessBuilder("touch", "firstPBTest");
        pb.directory(new File("/home/benutzer/"));

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*

---------------------example from: https://stackoverflow.com/questions/26830617/running-bash-commands-in-java--------------------
        ProcessBuilder pb = new ProcessBuilder("myCommand", "myArg1", "myArg2");
        Map<String, String> env = pb.environment();
        env.put("VAR1", "myValue");
        env.remove("OTHERVAR");
        env.put("VAR2", env.get("VAR1") + "suffix");
        pb.directory(new File("myDir"));
        File log = new File("log");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p = null;
        try {
            p = pb.start();
            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    }
}
