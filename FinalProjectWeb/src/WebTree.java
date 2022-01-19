

import java.io.IOException;
import java.util.ArrayList; 


public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage){
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException{
		//1.compute the score of children nodes postorder
		for(WebNode child : startNode.children){
			setPostOrderScore(child,keywords);
		}
		//**setNode score of startNode
		startNode.setNodeScore(keywords);
		}
	String[][]s;
	public String[][] eularPrintTree(int size){
		s= new String[size][2];
		eularPrintTree(root);
		return s;
	}
	int num=0;
	private void eularPrintTree(WebNode startNode){
		int nodeDepth = startNode.getDepth();
		
		if(nodeDepth > 1) System.out.print("\n" + repeat("\t", nodeDepth-1));
		//print "("
		System.out.print("(");
		//print "name","score"
		System.out.print(startNode.webPage.name+","+startNode.nodeScore);
		s[num][0] = startNode.webPage.name;
		s[num][1] = startNode.webPage.url;
    	num++;
		
		//2.print child preorder
		for(WebNode child : startNode.children){
			eularPrintTree(child);
			
		}
		
		//print ")"
		System.out.print(")");
		
		/*for example
		(Soslab,459.0
				(Publication,286.2)
				(Projects,42.0
						(Stranger,0.0)
				)
				(MEMBER,12.0)
				(Course,5.3999999999999995)
		)
		*/
		if(startNode.isTheLastChild()) System.out.print("\n" + repeat("\t", nodeDepth-2));
		
	}
	
	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}
}