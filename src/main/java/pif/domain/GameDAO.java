package pif.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;
import org.lightcouch.Page;

import pif.modele.Game;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public enum GameDAO implements Serializable{

	/* don't put any variable in this class => different clients would share personal data and produce a bit mix*/
	/* Every client share the same class to connect to the database : they use INSTANCE */
	INSTANCE;

	private static final Log LOG = LogFactory.getLog(GameDAO.class);

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

	public static GameDAO getInstance() {
		return INSTANCE;
	}

	public Page<Game> findAll(String param) {
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		Page<Game> listGame = null;
		String parse = null;
		byte[] bytes = null;
		if(param != null) {
			LOG.debug("param"+param);
			bytes = param.getBytes();
			byte[] decode = Base64.decodeBase64(bytes);
			parse = new String(decode);
			final JsonObject json = new JsonParser().parse(parse).getAsJsonObject();
		}

		try { 
			listGame = dbClient3.view("words/values_by_words").reduce(false).queryPage(10, null, Game.class);
		} catch(NoDocumentException e) {
			LOG.info("no doc fund :s");
		}
		return listGame;
	}

	private List<Game> parseJsonRows(JsonObject jsonObject) {
		List<Game> listGame = new ArrayList<Game>();
		JsonArray jsonArray = jsonObject.getAsJsonArray("rows");
		for (JsonElement jsonElement : jsonArray) {
			String id = jsonElement.getAsJsonObject().get("id").toString();
			listGame.add(new Game(id));
		}
		if(! listGame.isEmpty()) {
			LOG.info(listGame.get(0).getId());
		}

		return listGame;
	}

}	

