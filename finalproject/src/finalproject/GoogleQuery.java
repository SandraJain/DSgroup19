package finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery {
	public String searchKeyword;
	public String url;
	public String content;

	public GoogleQuery(String searchKeyword){
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+searchKeyword+"&oe=utf8&num=20";
	}
	
	private String fetchContent() throws IOException{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");//去爬Chrome的資料
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null; //換webtree？

		while((line=bufReader.readLine())!=null){
			retVal += line;
		}
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException{
		if(content==null){
			content= fetchContent();
		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
//		System.out.println(doc.text());
		Elements lis = doc.select("div");
//		 System.out.println(lis);
		lis = lis.select(".kCrYT");
//		 System.out.println(lis.size());
		
		for(Element li : lis){
			try{
				citeUrls.add(li.select("a").get(0).attr("href"));
				titles.add(li.select("a").get(0).select(".vvjwJb").text());
				if(titles.get(titles.size()-1).equals("")) {
					continue;
				}
				System.out.println(titles.get(titles.size()-1) + ","+ citeUrls.get(titles.size()-1));
				retVal.put(titles.get(titles.size()-1), citeUrls.get(titles.size()-1));

			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
		}
		return retVal;
	}
}
