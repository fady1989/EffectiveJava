package effectiveJava;

import java.math.BigInteger;

import effectiveJava.Timer.IMethod;

public class Main {

	public static void main(String[] args) {
		
		BigInteger bigInteger1 = BigInteger.valueOf(100);
		BigInteger bigInteger2 = bigInteger1.negate();
		
		System.out.println(bigInteger1.hashCode());
		System.out.println(bigInteger2.hashCode());
		
	}
	
	public static void useSumClass() {

		Sum math = new Sum();

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
