package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Please type: Keyword");
		//HW10
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
		    //String urlStr = sc.next();
		    String keyword = sc.next();
		    
		    GoogleQuery googleQuery = new GoogleQuery(keyword);
		   
		    //WordCounter counter = new WordCounter(urlStr);
		    //System.out.println(counter.countKeyword(keyword));
		    
		    
		    WebPageList webPageList = new WebPageList();
		    WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Soslab");	//Call Google�����s��
		    webPageList.add(rootPage);
			WebTree tree = new WebTree(rootPage);
			//build childnode
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));//�l�������s��
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));//�l�������s��
			//tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));//�l�������s��
			tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));//�l�������s��
			//read 2 Yu 1.2 Fang 1.8 
			//Scanner scanner = new Scanner(System.in);
			
			
		      
		}
	}
}