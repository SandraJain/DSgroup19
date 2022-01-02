package finalproject;


import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public int score;
	
	public WebPage(String url,String name){
		this.url = url;//.substring(7);
		System.out.println(this.url);  
		this.name = name;
		try {
			counter = new WordCounter(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void setScore(KeywordList keywordList) throws IOException{
		score = 0;
//		3.calculate score
		//score 還要加上使用者輸入字要*8
		for(Keyword k : keywordList.keywordList){	
			score+=k.weight*counter.countKeyword(k.name);
			
		}
	}
	
}
