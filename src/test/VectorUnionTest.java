package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;
import org.junit.Test;

import main.VectorUnion;

public class VectorUnionTest {
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
