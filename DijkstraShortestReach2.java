import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;



public class DijkstraShortestReach2 {

	Graph g;
    int[] distance;
    HashSet<Integer> hsUnsettledNodes;
    HashSet<Integer> hsSettledNodes;
    int source;

    public class Graph{
        
		int V;
		public int getV() {
			return V;
		}

		List<HashMap<Integer,Integer>>[] aj;
		
		@SuppressWarnings("unchecked")
		public Graph(int V){
			this.V = V;
			aj=new List[V+1];
		}
		
		public void setAj(int src,int dest,int value){
			HashMap<Integer,Integer> hm1= new HashMap<Integer, Integer>();
			hm1.put(dest,value);
			HashMap<Integer,Integer> hm2= new HashMap<Integer, Integer>();
			hm2.put(src,value);
			if(aj[src]==null){
				aj[src]=new LinkedList<HashMap<Integer,Integer>>();
				aj[src].add(hm1);
				
			}
			else{
			aj[src].add(hm1);
			}
			
			if(aj[dest]==null){
				aj[dest]=new LinkedList<HashMap<Integer,Integer>>();
				aj[dest].add(hm2);
			}
			else{
			aj[dest].add(hm2);
			}
		}
		
		public String toString(){
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<=V;i++){
				sb.append("\n"+i);
				List<HashMap<Integer,Integer>> list = aj[i];
				Iterator<HashMap<Integer,Integer>> itr = list.iterator();
				while(itr.hasNext()){
					HashMap<Integer,Integer> hm = itr.next();
					for(Entry<Integer,Integer> entry:hm.entrySet()){
						int key=entry.getKey();
						int value=entry.getValue();
						sb.append("-->"+key+","+value);
					}
				}
			}
			return sb.toString();
		}
		
	
    }
	public static void main(String[] args) {
		DijkstraShortestReach2 dijkstraShortReach= new DijkstraShortestReach2();
		 Scanner in = new Scanner(System.in);
		 
	        int t = in.nextInt();
	        String[] results=new String[t];
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	    		dijkstraShortReach.g= dijkstraShortReach.new Graph(n);
	    		dijkstraShortReach.distance=new int[n+1];
	    		dijkstraShortReach.initialize();
	    		
	            int m = in.nextInt();
	            for(int a1 = 0; a1 < m; a1++){
	                int x = in.nextInt();
	                int y = in.nextInt();
	                int r = in.nextInt();
	                dijkstraShortReach.g.setAj(x,y,r);
	            }
	           // System.out.println(dijkstraShortReach.g);
	            int s = in.nextInt();
	            dijkstraShortReach.source=s;
	            dijkstraShortReach.distance[s]=0;
	            dijkstraShortReach.execute();
	            results[a0] = dijkstraShortReach.buildResString();
	        }
	        printArray(results);

	}
	private String buildResString() {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<distance.length;i++){
			if(i==source)
				continue;
			if(distance[i]==Integer.MAX_VALUE){
			sb.append("-1 ");
			continue;
			}
			sb.append(distance[i]+" ");
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	private void initialize() {
		for(int i=1;i<=g.getV();i++)
			distance[i]=Integer.MAX_VALUE;	
		hsUnsettledNodes=new HashSet<Integer>();
		hsSettledNodes=new HashSet<Integer>();
	}
	private void execute() {
		hsUnsettledNodes.add(source);
		while(!hsUnsettledNodes.isEmpty()){
			int node=getMinimumDistanceNode();
			hsUnsettledNodes.remove(node);
			hsSettledNodes.add(node);
			evaluateNode(node);
		}
	}
	private void evaluateNode(int node) {
		List<HashMap<Integer,Integer>> list = g.aj[node];
		Iterator<HashMap<Integer,Integer>> itr = list.iterator();
		while(itr.hasNext()){
			HashMap<Integer,Integer> hm = itr.next();
			for(Entry<Integer,Integer> entry:hm.entrySet()){
				int key=entry.getKey();
				int value=entry.getValue();
				if(!hsSettledNodes.contains(key)){
				if(distance[key]>distance[node]+value){
					distance[key]=distance[node]+value;
				}
				hsUnsettledNodes.add(key);
				}
			}
		}
	}
	private int getMinimumDistanceNode() {
		int minimum=0;
		
		Iterator<Integer> itr= hsUnsettledNodes.iterator();
		while(itr.hasNext()){
			int tempNode = itr.next();
			if(minimum==0)
				minimum=tempNode;
			else{
				minimum=distance[minimum]>distance[tempNode]?tempNode:minimum;
			}
		}
		return minimum;
	}

	 private static void printArray(String[] results) {
			int iLen = results.length;

			for (int i = 0; i < iLen; i++) {
				System.out.println(results[i]);
				
			}
		}
}
