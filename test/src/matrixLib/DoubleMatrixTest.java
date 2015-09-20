package matrixLib;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleMatrixTest {

	private DoubleMatrix mat;
	
	@Test
	public void testIntMatrixInitialize() {
		mat = new DoubleMatrix(10, 10);
		
		assertThat(mat.getRows(), equalTo(10));
		assertThat(mat.getCols(), equalTo(10));
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
		
		assertThat(mat.validateRowAndCol(0, 0), equalTo(true));
		assertThat(mat.validateRowAndCol(0, 1), equalTo(true));
		assertThat(mat.validateRowAndCol(1, 0), equalTo(true));
		assertThat(mat.validateRowAndCol(1, 1), equalTo(true));

		assertThat(mat.validateRowAndCol(0, mat.getCols()), equalTo(false));
		assertThat(mat.validateRowAndCol(mat.getRows(), 0), equalTo(false));
		assertThat(mat.validateRowAndCol(mat.getRows(), mat.getCols()), equalTo(false));

		assertThat(mat.validateRowAndCol(-1, 0), equalTo(false));
		assertThat(mat.validateRowAndCol(0, -1), equalTo(false));
		assertThat(mat.validateRowAndCol(-1, -1), equalTo(false));
		assertThat(mat.validateRowAndCol(Integer.MAX_VALUE, Integer.MAX_VALUE), equalTo(false));
	}
	
	@Test
	public void testMatrixSum() throws Exception {
		mat = new DoubleMatrix(3, 5);
		
		setMatrixElementsToValue(mat, 2.0);
		
		assertThat(mat.sumElements(), equalTo(30.0));
	}
	
	@Test
	public void testToStringValid() {
		mat = new DoubleMatrix(10, 10);
		
		assertThat(mat.toString(), equalTo("Double 2D Matrix of size [rows=10, cols=10]"));
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
		assertThat(matrices[0].equals(matrices[0]), equalTo(true));
		
		// Symmetric assertion
		assertThat(matrices[0].equals(matrices[1]), equalTo(matrices[1].equals(matrices[0])));
		
		// Transitive assertion
		assertThat(matrices[1].equals(matrices[2]), equalTo(true));
		assertThat(matrices[0].equals(matrices[2]), equalTo(true));
		
		// non-nullity assertion
		assertThat(matrices[0].equals(null), equalTo(false));
		
		matrices[1].setElementAt(0,  0, Double.valueOf(100));
		assertThat(matrices[0].equals(matrices[1]), equalTo(false));
		assertThat(matrices[1].equals(matrices[0]), equalTo(false));
		
		mat = new DoubleMatrix(10, 10);
		assertThat(mat.equals(matrices[0]), equalTo(false));
		
	}
	
	@Test
	public void testHashCode() {
		DoubleMatrix[] matrices = new DoubleMatrix[2];
		
		initMatricesThreeByFiveWithValueTen(matrices);
		
		// Consistency assertion
		assertThat(matrices[0].hashCode(), equalTo(matrices[0].hashCode()));
		// Same value matrix assertion
		assertThat(matrices[0].hashCode(), equalTo(matrices[1].hashCode()));
	}

}
