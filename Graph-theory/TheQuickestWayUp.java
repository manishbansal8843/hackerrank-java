import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TheQuickestWayUp {
	Graph g;
	boolean[] visited;
	int[] distance;
	boolean[] snakesOrLadder;
	class Graph{
		int V;
		List<Integer>[] adjL;
		
		Graph(int V){
			this.V = V;
			adjL=new List[V+1];
		}
		
		void setAdj(int start,int end){
			if(adjL[start]==null){
				ArrayList<Integer> al=new ArrayList<Integer>();
				al.add(end);
				adjL[start]=al;
			}
			else{
				adjL[start].add(end);
			}
		}
		void initializeAdj(){
			for(int i=1;i<=V;i++){
			
				if(adjL[i]==null){
					ArrayList<Integer> al=new ArrayList<Integer>();
					for(int j=1;j<=6 && i+j<=V;j++){
						al.add(i+j);
					}
					adjL[i]=al;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		TheQuickestWayUp quickestWayUp = new TheQuickestWayUp();
		for(int i=0;i<tc;i++){
			quickestWayUp.g=quickestWayUp.new Graph(100);
			quickestWayUp.intialize(1);
			int laddres = sc.nextInt();
			for(int j=0;j<laddres;j++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				quickestWayUp.g.setAdj(start, end);
				quickestWayUp.snakesOrLadder[end]=true;
			}
			int snakes = sc.nextInt();
			for(int j=0;j<snakes;j++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				quickestWayUp.g.setAdj(start, end);
				quickestWayUp.snakesOrLadder[end]=true;
			}
			quickestWayUp.g.initializeAdj();
			
			quickestWayUp.bfs();
			System.out.println(quickestWayUp.distance[100]);
		}
	}

	private void bfs() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		distance[1]=0;
		visited[1]=true;
		while(!list.isEmpty()){
			Integer node =list.pollFirst();
			
			
			ArrayList<Integer> al = (ArrayList)g.adjL[node];
			boolean directjump = false;
			if(al.size()==1 && snakesOrLadder[al.get(0)])
				directjump=true;
			Iterator<Integer> itr = al.iterator();
			while(itr.hasNext()){
				Integer next=itr.next();
				if(next==100){
					if(!directjump)
					distance[next]=distance[node]+1;
					else
						distance[next]=distance[node];
					return;
				}
				if(!visited[next]){
					visited[next]=true;
					list.add(next);
					if(!directjump)
						distance[next]=distance[node]+1;
						else
							distance[next]=distance[node];				}
			}
		}
	}

	private void intialize(int source) {
		visited=new boolean[g.V+1];
		distance=new int[g.V+1];
		for(int i=1;i<=g.V;i++){
			distance[i]=-1;
		}
		distance[source]=0;
		snakesOrLadder=new boolean[g.V+1];
	}

}
