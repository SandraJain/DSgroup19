

import java.util.ArrayList;

public class QuickSort {
	ArrayList<WebNode> list = new ArrayList<WebNode>();//WebPageList list = new WebPageList();
	
	public QuickSort(ArrayList<WebNode> list){
		this.list=list;
	}
	
	//quick sort
		public void sort(){
			if(list.size() == 0)
			{
				System.out.println("InvalidOperation");
			}
			else 
			{
				quickSort(0, list.size()-1);
//				System.out.println("Done");
			}

		}
		
		
		private void quickSort(int leftbound, int rightbound){
			//1. implement quickSort algorithm
			if(leftbound < rightbound) { //�p�ƨ�j �n�令�j��p
				int i=(leftbound-1);
				int pivot=list.get(rightbound).nodeScore; 
				for(int j=leftbound; j<=rightbound-1;j++) {
					if(list.get(j).nodeScore>pivot){
						i++;
						swap(i,j);
					}
					
				} 
				swap(i+1,rightbound);
				quickSort(leftbound,i);
				quickSort(i+2,rightbound);
				}
				
			}
		
		private void swap(int aIndex, int bIndex){
			WebNode temp = list.get(aIndex);
			list.set(aIndex, list.get(bIndex));
			list.set(bIndex, temp);
		}
		
		public void output(){
			//TODO: write output and remove all element logic here...
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<list.size();i++){
				WebNode k = list.get(i);
				if(i>0)sb.append(" ");
				sb.append(k.toString());
			}
			
			System.out.println(sb.toString());	
		}
}
