package matrixLib;

import javax.validation.constraints.NotNull;

import matrixLibExceptions.DimensionsMismatchException;

public final class DoubleMatrix extends AbstractMatrix<Double> {

	private double[][] elements;
	
	public DoubleMatrix(int rows, int cols) {
		super(rows, cols);
		
		elements = new double[rows][cols];
	}

	private void validateRowAndColOrThrowException(int row, int col) {
		if (!validateRowAndCol(row, col)) {
			throw new IllegalArgumentException("row or column is out of bound");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", "Double", super.toString());
	}

	@Override
	public void setElementAt(int row, int col, Double val) {
		validateRowAndColOrThrowException(row, col);
		
		elements[row][col] = val;
	}

	public Double sumElements() {
		double sum = 0.0;
		
		for (int iRow = 0;iRow < rows; iRow++) {
			for (int iCol = 0;iCol < cols; iCol++) {
				sum += elements[iRow][iCol];
			}
		}
		
		return sum;
	}

	@Override
	public Double getElementAt(int row, int col) {
		validateRowAndColOrThrowException(row, col);
		
		return elements[row][col];
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DoubleMatrix)) {
			return false;
		}
		
		DoubleMatrix mat = (DoubleMatrix) obj;
		
		if (this == mat) {
			return true;
		}
		
		if (this.getRows() != mat.rows || 
				this.getCols() != mat.cols) {
			return false;
		}
		
		for (int iRow = 0; iRow < rows; iRow++) {
			for (int iCol = 0; iCol < cols; iCol++) {
				if (elements[iRow][iCol] != mat.getElementAt(iRow, iCol).doubleValue()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void multiplyByConstant(@NotNull Double val) {
		for (int iRow = 0;iRow < rows; iRow++) {
			for (int iCol = 0;iCol < cols; iCol++) {
				elements[iRow][iCol] *= val;
			}
		}
	}

	@Override
	public DoubleMatrix multiplyByMatrix(@NotNull AbstractMatrix<Double> matrix) {
		
		if (this.cols != matrix.rows) {
			throw new DimensionsMismatchException("Rows and Columns are not matching in the matrices");
		}
		
		DoubleMatrix result = new DoubleMatrix(this.rows, matrix.cols);
		
		for (int iRow = 0;iRow < this.rows;iRow++) {
			for (int iCol = 0;iCol < matrix.cols;iCol++) {
				double rowByColResult = 0.0;
				for (int elem = 0;elem < this.cols;elem++) {
					rowByColResult += (elements[iRow][elem] * matrix.getElementAt(elem, iCol));
				}
				
				result.setElementAt(iRow, iCol, rowByColResult);
			}
		}
		
		return result;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		
		double prime = 32452867;
		
		for (int iRow = 0; iRow < rows; iRow++) {
			for (int iCol = 0; iCol < cols; iCol++) {

				hash = (hash) ^ (int) ((Math.pow(prime, iRow) + Math.pow(prime, iCol)) * elements[iRow][iCol]);
			}
		}

		return hash;
	}	
}
