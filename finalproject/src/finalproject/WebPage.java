package finalproject;


import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public int score;
	
	public WebPage(String url,String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(ArrayList<Keyword> keywordList) throws IOException{
		score = 0;
//		3.calculate score
		//score �٭n�[�W�ϥΪ̿�J�r�n*8
		for(Keyword k : keywordList){	
			score+=k.weight*counter.countKeyword(k.name);
			
		}
	}
	
}
