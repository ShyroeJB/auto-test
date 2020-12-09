package main;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class VectorUnion {
	 public static Vector<Object> unionSet(Vector a, Vector b) {
	    Vector<Object> union = new Vector<Object>();
	    
	    Set<Object> unique = new HashSet<Object>();
	    unique.addAll(a);
	    unique.addAll(b);
	    
	    union.addAll(unique);
	    return union;
	}
}
