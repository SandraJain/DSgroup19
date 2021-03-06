package finalproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}

		WebPage rootPage = new WebPage("https://www.google.com", "Google");
		String input = request.getParameter("keyword");
		
		//handle " "
		//input.replaceAll(" ", "+");
		
		if(input.contains(" ")) {
			input = input.substring(0, input.indexOf(" ")-1)+"+"+input.substring(input.indexOf(" ")+1, input.length()-1);
		}
		
		
		GoogleQuery googleQuery = new GoogleQuery(input);
		HashMap<String, String> query = googleQuery.query();

		WebTree tree = new WebTree(rootPage);
		for(int i = 0; i<10; i++) { //googleQuery.titles.size()
			try {
			String url = googleQuery.citeUrls.get(i);
			System.out.println(url);
			String title = googleQuery.titles.get(i);
			System.out.println(i);
			System.out.println(title);
			tree.root.addChild(new WebNode(new WebPage(url, title)));
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		Keyword k = new Keyword("??????",5);
		Keyword k2 = new Keyword("????????????",5);
		Keyword k3 = new Keyword("National Chengchi University",5);
		Keyword k4 = new Keyword("??????",4);
		Keyword k5 = new Keyword("??????",4);
		Keyword k6 = new Keyword("?????????",4);
		Keyword k7 = new Keyword("??????",3);
		Keyword k8 = new Keyword("??????",3);
		Keyword k9 = new Keyword("??????",3);
		Keyword k10 = new Keyword("??????",2);
		Keyword k11 = new Keyword("North Carolina Central University",-5);

		keywords.add(k);
		keywords.add(k2);
		keywords.add(k3);
		keywords.add(k4);
		keywords.add(k5);
		keywords.add(k6);
		keywords.add(k7);
		keywords.add(k8);
		keywords.add(k9);
		keywords.add(k10);
		keywords.add(k11);

		tree.setPostOrderScore(keywords);

		QuickSort quickSort = new QuickSort(tree.root.children); 
		quickSort.sort();
//		tree.eularPrintTree();
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		for(int i =0; i<10; i++) { //tree.root.children.size()
			try {
				//if(tree.root.children.get(i).webPage.score < 0) continue;
			if(tree.root.children.get(i).webPage.name.equals("null")) {
				tree.root.children.get(i).webPage.setName(input);
			}
			hashmap.put(tree.root.children.get(i).webPage.name, tree.root.children.get(i).webPage.url);
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		
		String[][] s = new String[hashmap.size()][2];
		try {
			s=tree.eularPrintTree(11); //11
		}catch(IndexOutOfBoundsException e) {
			System.out.println("index out of bound qwq");
		}
		request.setAttribute("hashmap", s);
//		int num = 0;
//		for(Entry<String, String> entry : hashmap.entrySet()) {
//		    String key = entry.getKey();
//		    String value = entry.getValue();
//		    s[num][0] = key;
//		    s[num][1] = value;
//		    System.out.println(key+"///" + value);
//		    num++;
//		}
		request.setAttribute("suggest", googleQuery.suggests);
		request.getRequestDispatcher("googleitem.jsp").forward(request, response);
		/* old
		WebPage rootPage = new WebPage("https://www.google.com", "Google");
		GoogleQuery googleQuery = new GoogleQuery("food"+"+NCCU"); 
		googleQuery.query();
		WebTree tree = new WebTree(rootPage);
		for(int i = 0; i<5; i++) {
			tree.root.addChild(new WebNode(new WebPage(googleQuery.citeUrls.get(i), googleQuery.titles.get(i))));
		}
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		Keyword k = new Keyword("??????",5);
		Keyword k2 = new Keyword("????????????",5);
		Keyword k3 = new Keyword("National Chengchi University",5);
		Keyword k4 = new Keyword("??????",4);
		Keyword k5 = new Keyword("??????",4);
		Keyword k6 = new Keyword("?????????",4);
		Keyword k7 = new Keyword("??????",3);
		Keyword k8 = new Keyword("??????",3);
		Keyword k9 = new Keyword("??????",3);
		Keyword k10 = new Keyword("??????",2);
		Keyword k11 = new Keyword("North Carolina Central University",-5);

		keywords.add(k);
		keywords.add(k2);
		keywords.add(k3);
		keywords.add(k4);
		keywords.add(k5);
		keywords.add(k6);
		keywords.add(k7);
		keywords.add(k8);
		keywords.add(k9);
		keywords.add(k10);
		keywords.add(k11);

		tree.setPostOrderScore(keywords);

		QuickSort quickSort = new QuickSort(tree.root.children); 
		quickSort.sort();
		tree.eularPrintTree();
		*/
		/* from TA
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[query.size()][2];
		request.setAttribute("query", s);
		int num = 0;
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    s[num][0] = key;
		    s[num][1] = value;
		    num++;
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
