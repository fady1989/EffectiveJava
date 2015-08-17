package effectiveJava;

public class Test<T> {
	
	T data;
	
	/* This warning can be safely suppressed as the only way to set this element
	 * is through setData which takes T as input. So we are safe.
	 */
	@SuppressWarnings("unchecked")
	public Test() {
		data = (T) new Object();
	}
	
	public Test(Class<T> t) throws Exception {
		data = t.newInstance();
	}
	
	public Test(T d) {
		this.data = d;
	}
	
	public void setData(T d) {
		System.out.println("Super setter");
		data = d;
	}
	
	public T getData() {
		return data;
	}
	
}
