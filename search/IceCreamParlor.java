import java.util.Scanner;


public class IceCreamParlor {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int trips = sc.nextInt();
		int[][] res= new int[trips][2];
		for(int i=0;i<trips;i++){
			int m= sc.nextInt();
			int n=sc.nextInt();
			int[] flavors = new int[n];
			for(int j=0;j<n;j++){
				flavors[j]=sc.nextInt();
				
			}
			res[i]=getDesiredFlavors(flavors,m);
		}
		printArray(res);
	}

	private static int[] getDesiredFlavors(int[] flavors,int m) {
		for(int j=0;j<flavors.length;j++){
			for(int i=j+1;i<flavors.length;i++){
				if(flavors[i]+flavors[j]==m){
					int[] ret= {j+1,i+1};
					return ret;
				}
			}
		}
		return null;
	}

	private static void printArray(int[][] res) {
		for(int i=0;i<res.length;i++){
			System.out.println(res[i][0]+" "+res[i][1]);
		}
	}

}
