

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr) throws IOException{
    	this.urlStr = urlStr;
    	fetchContent();
    }
    
    public String fetchContent() throws IOException{
    	if(urlStr.contains("https://imbaicdf.nccu.edu.tw/index.php/food/")) {
    		return " ";
    	}
    	URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";																																																																																																																																																												
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		}
	
		return retVal;
    }
    
    public int countKeyword(String keyword) throws IOException{//, SSLHandshakeException{
    	try {
		if (content == null){
		    content = fetchContent();
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		// 1. calculates appearances of keyword
		int fromidx = 0;
		int found = -1;
		

		while((found = content.indexOf(keyword,fromidx))!=-1) {
			retVal++;
			fromidx = found + keyword.length();
			//System.out.print(fromIdx+"\n");
		}
	
		return retVal;
    	}catch(Exception e) {//SSLHandshake
    		return 0;
    	}
    }
}
