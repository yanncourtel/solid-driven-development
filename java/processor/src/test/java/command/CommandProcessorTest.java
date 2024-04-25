package command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CommandProcessorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private CommandProcessor processor;

    @Before
    public void setUp() {
        processor = new CommandProcessor();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGreetingCommand() {
        Map<String, String> params = new HashMap<>();
        params.put("firstName", "John");
        params.put("lastName", "Doe");
        processor.processCommand("greet", params);
        assertEquals("Hello John Doe!\r\n", outContent.toString());
    }

    @Test
    public void testExitCommand() {
        processor.processCommand("exit", new HashMap<>());
        assertEquals("Goodbye!\r\n", outContent.toString());
    }

    @Test
    public void testUnrecognizedCommand() {
        processor.processCommand("unknown", new HashMap<>());
        assertEquals("Command not recognized.\r\n", outContent.toString());
    }

    @Test
    public void testGreetingNobody() {
        processor.processCommand("greet", null);
        assertEquals("Hello  !\r\n", outContent.toString());
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
