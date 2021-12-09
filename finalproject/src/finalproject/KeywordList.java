package finalproject;

import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> keywordList;
	
	public KeywordList(){
		this.keywordList = new ArrayList<Keyword>();
		keywordList.add(new Keyword("政大",5));
		keywordList.add(new Keyword("政治大學",5));
		keywordList.add(new Keyword("NCCU",5));
		keywordList.add(new Keyword("National Chengchi University",5));
		keywordList.add(new Keyword("台北",2));
		keywordList.add(new Keyword("文山",4));
		keywordList.add(new Keyword("信義",3));
		keywordList.add(new Keyword("景美",3));
		keywordList.add(new Keyword("木柵",4));
		keywordList.add(new Keyword("貓空",3));
		keywordList.add(new Keyword("指南路",4));
		
    }
	
	public void add(Keyword keyword){
		keywordList.add(keyword);
//		System.out.println("Done");
    }
	
}

