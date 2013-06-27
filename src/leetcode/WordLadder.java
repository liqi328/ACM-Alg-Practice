package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * http://www.cnblogs.com/shawnhue/archive/2013/06/05/leetcode_126.html
 * http://standalone.iteye.com/blog/1847367
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence 
 * from start to end, such that:
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example,
	
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
 * 
 * @author Liqi
 *
 */
public class WordLadder {
	public static void main(String[] args){
		WordLadder solution = new WordLadder();
		
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(solution.ladderLength(start, end, dict));
		
		ArrayList<ArrayList<String>> result = solution.findLadders(start, end, dict);  
        for(ArrayList<String> ary : result){  
            System.out.println(ary.toString());  
        }  
	}
	
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        dict.add(start);
        dict.add(end);        
        
        // calcualte ajacent matrix
        HashMap<String, ArrayList<String>> adj = new HashMap<String, ArrayList<String>>();
        for(String str : dict){
            char [] chars = str.toCharArray();            
            for(int i=0;i<start.length();i++){
                char old = chars[i];
                for(char c = 'a' ; c <= 'z'; c++){
                    if(c == old) continue;
                    chars[i] = c;
                    String newstr = new String(chars);
                    if(dict.contains(newstr)){                        
                        ArrayList<String> neighbours = adj.get(str);
                        if(neighbours == null){
                            neighbours = new ArrayList<String>();
                            neighbours.add(newstr);
                            adj.put(str, neighbours);
                        }else {
                            neighbours.add(newstr);
                        }
                    }                    
                }
                chars[i] = old;                 
            }
        }
        
        HashSet<String> visited = new HashSet<String>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(1, start));
        visited.add(start);
        int pathLen = 0;
        
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();
            if(n.str.equals(end)){
                pathLen = n.level;
                break;
            }else {
                ArrayList<String> neighbours = adj.get(n.str);
                if(neighbours == null || neighbours.isEmpty()) continue;
                for(String s : neighbours){
                    if(! visited.contains(s)){
                        Node p = new Node(n.level+1, s);
                        queue.add(p);
                        visited.add(s);
                    }                  
                }                
            }
        }
        
        return pathLen;
    }
	
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();
        
        dict.add(start);
        dict.add(end);
        
        // init adjacent graph        
        for(String str : dict){
            calcNeighbours(neighbours, str, dict);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        // BFS search queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(null, start, 1));
        
        // BFS level
        int previousLevel = 0;
        
        // mark which nodes have been visited, to break infinite loop
        HashMap<String, Integer> visited = new HashMap<String, Integer>(); 
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();            
            if(end.equals(n.str)){ 
                // fine one path, check its length, if longer than previous path it's valid
                // otherwise all possible short path have been found, should stop
                if(previousLevel == 0 || n.level == previousLevel){
                    previousLevel = n.level;
                    findPath(n, result);                    
                }else {
                    // all path with length *previousLevel* have been found
                    break;
                }                
            }else {
                HashSet<String> set = neighbours.get(n.str);                 
                
                if(set == null || set.isEmpty()) continue;
                // note: I'm not using simple for(String s: set) here. This is to avoid hashset's
                // current modification exception.
                ArrayList<String> toRemove = new ArrayList<String>();
                for (String s : set) {
                    
                    // if s has been visited before at a smaller level, there is already a shorter 
                    // path from start to s thus we should ignore s so as to break infinite loop; if 
                    // on the same level, we still need to put it into queue.
                    if(visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if(n.level+1 > occurLevel){
                            neighbours.get(s).remove(n.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s,  n.level+1);
                    queue.add(new Node(n, s, n.level + 1));
                    if(neighbours.containsKey(s))
                        neighbours.get(s).remove(n.str);
                }
                for(String s: toRemove){
                    set.remove(s);
                }
            }
        }

        return result;
    }
	
	public void findPath(Node n, ArrayList<ArrayList<String>> result){
        ArrayList<String> path = new ArrayList<String>();
        Node p = n;
        while(p != null){
            path.add(0, p.str);
            p = p.parent; 
        }
        result.add(path);
    }

    /*
     * complexity: O(26*str.length*dict.size)=O(L*N)
     */
    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            
            char old = chars[i]; 
            for (char c = 'a'; c <= 'z'; c++) {

                if (c == old)  continue;
                chars[i] = c;
                String newstr = new String(chars);                
                
                if (dict.contains(newstr)) {
                    HashSet<String> set = neighbours.get(str);
                    if (set != null) {
                        set.add(newstr);
                    } else {
                        HashSet<String> newset = new HashSet<String>();
                        newset.add(newstr);
                        neighbours.put(str, newset);
                    }
                }                
            }
            chars[i] = old;
        }
    }
	
    
    public class Node {
        public Node parent;
    	public int level;
        public String str;
        Node(int l, String s){
            str = s;
            level = l;
        }
        
        public Node(Node p, String s, int l){  
            parent = p;  
            str = s;  
            level = l;  
        }  
    }
}


