package matrixLib;

/*
 * 
 * Implemented currently as IMatrix instead of DoubleMatrix only
 * to be able to extend to other types as well, in case Double is 
 * too large (when elements get large). This will allow to add 
 * element types such as integer which could carry more elements
 * in memory. However, this will be at the sacrifice of precision.
 * 
 */
public abstract class IMatrix {

	public final int rows;
	public final int cols;
	
	public IMatrix(int rows, int cols) {
		
		if (rows <= 0 || cols <= 0) {
			throw new IllegalArgumentException("rows and cols must be positive vlaues");
		}
		
		this.rows = rows;
		this.cols = cols;
	}
	
	/**
     * Returns a string of the format "MatrixType 2D Matrix of size [rows=%d, cols=%d]"
     * MatrixType will be replaced by the type of the created matrix
	 * Please note that the returned format is subject to change
     *
     * @return  a string representation of the object.
     */
	@Override
	public String toString() {
		return String.format("2D Matrix of size [rows=%d, cols=%d]", rows, cols);
	}
	
}
