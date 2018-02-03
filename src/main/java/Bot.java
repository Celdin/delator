import generator.Generator;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.impl.DataMessage;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {
	private static final String DISCORD_TOKEN = "NDA3ODQ1NjE5MzE5OTYzNjQ4.DVHdpA.VMk4ZwV21dVXkVx8BwQCUEtrX1U";

	private JDA jda;

	public Bot() throws LoginException, InterruptedException {
		jda = new JDABuilder(AccountType.BOT).setToken(DISCORD_TOKEN).setBulkDeleteSplittingEnabled(false).buildBlocking();
		System.out.println("Connecte avec: " + jda.getSelfUser().getName());
		int size = jda.getGuilds().size();
		System.out.println("Autorisé sur " + size + " serveur" + (size > 1 ? "s" : ""));
		for (Guild guild : jda.getGuilds()){
			System.out.println("	 - " + guild.getName());
		}
		jda.addEventListener(new ListenerAdapter() {
			@Override
			public void onMessageReceived(MessageReceivedEvent event) {
				System.out.println(String.format("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay()));
				if (event.isFromType(ChannelType.TEXT)) {
					if(event.getMessage().getMentionedUsers().contains(jda.getSelfUser())){
						try {
							event.getTextChannel().sendMessage(Generator.jaccuse()).submit();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}else{
					System.out.println("(on a unsuported channel)");
				}
			}
		});
	}
}
