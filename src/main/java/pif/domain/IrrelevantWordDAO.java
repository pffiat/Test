package pif.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.NoDocumentException;
import org.lightcouch.Page;

import pif.modele.IrrelevantWord;

public enum IrrelevantWordDAO {
	INSTANCE;

	private static final Log LOG = LogFactory.getLog(ArticleDAO.class);

	private CouchDbProperties properties;

	private IrrelevantWordDAO(){
		
		properties = new CouchDbProperties()
		.setDbName("irrelevant_words")
		.setCreateDbIfNotExist(false)
		.setProtocol("http")
		.setHost("localhost")
		.setPort(5984)
		.setMaxConnections(100)
		.setConnectionTimeout(0);

	}

	public static IrrelevantWordDAO getInstance() {
		return INSTANCE;
	}

	public Page<IrrelevantWord> findAll(String param) {
		CouchDbClient dbClient3 = new CouchDbClient(properties);
		Page<IrrelevantWord> listIrrelevantWord = null;

		try { 
			listIrrelevantWord = dbClient3.view("list/irrelevant_words_list").reduce(false).queryPage(10, param, IrrelevantWord.class);
		} catch(NoDocumentException e) {
			LOG.info("no doc fund :s");
		}
		return listIrrelevantWord;
	}


}
