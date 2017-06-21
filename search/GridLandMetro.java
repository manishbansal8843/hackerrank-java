import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


public class GridLandMetro {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		long m= sc.nextLong();
		int k=sc.nextInt();
		HashMap<Integer,TreeMap<Integer,Integer>> tracks = new HashMap();
		for(int i=0;i<k;i++){
			int r= sc.nextInt();
			int c1=sc.nextInt();
			int c2=sc.nextInt();
			if(!tracks.containsKey(r)){	
				TreeMap<Integer,Integer> temp = new TreeMap<Integer, Integer>();
				temp.put(c1, c2);
				tracks.put(r, temp);
			
			}
			else{
				TreeMap<Integer,Integer> temp = tracks.get(r);
				if(temp.containsKey(c1)){
					temp.put(c1, Math.max(c2, temp.get(c1)));					
				}
				else
					temp.put(c1, c2);	
					
			}
			
		}
		long OccupiedCells= 0L;
		Set<Entry<Integer, TreeMap<Integer,Integer>>> parentSet = tracks.entrySet();
		Iterator<Entry<Integer, TreeMap<Integer,Integer>>> itrParent = parentSet.iterator();
		while(itrParent.hasNext()){
			Entry<Integer, TreeMap<Integer,Integer>> parentEntry = itrParent.next();
			
			TreeMap<Integer,Integer> temp = parentEntry.getValue();
			Set<Entry<Integer, Integer>> set = temp.entrySet();
			Iterator<Entry<Integer, Integer>> itr = set.iterator();
			int CurrentLowerBound=0;
			int CurrentUpperBound=0;

			while(itr.hasNext()){
				Entry<Integer, Integer> entry = itr.next();
				int c1=entry.getKey();
				int c2=entry.getValue();
				if(CurrentLowerBound==0 && CurrentUpperBound==0){
					CurrentLowerBound=c1;
					CurrentUpperBound=c2;
				}
				else{
					if(c1>CurrentUpperBound){
						OccupiedCells=OccupiedCells+CurrentUpperBound-CurrentLowerBound+1;
						CurrentLowerBound=c1;
						CurrentUpperBound=c2;
					}
					else if(c1==CurrentUpperBound){
						CurrentUpperBound=c2;
					}
					else{
						
						if(c2>CurrentUpperBound){
							
							CurrentUpperBound=c2;
						}
						
					}
				}
			}
			OccupiedCells=OccupiedCells+CurrentUpperBound-CurrentLowerBound+1;
		
		}
		long totalCels = n*m;
		
		System.out.println(totalCels-OccupiedCells);
		
	}
	
	

}
