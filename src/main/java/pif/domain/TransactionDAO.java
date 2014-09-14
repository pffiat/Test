package pif.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;

import pif.modele.Game;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public enum TransactionDAO {
	
	INSTANCE;
	private static final Log LOG = LogFactory.getLog(TransactionDAO.class);

	private CouchDbProperties properties;
	
	private TransactionDAO() {
		properties = new CouchDbProperties()
		.setDbName("transactions")
		.setCreateDbIfNotExist(false)
		.setProtocol("http")
		.setHost("localhost")
		.setPort(5984)
		.setMaxConnections(100)
		.setConnectionTimeout(0);		
	}

	public static TransactionDAO getInstance(){
		return INSTANCE;
	}

	public List<Game> findAll(){
		List<Game> listGame = new ArrayList<Game>();
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		try { 
			JsonObject json = dbClient3.find(JsonObject.class, "_all_docs");
			listGame = parseJsonRows(json);
			JsonPrimitive jsonPrimitive = json.getAsJsonPrimitive("total_rows");
			LOG.info(jsonPrimitive);
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
		}
		if(! listGame.isEmpty()) {
			LOG.info(listGame.get(0).getId());
		}
		
		return listGame;
	}


}
