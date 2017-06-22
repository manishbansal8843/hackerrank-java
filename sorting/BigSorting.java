package sorting;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class BigSorting {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
      
        TreeSet<String> ts= new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()){
					return 1;
				}
				else if(o1.length()<o2.length()){
					return -1;
				}
				else{
					return o1.compareTo(o2)!=0?o1.compareTo(o2):1;
				}
				
			}
        	
		});
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            ts.add(in.next());
            
        }
      
       Object[] op= ts.toArray();
       for(int i=0;i<op.length;i++)
    	   System.out.println(op[i]);
        
    }
}
