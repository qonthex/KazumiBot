package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class InfoCommand implements Command {
    @Override
    public void execute(GuildMessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                 .setAuthor("Infos über Kazumi")
                 .setColor(Color.magenta)
                 .setDescription("Hier sind einige Infos über Kazumi")
                 .addField(new MessageEmbed.Field("Entwickler:", "qonthex#0232", false))
                 .addField("Hilfe anzeigen", "-help", false)
        .build()).queue();
    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public String getSmallHelp() {
        return null;
    }

    @Override
    public String getBigHelp() {
        return null;
    }

    @Override
    public String getName() {
        return "info";
    }
}
