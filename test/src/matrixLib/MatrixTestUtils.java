package matrixLib;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public abstract class MatrixTestUtils {

	static void setMatrixElementsToValue(DoubleMatrix mat, double val) {
		for (int iRow = 0;iRow < mat.getRows(); iRow++) {
			for (int iCol = 0;iCol < mat.getCols(); iCol++) {
				mat.setElementAt(iRow, iCol, val);
			}
		}
	}
	
	static void initMatricesThreeByFiveWithValueTen(DoubleMatrix[] matrices) {
		for (int i = 0;i < matrices.length;i++) {
			matrices[i] = new DoubleMatrix(3, 5);
			setMatrixElementsToValue(matrices[i], 10.0);
		}
	}
	
	static void multiplyTwoMatricesAndAssert( //
			int firstMatrixRows, //
			int firstMatrixCols, //
			double firstMatrixValue, //
			int secondMatrixRows, //
			int secondMatrixCols, //
			double secondMatrixValue) {
		DoubleMatrix mat1 = new DoubleMatrix(firstMatrixRows, firstMatrixCols);
		DoubleMatrix mat2 = new DoubleMatrix(secondMatrixRows, secondMatrixCols);
		
		double cellValue = firstMatrixValue * secondMatrixRows * mat1.getCols();
		
		setMatrixElementsToValue(mat1, firstMatrixValue);
		setMatrixElementsToValue(mat2, secondMatrixValue);

		DoubleMatrix result = mat1.multiplyByMatrix(mat2);
		
		assertThat(result.sumElements(), equalTo(mat1.getRows() * mat2.getCols() * cellValue));
	}
}
