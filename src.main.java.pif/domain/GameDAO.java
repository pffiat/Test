package domain;

import java.util.ArrayList;
import java.util.List;

import modele.Game;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public enum GameDAO {

	/* don't put any variable in this class => different clients would share personal data and produce a bit mix*/
	/* Every client share the same class to connect to the database : they use INSTANCE */
	INSTANCE;

	private CouchDbProperties properties;

	private GameDAO(){

		properties = new CouchDbProperties()
		.setDbName("game")
		.setCreateDbIfNotExist(false)
		.setProtocol("http")
		.setHost("localhost")
		.setPort(5984)
		.setMaxConnections(100)
		.setConnectionTimeout(0);

	}

	public static GameDAO getInstance(){
		return INSTANCE;
	}

	public List<Game> findAll(){
		List<Game> listGame = new ArrayList<Game>();
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		try { 
			JsonObject json = dbClient3.find(JsonObject.class, "_all_docs");
			listGame = parseJson(json);
			JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive("total_rows");
		} catch(NoDocumentException e) {
			System.out.println("no doc fund :s");
		}
		return listGame;
	}
	
	private List<Game> parseJson(JsonObject jsonObject) {
		List<Game> listGame = new ArrayList<Game>();
		JsonArray jsonArray = jsonObject.getAsJsonArray("rows");
		for (JsonElement jsonElement : jsonArray) {
			String id = jsonElement.getAsJsonObject().get("id").toString();
			listGame.add(new Game(id));
		}
		if(! listGame.isEmpty()) {
			System.out.println(listGame.get(0).getId());
		}
		
		return listGame;
	}

}	
	
