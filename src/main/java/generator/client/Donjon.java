package generator.client;


import generator.npc.NPC;

import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;

public class Donjon {
	private static final String BASE_URL = "https://donjon.bin.sh/";
	private static final String URL_NAME = BASE_URL + "name/rpc.cgi";
	private static final String URL_RANDOM = BASE_URL + "pathfinder/random/rpc.cgi";
	private static final String NPC_FORMATEUR = "?type=NPC&race=%s&gender=%s&order=%s&culture=%s&n=%s";
	private static final String NAME_FORMATEUR = "?type=%s+%s&n=1";

	public enum Type{English, Italian, French, German, Slavic, Japanese};

	public static String getName(String type, NPC.Sexe sexe) throws IOException {
		URLConnection connection = new URL(URL_NAME + String.format(NAME_FORMATEUR,type, sexe.name())).openConnection();
		return new String(connection.getInputStream().readAllBytes());
	}
}
