package part3;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class friendshipgraph {  
	
public Map<Person, List<Person>> map = new HashMap<Person, List<Person>>(); 

public void addVertex(Person Vertex) throws Exception {  
	  
    if (this.map.containsKey(Vertex)) { 
        throw new Exception("Wrong");  
    } else {  
        List<Person> friend = new ArrayList<Person>(); 
        map.put(Vertex, friend);  
    }  
}  

public void addEdge(Person m1, Person m2) {  
    int n = map.get(m1).size(), i = 0;  
    boolean choice = true;  
    while (i < n) {  
        if (map.get(m1).get(i) == m2) { 
            choice = false;  
            break;  
        }  
        i++;  
    }  
    if (choice) {  
        map.get(m1).add(m2);
    }  
}  

public int getDistance(Person m1, Person m2) {  
    Person now = m1;  
    Person f = m1;  
    int i = 0;  
    int lev = 0;  
    Queue<Person> queue = new LinkedList<Person>();  
    List<Person> crowed = new ArrayList<Person>();  
    if (m2 == m1) {
        return lev;  
    }  
    queue.offer(now);  
    crowed.add(now);  
    while (!queue.isEmpty()) { 
        now = queue.poll();  
        lev++;  
        int n = map.get(now).size();  
        while (i < n) {  
            f = map.get(now).get(i);  
            if (f == m2)  
                return lev; 
            if (!crowed.contains(f)) {  
                queue.offer(f);  
                crowed.add(f);  
            }  
            i++;  
        }  
        i = 0;  
    }  
    return -1; 
} 
}