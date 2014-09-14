package pif.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lightcouch.Page;

import pif.domain.ArticleDAO;
import pif.domain.GameDAO;
import pif.domain.IrrelevantWordDAO;
import pif.modele.Article;
import pif.modele.Game;
import pif.modele.IrrelevantWord;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Log LOG = LogFactory.getLog(Dashboard.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Dashboard.doGet()");

//		ArticleDAO articleDAO = ArticleDAO.getInstance();
//		Page<Article> listArticle = articleDAO.findAll(request.getParameter("param"));
		GameDAO gameDAO = GameDAO.getInstance();
		Page<Game> listGame = gameDAO.findAll(request.getParameter("param"));
		IrrelevantWordDAO irrelevantWordDAO = IrrelevantWordDAO.getInstance();
		Page<IrrelevantWord> listIrrelevantWord = irrelevantWordDAO.findAll(request.getParameter("param"));
		request.setAttribute("listGame", listIrrelevantWord);
		getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
