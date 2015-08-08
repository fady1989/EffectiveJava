package matrixLib;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleMatrixTest {

	private IMatrix mat;
	
	@Test
	public void testIntMatrixInitialize() {
		mat = new DoubleMatrix(10, 10);
		
		assertEquals(10, mat.rows);
		assertEquals(10, mat.cols);
	}

	@Test
	public void testToStringValid() {
		mat = new DoubleMatrix(10, 10);
		
		assertEquals("Double 2D Matrix of size [rows=10, cols=10]", mat.toString());
	}

}
