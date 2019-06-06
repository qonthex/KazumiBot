package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public interface Command {
    void execute(GuildMessageReceivedEvent event, String[] args);
    String getCategory();
    String getSmallHelp();
    String getBigHelp();
}
