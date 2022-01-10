import java.io.IOException;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebPage rootPage = new WebPage("https://www.google.com", "Google");
		GoogleQuery googleQuery = new GoogleQuery("郁方"+"+政大"); 
		googleQuery.query();
		WebTree tree = new WebTree(rootPage);
		for(int i = 0; i<10; i++) {
			tree.root.addChild(new WebNode(new WebPage(googleQuery.citeUrls.get(i), googleQuery.titles.get(i))));
		}
		//tree.root.addChild(new WebNode(new WebPage("http://foodiekuan.blogspot.com/","吃貨指南")));
		//tree.root.addChild(new WebNode(new WebPage("https://zh.wikipedia.org/wiki/%E5%9C%8B%E7%AB%8B%E8%87%BA%E7%81%A3%E5%A4%A7%E5%AD%B8","台大")));
		//tree.root.addChild(new WebNode(new WebPage("https://zh.wikipedia.org/wiki/%E8%BC%94%E4%BB%81%E5%A4%A7%E5%AD%B8","輔大")));
		//tree.root.addChild(new WebNode(new WebPage("https://zh.wikipedia.org/wiki/%E5%9C%8B%E7%AB%8B%E6%94%BF%E6%B2%BB%E5%A4%A7%E5%AD%B8","政大")));

		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		Keyword k = new Keyword("政大",5);
		Keyword k2 = new Keyword("政治大學",5);
		Keyword k3 = new Keyword("National Chengchi University",5);
		Keyword k4 = new Keyword("木柵",4);
		Keyword k5 = new Keyword("文山",4);
		Keyword k6 = new Keyword("指南路",4);
		Keyword k7 = new Keyword("信義",3);
		Keyword k8 = new Keyword("景美",3);
		Keyword k9 = new Keyword("貓空",3);
		Keyword k10 = new Keyword("台北",2);
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
		tree.eularPrintTree(11);

		QuickSort quickSort = new QuickSort(tree.root.children); 
		quickSort.sort();
		for(int i=0; i<tree.root.children.size();i++) {
			System.out.println(tree.root.children.get(i).webPage.name+ " //// " + tree.root.children.get(i).webPage.score);
		}
	}
	

}
