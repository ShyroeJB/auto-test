package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;
import org.junit.Test;

import main.VectorUnion;

/**
 * Spec  <br/>
 * Distinct data, don't have duplication  <br/>
 * Keep order of data, first vector and after second vector  <br/>
 * Accept different types in union vector
 */
public class VectorUnionTest {
	/**
	 * When we have two vector with same data and same data type, we don't accept the duplication
	 * We must have a vector result with unique/distinct data
	 */
	@Test
    public void testDistinctDataVector(){
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
            }
        };
        
        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
            }
        };

        Vector<Object> unionVector = VectorUnion.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, unionVector);
    }

	/**
	 * When we merge two vector the final vector must have data with the first data vector in first place and after the second vector data
	 */
	@Test
    public void testKeepOrderDataWithSameTypeVector(){
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add("first");
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add("second");
            }
        };
        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
            	add("first");
                add("second");
            }
        };
        

        Vector<Object> unionVector = VectorUnion.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, unionVector);
    }
	
	/**
	 * We accept a vector with different types of object
	 * But we also keep the order, first vector data first and after the second vector 
	 */
	@Test
    public void testKeepDifferentTypeDataAndKeepOrderVector(){
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add("first");
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
			private static final long serialVersionUID = 1L;

			{
                add(10);
            }
        };
        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
            	add("first");
                add(10);
            }
        };
        

        Vector<Object> unionVector = VectorUnion.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, unionVector);
    }
}
