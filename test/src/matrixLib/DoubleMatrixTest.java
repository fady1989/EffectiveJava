package matrixLib;

import static matrixLib.MatrixTestUtils.initMatricesThreeByFiveWithValueTen;
import static matrixLib.MatrixTestUtils.multiplyTwoMatricesAndAssert;
import static matrixLib.MatrixTestUtils.setMatrixElementsToValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import matrixLibExceptions.DimensionsMismatchException;

public class DoubleMatrixTest {

	private DoubleMatrix mat;
	
	@Test
	public void testIntMatrixInitialize() {
		mat = new DoubleMatrix(10, 10);
		
		assertThat(mat.getRows(), equalTo(10));
		assertThat(mat.getCols(), equalTo(10));
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
	
	@Test(expected=NullPointerException.class)
	public void testMultMatrixByConstant_Null() {
		mat = new DoubleMatrix(5, 5);
		
		mat.multiplyByConstant(null);
	}
	
	@Test
	public void testMultMatrixByConstant_Small() {
		mat = new DoubleMatrix(5, 5);
		
		setMatrixElementsToValue(mat, 5);
		mat.multiplyByConstant(2.0);
		
		assertThat(mat.sumElements(), equalTo(mat.getCols() * mat.getRows() * 5 * 2.0));
	}
	
	@Test
	public void testMultMatrixByConstant_MaxValue() {
		mat = new DoubleMatrix(5, 5);
		
		setMatrixElementsToValue(mat, 5);
		mat.multiplyByConstant(Double.MAX_VALUE);
		
		assertThat(mat.sumElements(), equalTo(Double.POSITIVE_INFINITY));
	}
	
	@Test(expected=NullPointerException.class)
	public void testMultMatrixByMatrix_Null() {
		mat = new DoubleMatrix(5, 5);
		
		mat.multiplyByMatrix(null);
	}
	
	@Test(expected=DimensionsMismatchException.class)
	public void testMultMatrixByMatrix_WrongDimensions() {
		mat = new DoubleMatrix(5, 2);
		DoubleMatrix mat2 = new DoubleMatrix(5, 10);

		mat.multiplyByMatrix(mat2);
		
	}
	
	@Test
	public void testMultMatrixByMatrix_SmallMatrices() {
		multiplyTwoMatricesAndAssert(2,  5,  2,  5,  2,  5);
	}	

	@Ignore("Takes long time.") //TODO: Optimize
	@Test
	public void testMultMatrixByMatrix_LargeMatrices() {
		multiplyTwoMatricesAndAssert(1000, 5000, 2, 5000, 1000, 5);
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
