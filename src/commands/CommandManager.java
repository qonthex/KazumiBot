package commands;

import core.BotSettings;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;

public class CommandManager implements BotSettings {
    private static CommandManager ourInstance = new CommandManager();

    private HashMap<String, Command> commandMap = new HashMap<>();

    public static CommandManager getInstance() {
        return ourInstance;
    }

    private CommandManager() {
    }

    public boolean addComand(String name, Command command) {
        if (commandMap.containsKey(name)) {
            return false;
        } else {
            commandMap.put(name, command);
            return true;
        }
    }

    public boolean executeCommand(GuildMessageReceivedEvent event) {
        String content = event.getMessage().getContentRaw();
        content = content.replaceFirst(PREFIX, "");

        String[] contentSplitted = content.split(" ");
        String invoke = contentSplitted[0];

        if (commandMap.containsKey(invoke)) {
            return true;
        } else {
            return false;
        }
    }
}
