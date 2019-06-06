package core;

import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

public class Launcher implements BotSettings {
    public static void main(String[] args) {
        JDABuilder jdaBuilder = new JDABuilder(BOT_TOKEN);
        jdaBuilder.setAutoReconnect(true);
        try {
            jdaBuilder.build();
        } catch (LoginException e) {
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }
}
