package core;

import commands.Command;
import commands.CommandListener;
import commands.CommandManager;
import commands.InfoCommand;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Launcher implements BotSettings {
    public static void main(String[] args) {
        JDABuilder jdaBuilder = new JDABuilder(BOT_TOKEN);
        jdaBuilder.setAutoReconnect(true);

        loadListeners(jdaBuilder);
        loadCommands();

        try {
            jdaBuilder.build();
        } catch (LoginException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

    private static void loadCommands() {
        Command[] commands = {new InfoCommand()};

        for (int i = 0; i < commands.length; i++) {
            CommandManager.getInstance().addComand(commands[i]);
        }
    }

    private static void loadListeners(JDABuilder jdaBuilder) {
        jdaBuilder.addEventListener(new CommandListener());
    }
}
