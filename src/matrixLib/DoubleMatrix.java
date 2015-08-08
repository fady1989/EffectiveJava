package matrixLib;

public class DoubleMatrix extends IMatrix {

	private double[][] elements;
	private final String elemType = "Double";
	
	public DoubleMatrix(int rows, int cols) {
		super(rows, cols);
		
		elements = new double[rows][cols];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s", elemType, super.toString());
	}
	
}
