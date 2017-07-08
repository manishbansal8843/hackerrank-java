package search;

import java.util.LinkedList;
import java.util.Scanner;
 
 
public class ConnectedCellsIntheGrid {
 
      class Node{
            int col;
            int row;
            Node(int col,int row){
                  this.col=col;
                  this.row=row;
            }
      }
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] matrix = new int[rows][cols];
            boolean[][] visited = new boolean[rows][cols];
            for(int i=0;i<rows;i++){
                  for(int j=0;j<cols;j++){
                        matrix[i][j]=sc.nextInt();
                  }
            }
            System.out.println(getMaxRegionSize(matrix,visited));
      }
 
      private static int getMaxRegionSize(int[][] matrix, boolean[][] visited) {
            int maxRegionSize =0;
            for(int i=0;i<matrix.length;i++){
                  for(int j=0;j<matrix[0].length;j++){
                        int cell=matrix[i][j];
                        if(cell==0){
                              visited[i][j]=true;
                              continue;
                        }
                        else{
                              if(visited[i][j])
                                    continue;
                              int tempRegion = getRegionSize(i,j,visited,matrix);
                              if(tempRegion>maxRegionSize)
                                    maxRegionSize=tempRegion;
                             
                        }
                  }
            }
            return maxRegionSize;
      }
 
      private static int getRegionSize(int i, int j, boolean[][] visited,int[][] matrix) {
            LinkedList<int[]> list = new LinkedList<int[]>();
            int[] initial = {i,j};
            list.add(initial);
            visited[i][j]=true;
            int regionSize = 0;
            int rows = matrix.length;
            int cols = matrix[0].length;
            while(!list.isEmpty()){
                  int[] temp=list.remove();
                  int tempX=temp[0];
                  int tempY = temp[1];
                  regionSize++;
                  if(tempY-1>=0){
                	  if(matrix[tempX][tempY-1]==1 && !visited[tempX][tempY-1]){
                		  visited[tempX][tempY-1]=true;
                        int[] tempArray = {tempX,tempY-1};
                        list.add(tempArray);
                	  }
                  }
                  if(tempY+1<cols){
                        
                        if(matrix[tempX][tempY+1]==1 && !visited[tempX][tempY+1]){
                        	visited[tempX][tempY+1]=true;
                            int[] tempArray = {tempX,tempY+1};
                            list.add(tempArray);
                    	  }
                  }
                  if(tempX-1>=0){
                       
                        if(matrix[tempX-1][tempY]==1 && !visited[tempX-1][tempY]){
                        	visited[tempX-1][tempY]=true;
                            int[] tempArray = {tempX-1,tempY};
                            list.add(tempArray);
                    	  }
                  }
                  if(tempX+1<rows){
                        
                        if(matrix[tempX+1][tempY]==1 && !visited[tempX+1][tempY]){
                        	visited[tempX+1][tempY]=true;
                            int[] tempArray = {tempX+1,tempY};
                            list.add(tempArray);
                    	  }
                  }
                 
                  if(tempY-1>=0 && tempX-1>=0){
                        
                        if(matrix[tempX-1][tempY-1]==1 && !visited[tempX-1][tempY-1]){
                        	visited[tempX-1][tempY-1]=true;
                            int[] tempArray = {tempX-1,tempY-1};
                            list.add(tempArray);
                    	  }
                  }
                  if(tempY+1<cols && tempX+1<rows){
                        
                        if(matrix[tempX+1][tempY+1]==1 && !visited[tempX+1][tempY+1]){
                        	visited[tempX+1][tempY+1]=true;
                            int[] tempArray = {tempX+1,tempY+1};
                            list.add(tempArray);
                    	  }
                  }
                  if(tempX-1>=0 && tempY+1<cols){
                       
                        if(matrix[tempX-1][tempY+1]==1 && !visited[tempX-1][tempY+1]){
                        	visited[tempX-1][tempY+1]=true;
                            int[] tempArray = {tempX-1,tempY+1};
                            list.add(tempArray);
                    	  }
                  }
                  if(tempX+1<rows && tempY-1>=0){
                        
                        if(matrix[tempX+1][tempY-1]==1 && !visited[tempX+1][tempY-1]){
                        	visited[tempX+1][tempY-1]=true;
                            int[] tempArray = {tempX+1,tempY-1};
                            list.add(tempArray);
                    	  }
                  }
                 
            }
            return regionSize;
      }
 
}
