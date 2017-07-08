package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BFSShortSearch {
    
    int[] distance;
    boolean[] visited;
    Graph g;
    
   class Graph{
        int V;
        ArrayList<Integer>[] adj;
        
        Graph(int V){
            this.V=V;
            adj=new ArrayList[V+1];
        }
        
        public void addEdge(int src,int dest){
            if(adj[src]==null){
                ArrayList<Integer> al = new ArrayList();
                al.add(dest);
                adj[src]=al;
            }
            else{
                adj[src].add(dest);
            }
            
            if(adj[dest]==null){
                ArrayList<Integer> al = new ArrayList();
                al.add(src);
                adj[dest]=al;
            }
            else{
                adj[dest].add(src);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        BFSShortSearch sol=new BFSShortSearch();
        for(int i=0;i<q;i++){
            int nodes=sc.nextInt();
            int edges=sc.nextInt();
            sol.initialize(nodes,edges);
            for(int j=0;j<edges;j++){
                int src=sc.nextInt();
                int dest = sc.nextInt();
                sol.g.addEdge(src,dest);
            }
            int source = sc.nextInt();
            sol.bfs(source);
            sol.printDistance();
        }
    }
    
    void initialize(int nodes,int edges){
        g= new Graph(nodes);
        distance=new int[nodes+1];
        visited= new boolean[nodes+1];
        for(int i=1;i<=nodes;i++){            
            distance[i]=-1;
        }
    }
    
    void bfs(int source){
        distance[source]=0;
        LinkedList<Integer> queue=new LinkedList();
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(g.adj[node]!=null){
                Iterator<Integer> itr = g.adj[node].iterator();
                while(itr.hasNext()){
                    int neighbor = itr.next();
                    if(!visited[neighbor]){
                        queue.add(neighbor);
                        distance[neighbor]=distance[node]+1;
                        visited[neighbor]=true;
                    }
                }
            }
        }
    }
    
    void printDistance(){
        int len = distance.length;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<len;i++){
            if(distance[i]==0)
                continue;
            if(distance[i]!=-1){
                sb.append(distance[i]*6+" ");
                continue;
            }
            sb.append(distance[i]+" ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
        
    }
}
