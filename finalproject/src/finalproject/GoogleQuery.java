
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.URLDecoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery {
	
	public String searchKeyword;
	public String url;
	public String content;
	public ArrayList<String> citeUrls;
	public ArrayList<String> titles;
	public String[] suggests;

	public GoogleQuery(String searchKeyword){
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+searchKeyword+"+政大&oe=utf8&num=10";
		citeUrls = new ArrayList<String>();
		titles = new ArrayList<String>();
		suggests = new String[8];
	}
	
	private String fetchContent() throws IOException{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");//去爬Chrome的資料
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

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
		//System.out.println(doc);//.text());
		Elements lis = doc.select("div");
		 //System.out.println(lis);
		lis = lis.select(".kCrYT");
		 //System.out.println(lis);//.size());
		
		for(Element li : lis){
			try{
				//把奇怪的網址截掉
				citeUrls.add(li.select("a").get(0).attr("href").substring(7));
				String currentUrl = citeUrls.get(citeUrls.size()-1);
				//if(currentUrl.contains("youtube")) {
					//citeUrls.remove(citeUrls.size()-1);
					//continue;
				//}
				titles.add(li.select("a").get(0).select(".vvjwJb").text());

				if(currentUrl.contains("google")) {
					//citeUrls.remove(citeUrls.size()-1);
					titles.set(titles.size()-1, "Google");
					continue;
				}
				
		    	if(!currentUrl.contains("http")) {
		    		currentUrl = "https://" + currentUrl;
		    		System.out.println(currentUrl);
		    		System.out.println("222");
		   		}
		    	
				int wrong = currentUrl.indexOf("&sa=U&ved");
				
				citeUrls.set(citeUrls.size()-1, URLDecoder.decode(currentUrl.substring(0, wrong), "UTF-8"));
				/*
				//去掉重覆的網址
				if(citeUrls.get(citeUrls.size()-1).equals(citeUrls.get(citeUrls.size()-2))) {
					System.out.println("*****"+citeUrls.get(citeUrls.size()-1));
					citeUrls.remove(citeUrls.size()-1);
					continue;
				}
				*/
				if(titles.get(titles.size()-1).equals("")) {
					titles.set(titles.size()-1, "null");
					//continue;
				}
				//System.out.println(titles.get(titles.size()-1) + ","+ citeUrls.get(titles.size()-1)); 
				retVal.put(titles.get(titles.size()-1), citeUrls.get(citeUrls.size()-1));
				
				
			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
			
			//建議搜尋
			//System.out.println(doc);
			Elements sug = doc.select("div");//BNeawe s3v9rd AP7Wnd lRVwie
			sug = sug.select(".BNeawe.s3v9rd.AP7Wnd.lRVwie");
			//sug = sug.select(".s75CSd_OhScic_AB4Wff");
			for(int i = 0; i < sug.size(); i++){
				try{
					suggests[i] = sug.get(i).text();
					System.out.println(sug.get(i).text());
					//System.out.println(suggests.get(suggests.size()-1));
				} catch (IndexOutOfBoundsException e) {
//					e.printStackTrace();
				}
			}
		}
		return retVal;
	}
}
