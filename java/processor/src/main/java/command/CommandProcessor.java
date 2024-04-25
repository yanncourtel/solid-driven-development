package command;

import java.util.Map;
import java.util.HashMap;

public class CommandProcessor {
    private Map<String, Command> commandMap;

    public CommandProcessor() {
        commandMap = new HashMap<>();
        commandMap.put("greet", params -> {
            String firstName = params.getOrDefault("firstName", "");
            String lastName = params.getOrDefault("lastName", "");
            System.out.println("Hello " + firstName + " " + lastName + "!");
        });
        commandMap.put("exit", params -> System.out.println("Goodbye!"));
    }

    public void processCommand(String command, Map<String, String> params) {
        Command cmd = commandMap.getOrDefault(command, p -> System.out.println("Command not recognized."));
        cmd.execute(params);
    }

}
