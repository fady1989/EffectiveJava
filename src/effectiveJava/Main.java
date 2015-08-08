package effectiveJava;

import effectiveJava.Timer.IMethod;
import matrixLib.IMatrix;

public class Main {

	private static final Sum math = new Sum();
	
	public static void main(String[] args) {
		
		
		// useSumClass();
		
	}
	
	public static void useSumClass() {
		Timer t = new Timer ();
		t.method = new IMethod() {
			@Override
			public void execute() {
				math.sumFromZeroUpTo(Integer.MAX_VALUE);
			}
		};
		 
		System.out.println(t.timerExecute());
		
		t.method = new IMethod() {
			@Override
			public void execute() {
				math.sumFromZeroUpToAutoboxed(Integer.MAX_VALUE);
			}
		};
		
		System.out.println(t.timerExecute());
	}
	
}
