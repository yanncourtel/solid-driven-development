import command.CommandProcessor;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        Map<String, String> greetParams = new HashMap<>();
        greetParams.put("firstName", "Alice");
        greetParams.put("lastName", "Johnson");

        processor.processCommand("greet", greetParams);  // Outputs: Hello, Alice Johnson!
        processor.processCommand("exit", new HashMap<>());        // Outputs: Goodbye!
        processor.processCommand("help", new HashMap<>());        // Outputs: Command not recognized.
    }
}
