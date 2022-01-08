package finalproject;

public class QuickSort {
	WebPageList list = new WebPageList();
	
	public QuickSort(WebPageList list){
		this.list=list;
	}
	
	//quick sort
		public void sort(){
			if(list.webPageList.size() == 0)
			{
				System.out.println("InvalidOperation");
			}
			else 
			{
				quickSort(0, list.webPageList.size()-1);
//				System.out.println("Done");
			}

		}
		
		
		private void quickSort(int leftbound, int rightbound){
			//1. implement quickSort algorithm
			if(leftbound < rightbound) { //�p�ƨ�j �n�令�j��p
				int i=(leftbound-1);
				int pivot=list.webPageList.get(rightbound).score;
				for(int j=leftbound; j<=rightbound-1;j++) {
					if(list.webPageList.get(j).score>pivot){
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
			WebPage temp = list.webPageList.get(aIndex);
			list.webPageList.set(aIndex, list.webPageList.get(bIndex));
			list.webPageList.set(bIndex, temp);
		}
		
		public void output(){
			//TODO: write output and remove all element logic here...
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<list.webPageList.size();i++){
				WebPage k = list.webPageList.get(i);
				if(i>0)sb.append(" ");
				sb.append(k.toString());
			}
			
			System.out.println(sb.toString());	
		}
}
