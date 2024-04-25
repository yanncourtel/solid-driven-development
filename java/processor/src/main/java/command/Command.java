package command;

import java.util.Map;

interface Command {
    void execute(Map<String, String> params);
}

