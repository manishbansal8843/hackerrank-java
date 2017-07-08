package dynamic_programming;

import java.util.Scanner;

public class Equal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int tc=sc.nextInt();
			for(int i=0;i<tc;i++){
				int N=sc.nextInt();
				int[] toffees= new int[N];
				int min=Integer.MAX_VALUE;
				for(int j=0;j<N;j++){
					int temp=sc.nextInt();
					toffees[j]=temp;
					if(temp<min)
						min=temp;
				}
				System.out.println(getMinOperations(min,toffees));
			
				
			}
	}

	private static int getMinOperations(int min, int[] toffees) {
		int minOp=Integer.MAX_VALUE;
		int minOpTemp=0;
		int minTemp=0;
			for(int i=0;i<3;i++){
                minTemp=min-i;
                minOpTemp=0;
				for(int j=0;j<toffees.length;j++){
					int toffee=toffees[j];
					if(toffee==minTemp)
						continue;
					else{
						int diff=toffee-minTemp;
						minOpTemp+=diff/5;
						if(diff%5!=0){
						
							int secDiff=diff%5;
							minOpTemp++;
							if(secDiff>=3)
								minOpTemp++;
							
						}
					}
						
				}
				if(minOpTemp<minOp)
					minOp=minOpTemp;
			}
			return minOp;
	}

}
