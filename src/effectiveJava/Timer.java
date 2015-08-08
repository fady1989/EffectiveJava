package effectiveJava;

public class Timer {
	
	public interface IMethod {
		void execute();
	}
	
	IMethod method;
	
	public long timerExecute() {
		long start = System.currentTimeMillis();
		
		method.execute();
		
		long end = System.currentTimeMillis();
		
		return (end - start);
	}
}
