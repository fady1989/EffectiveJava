package effectiveJava;

import java.util.List;

public class Sum {
	
	public long sumFromZeroUpToAutoboxed(int upTo) {
		// Autoboxing sum variable decreases the efficiency significantly
		Long sum = 0L;
		
		for (long i = 0;i < upTo; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public long sumFromZeroUpTo(int upTo) {
		long sum = 0;
		
		for (long i = 0;i < upTo; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public double sumList(List<? extends Number> vals) {
		
		double sum = 0.0d;
		
		for (Number num : vals) {
			sum += num.doubleValue();
		}
		
		return sum;
	}
}
