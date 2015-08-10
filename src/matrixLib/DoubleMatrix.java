package matrixLib;

import java.io.IOException;

public final class DoubleMatrix extends AbstractMatrix<Double> {

	private double[][] elements;
	private final String elemType = "Double";
	
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
		return String.format("%s %s", elemType, super.toString());
	}

	@Override
	public void setElementAt(int row, int col, Double val) {
		validateRowAndColOrThrowException(row, col);
		
		elements[row][col] = val;
	}

	public Double sumElements() {
		double sum = 0.0;
		
		for (int iRow = 0;iRow < getRows(); iRow++) {
			for (int iCol = 0;iCol < getCols(); iCol++) {
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
		
		if (this.getRows() != mat.getRows() || 
				this.getCols() != mat.getCols()) {
			return false;
		}
		
		for (int iRow = 0; iRow < getRows(); iRow++) {
			for (int iCol = 0; iCol < getCols(); iCol++) {
				if (elements[iRow][iCol] != mat.getElementAt(iRow, iCol).doubleValue()) {
					return false;
				}
			}
		}
		
		return true;
	}
	

	@Override
	public int hashCode() {
		int hash = 0;
		
		double prime = 32452867;
		
		for (int iRow = 0; iRow < getRows(); iRow++) {
			for (int iCol = 0; iCol < getCols(); iCol++) {

				hash = (hash) ^ (int) ((Math.pow(prime, iRow) + Math.pow(prime, iCol)) * elements[iRow][iCol]);
			}
		}

		return hash;
	}
	
}
