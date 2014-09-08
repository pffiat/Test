package domain;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;

import com.google.gson.JsonObject;

import modele.Game;

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

	public Game getFirst(){
		Game game = new Game();
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		try { 
			JsonObject json = dbClient3.find(JsonObject.class, "http://localhost:5984/_utils/database.html?game");
		} catch(NoDocumentException e) {
			System.out.println("no doc fund :s");
		}
		//System.out.println(json);
		return game;
	}

}
