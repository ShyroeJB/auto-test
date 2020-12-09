package main;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

public class VectorUnion {
	/**
	 * Make a merge of two Vector
	 * @param a First Vector
	 * @param b Second Vector
	 * @return The merging Vector with data a and after data b
	 */
	 public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) {
	    Vector<Object> union = new Vector<Object>();
	    Set<Object> unique = new LinkedHashSet<Object>();
	    unique.addAll(a);
	    unique.addAll(b);
	    union.addAll(unique);
	    return union;
	}
}
