package finalproject;

import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> keywordList;
	
	public KeywordList(){
		this.keywordList = new ArrayList<Keyword>();
		keywordList.add(new Keyword("�F�j",5));
		keywordList.add(new Keyword("�F�v�j��",5));
		keywordList.add(new Keyword("NCCU",5));
		keywordList.add(new Keyword("National Chengchi University",5));
		keywordList.add(new Keyword("�x�_",2));
		keywordList.add(new Keyword("��s",4));
		keywordList.add(new Keyword("�H�q",3));
		keywordList.add(new Keyword("����",3));
		keywordList.add(new Keyword("��]",4));
		keywordList.add(new Keyword("�ߪ�",3));
		keywordList.add(new Keyword("���n��",4));
		
    }
	
	public void add(Keyword keyword){
		keywordList.add(keyword);
//		System.out.println("Done");
    }
	
}

