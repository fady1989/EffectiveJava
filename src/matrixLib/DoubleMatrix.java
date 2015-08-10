package matrixLib;

public final class DoubleMatrix extends IMatrix<Double> {

	private double[][] elements;
	private final String elemType = "Double";
	
	public DoubleMatrix(int rows, int cols) {
		super(rows, cols);
		
		elements = new double[rows][cols];
	}

	private void validateRowAndColOrThrowException(int iRow, int iCol) throws Exception {
		if (!validateRowAndCol(iRow, iCol)) {
			throw new IllegalArgumentException("row or column is out of bound");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", elemType, super.toString());
	}

	public void setElementAt(int iRow, int iCol, Double val) throws Exception {
		validateRowAndColOrThrowException(iRow, iCol);
		val.doubleValue();
		elements[iRow][iCol] = val;
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

	public Double getElementAt(int iRow, int iCol) throws Exception {
		validateRowAndColOrThrowException(iRow, iCol);
		
		return elements[iRow][iCol];
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
		
		for (int iRow = 0;iRow < getRows(); iRow++) {
			for (int iCol = 0;iCol < getCols(); iCol++) {
				try {
					if (elements[iRow][iCol] != mat.getElementAt(iRow, iCol).doubleValue()) {
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
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
