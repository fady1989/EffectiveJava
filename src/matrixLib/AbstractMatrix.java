package matrixLib;

/*
 * 
 * Implemented currently as IMatrix instead of only DoubleMatrix
 * to be able to extend to other types as well, in case Double is 
 * too large (when elements get large). This will allow to add 
 * element types such as integer which could carry more elements
 * in memory. However, this will be at the sacrifice of precision.
 * 
 * It is the subclass's responsibility to provide other methods for
 * set and get elements to support primitive type for favoring performance
 * 
 */
public abstract class AbstractMatrix <T> {

	protected final int rows;
	protected final int cols;
	
	public AbstractMatrix(int rows, int cols) {
		
		if (rows <= 0 || cols <= 0) {
			throw new IllegalArgumentException("rows and cols must be positive vlaues");
		}
		
		this.rows = rows;
		this.cols = cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	/**
     * Returns a string of the format "MatrixType 2D Matrix of size [rows=getRows(), cols=getCols()]"
     * MatrixType will be replaced by the type of the created matrix
	 * Please note that the returned format is subject to change
     *
     * @return  a string representation of the object.
     */
	@Override
	public String toString() {
		return String.format("2D Matrix of size [rows=%d, cols=%d]", rows, cols);
	}

	protected boolean validateRowAndCol(int iRow, int iCol) {
		if (iRow >= 0 && iRow < rows) {
			if (iCol >= 0 && iCol < cols) {
				return true;
			}
		}
		
		return false;
	}
	
	public abstract void setElementAt(int iRow, int iCol, T val);
	
	public abstract T sumElements();
	
	public abstract T getElementAt(int iRow, int iCol);
	
	public abstract void multiplyByConstant(T val);
	
	public abstract AbstractMatrix<T> multiplyByMatrix(AbstractMatrix<T> matrix);
	
	@Override
	public abstract boolean equals(Object obj);
	
	@Override
	public abstract int hashCode();
}
