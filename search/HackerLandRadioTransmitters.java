import java.util.Scanner;


public class HackerLandRadioTransmitters {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int[] locations = new int[100001];
        for(int i=0;i<n;i++){
        	locations[x[i]]++	;
        }
        
        int numberOfTransmittersRequired = 0;
               
        for(int i=1;i<100001;i++){
        	
        	if(locations[i]==0)
        		continue;
        	else{
        		int index = i+k;
        		if(i+k>100000){
        			index = 100000;
        		}
        		if(locations[index]!=0){
        		numberOfTransmittersRequired++;
        		i=i+2*k;
        		}
        		
        		else{
        			boolean houseFound=false;
        			int start = i+k-1;
        			if(start>100000)
        				start=100000;
        			for(int j=start;j>i;j--){
        				if(locations[j]!=0){
        	        		numberOfTransmittersRequired++;
        	        		i=j+k;
        	        		houseFound=true;
        	        		break;
        	        		}
        			}
        			if(!houseFound){
        				numberOfTransmittersRequired++;
        			}
        		}
        	}
        	
        }
        System.out.println(numberOfTransmittersRequired);
	}

}
