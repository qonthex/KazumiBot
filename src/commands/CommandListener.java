package commands;

import core.BotSettings;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class CommandListener extends ListenerAdapter implements BotSettings {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(PREFIX)) {
            if (CommandManager.getInstance().executeCommand(event) == false) {
                event.getChannel().sendMessage(new EmbedBuilder()
                .setAuthor("Ein Fehler ist aufgetreten!")
                .setDescription("Der Befehl wurde nicht gefunden! Bitte versuche es erneut!")
                .setColor(Color.RED).build()).queue();
            }
        }
    }
}
