package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		GoogleQuery googleQuery = new GoogleQuery("NCCU");
		WebPageList webPageList = new WebPageList();
		WebPage rootPage = new WebPage(googleQuery.url, "Google result");
		webPageList.add(rootPage);
		WebTree tree = new WebTree(rootPage);
		//build childnode
		googleQuery.query();
		for(int i = 0; i<20; i++) {
			tree.root.addChild(new WebNode(new WebPage(googleQuery.citeUrls.get(i), googleQuery.titles.get(i))));
		}
	}
}
