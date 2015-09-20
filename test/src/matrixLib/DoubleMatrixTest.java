package matrixLib;

import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleMatrixTest {

	private DoubleMatrix mat;
	
	@Test
	public void testIntMatrixInitialize() {
		mat = new DoubleMatrix(10, 10);
		
		assertEquals(10, mat.getRows());
		assertEquals(10, mat.getCols());
	}

	private void setMatrixElementsToValue(DoubleMatrix mat, double val) {
		for (int iRow = 0;iRow < mat.getRows(); iRow++) {
			for (int iCol = 0;iCol < mat.getCols(); iCol++) {
				mat.setElementAt(iRow, iCol, val);
			}
		}
	}
	
	@Test
	public void testValidateRowAndCol() {
		mat = new DoubleMatrix(2, 3);
		
		assertEquals(true, mat.validateRowAndCol(0, 0));
		assertEquals(true, mat.validateRowAndCol(0, 1));
		assertEquals(true, mat.validateRowAndCol(1, 0));
		assertEquals(true, mat.validateRowAndCol(1, 1));
		
		assertEquals(false, mat.validateRowAndCol(0, mat.getCols()));
		assertEquals(false, mat.validateRowAndCol(mat.getRows(), 0));
		assertEquals(false, mat.validateRowAndCol(mat.getRows(), mat.getCols()));
		
		assertEquals(false, mat.validateRowAndCol(-1, 0));
		assertEquals(false, mat.validateRowAndCol(0, -1));
		assertEquals(false, mat.validateRowAndCol(-1, -1));
		assertEquals(false, mat.validateRowAndCol(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void testMatrixSum() throws Exception {
		mat = new DoubleMatrix(3, 5);
		
		setMatrixElementsToValue(mat, 2.0);
		
		assertEquals(30.0, mat.sumElements(), 0.0);	
	}
	
	@Test
	public void testToStringValid() {
		mat = new DoubleMatrix(10, 10);
		
		assertEquals("Double 2D Matrix of size [rows=10, cols=10]", mat.toString());
	}
	
	public void initMatricesThreeByFiveWithValueTen(DoubleMatrix[] matrices) {
		for (int i = 0;i < matrices.length;i++) {
			matrices[i] = new DoubleMatrix(3, 5);
			setMatrixElementsToValue(matrices[i], 10.0);
		}
	}
	
	@Test
	public void testEquals() {
		DoubleMatrix[] matrices = new DoubleMatrix[3];
		
		initMatricesThreeByFiveWithValueTen(matrices);
		
		// Reflexive assertion
		assertEquals(true, matrices[0].equals(matrices[1]));
		
		// Symmetric assertion
		assertEquals(true, matrices[0].equals(matrices[1]));
		assertEquals(true, matrices[1].equals(matrices[0]));
		
		// Transitive assertion
		assertEquals(true, matrices[1].equals(matrices[2]));
		assertEquals(true, matrices[0].equals(matrices[2]));
		
		// non-nullity assertion
		assertEquals(false, matrices[0].equals(null));
		
		matrices[1].setElementAt(0,  0, Double.valueOf(100));
		assertEquals(false, matrices[0].equals(matrices[1]));
		assertEquals(false, matrices[1].equals(matrices[0]));
		
		mat = new DoubleMatrix(10, 10);
		assertEquals(false, mat.equals(matrices[0]));
		
	}
	
	@Test
	public void testHashCode() {
		DoubleMatrix[] matrices = new DoubleMatrix[2];
		
		initMatricesThreeByFiveWithValueTen(matrices);
		
		// Consistency assertion
		assertEquals(matrices[0].hashCode(), matrices[0].hashCode());
		// Same value matrix assertion
		assertEquals(matrices[0].hashCode(), matrices[1].hashCode());
	}

}
