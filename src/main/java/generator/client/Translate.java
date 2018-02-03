package generator.client;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translate {
	private static final String BASE_URL = "http://www.reverso.net/WebReferences/WSAJAXInterface.asmx/TranslateWS";
	private static final String BODY = "{'searchText': '%s', 'direction': '524289', 'maxTranslationChars':'-1'}";

	public static String translate(String string) throws IOException{
		HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL).openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.addRequestProperty("Accept","application/json");
		connection.addRequestProperty("Accept-Language","fr-FR,fr;q=0.9,en-US;q=0.8,en;q=0.7");
		connection.addRequestProperty("Content-Type","application/json");
		connection.addRequestProperty("Referer","http://www.reverso.net/translationresults.aspx?lang=FR&direction=anglais-francais");
		String json = String.format(BODY, string);
		OutputStream os = connection.getOutputStream();
		os.write(json.getBytes("UTF-8"));
		os.close();
		String result = new String(connection.getInputStream().readAllBytes());
		JSONObject jsonObject = new JSONObject(result);
		if(jsonObject.has("d")){
			jsonObject = jsonObject.getJSONObject("d");
			if(jsonObject.has("result")){
				return jsonObject.getString("result");
			}
		}
		System.err.println("Error while translation : " + result);
		return "";
	}
}
