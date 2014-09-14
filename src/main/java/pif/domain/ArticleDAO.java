package pif.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;
import org.lightcouch.Page;

import pif.modele.Article;
import pif.modele.Article;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public enum ArticleDAO {

	/* don't put any variable in this class => different clients would share personal data and produce a bit mix*/
	/* Every client share the same class to connect to the database : they use INSTANCE */
	INSTANCE;

	private static final Log LOG = LogFactory.getLog(ArticleDAO.class);

	private CouchDbProperties properties;

	private ArticleDAO(){
		
		properties = new CouchDbProperties()
		.setDbName("articles")
		.setCreateDbIfNotExist(false)
		.setProtocol("http")
		.setHost("localhost")
		.setPort(5984)
		.setMaxConnections(100)
		.setConnectionTimeout(0);

	}

	public static ArticleDAO getInstance() {
		return INSTANCE;
	}

	public Page<Article> findAll(String param) {
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		Page<Article> listArticle = null;

		try { 
			listArticle = dbClient3.view("authors/articles").reduce(false).queryPage(10, null, Article.class);
		} catch(NoDocumentException e) {
			LOG.info("no doc fund :s");
		}
		return listArticle;
	}

	private List<Article> parseJsonRows(JsonObject jsonObject) {
		List<Article> listGame = new ArrayList<Article>();
		JsonArray jsonArray = jsonObject.getAsJsonArray("rows");
		for (JsonElement jsonElement : jsonArray) {
			String id = jsonElement.getAsJsonObject().get("id").toString();
			listGame.add(new Article(id));
		}
		if(! listGame.isEmpty()) {
			LOG.info(listGame.get(0).getId());
		}

		return listGame;
	}

}	


