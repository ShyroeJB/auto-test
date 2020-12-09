package main;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class VectorUnion {
	 public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) {
	    Vector<Object> union = new Vector<Object>();
	    
	    Set<Object> unique = new HashSet<Object>();
	    unique.addAll(a);
	    unique.addAll(b);
	    
	    union.addAll(unique);
	    return union;
	}
}
