


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

//import org.apache.jasper.tagplugins.jstl.core.Url; 

public class WebPage {
	public String url;//public URL url;//public String url;
	public String name;
	public WordCounter counter;
	public int score;
	 
	public WebPage(String url,String name){
		this.url = url;//.substring(7);
		System.out.println(this.url);  
		//System.out.println("111");
		this.name = name;
		try {
			counter = new WordCounter(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setScore(ArrayList<Keyword> keywordList) throws IOException{//KeywordList
		score = 0;
//		3.calculate score
		for(Keyword k : keywordList){	//Keyword k : keywordList.keywordList
			score+=k.weight*counter.countKeyword(k.name);
		}
	}
	public void setName(String name) {
		this.name = name;
	}
}