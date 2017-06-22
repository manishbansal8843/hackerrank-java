package search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
 
 
public class MinimumLoss {
 
      /**
      * @param args
      */
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long[] p= new long[n];
            for(int i=0;i<n;i++){
                  p[i]=sc.nextLong();
            }
           
            //System.out.println(getMinLossBF(n,p));
            System.out.println(getMinLossBS(n,p));
      }
 // Time complexity - NLogN
      private static long getMinLossBS(int n, long[] p) {
    	  long minLoss=Long.MAX_VALUE;
    	  TreeSet<Long> ts= new TreeSet<>();
    	  for(int i=n-2;i>=0;i--){
    		  long temp = p[i];
    		  ts.add(p[i+1]);
    		  SortedSet<Long> set = ts.headSet(temp);
    		  if(!set.isEmpty()){
    		  long diff= temp-set.last();
              if(diff<minLoss){
              minLoss=diff;
              }
    		  }
    		  
    	  }
		return minLoss;
	}

	//Time complexity N square
 
      private static long getMinLossBF(int n, long[] p) {
            long minLoss=Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                  for(int j=i+1;j<n;j++){
                        long temp = p[i]-p[j];
                        if(temp>0 && temp<minLoss){
                              minLoss=temp;
                        }
                  }
            }
            return minLoss;
      }
 
}
