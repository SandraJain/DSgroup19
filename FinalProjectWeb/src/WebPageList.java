

import java.util.ArrayList;

public class WebPageList {
	ArrayList<WebPage> webPageList;
	public WebPageList() {
		webPageList = new ArrayList<WebPage>();
	}
	
	public void add(WebPage page) {
		webPageList.add(page);	
	}
}