import java.util.Arrays;
import java.util.Scanner;


public class CoinChangeProblem {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int coins = sc.nextInt();
		int[] arr = new int[coins];
		for(int i=0;i<coins;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(getNumberOfPoss(num,arr));
	}

	private static long getNumberOfPoss(int num, int[] arr) {
		long[][] matrix= new long[arr.length+1][num+1];
		for(int i=0;i<matrix.length;i++){
			matrix[i][0]=0;
		}
		for(int i=0;i<=num;i++){
			matrix[0][i]=0;
		}
		for(int i=1;i<=arr.length;i++){
			for(int j=1;j<=num;j++){
				if(arr[i-1]>j){
					matrix[i][j]=matrix[i-1][j];
					
				}
				else if(arr[i-1]==j){
					matrix[i][j]=1+matrix[i-1][j];
				}
				else if(arr[i-1]<j){
					matrix[i][j]=matrix[i-1][j]+matrix[i][j-arr[i-1]];
				}
					
			}
		}
		return matrix[arr.length][num];
	}

}
