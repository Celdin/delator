import generator.Generator;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.entities.impl.DataMessage;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {

	private JDA jda;

	public Bot(String token) throws LoginException, InterruptedException {
		jda = new JDABuilder(AccountType.BOT).setToken(token).setBulkDeleteSplittingEnabled(false).buildBlocking();
		jda.getPresence().setGame(Game.of(Game.GameType.DEFAULT, "écoute ton voisin"));
		System.out.println("Connecte avec: " + jda.getSelfUser().getName());
		int size = jda.getGuilds().size();
		System.out.println("Autorisé sur " + size + " serveur" + (size > 1 ? "s" : ""));
		for (Guild guild : jda.getGuilds()){
			System.out.println("	 - " + guild.getName());
		}
		jda.addEventListener(new ListenerAdapter() {
			@Override
			public void onMessageReceived(MessageReceivedEvent event) {
				System.out.println(String.format("%#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay()));
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
