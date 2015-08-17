package effectiveJava;

public class TestDerived extends Test<Integer> {

	public TestDerived(Integer data) {
		super(data);
	}
	
	public void setData(Integer d) {
		System.out.println("Derived setter");
		super.setData(d);
	}
	
	public Integer getData() {
		return data;
	}
	
}
