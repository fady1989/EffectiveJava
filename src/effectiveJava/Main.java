package effectiveJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	/////////////////////////////////////////////////////////////////

	static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		HashSet<E> u = new HashSet<>(s1);
		u.addAll(s2);
		return u;
	}
	
	static void useUnion() {
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		s1.addAll( Arrays.asList(new String[] {"A", "B"}) );
		s2.addAll( Arrays.asList(new String[] {"B", "C"}) );
		Set<String> s3 = union(s1, s2);
		
		System.out.println(s3.toString());
		
	}

	/////////////////////////////////////////////////////////////////
	
	static void initializeInGenericClasses() throws Exception {
		Test<String> t1 = new Test<String>();
		Test<String> t2 = new Test<String>(String.class);
		Test<String> t3 = new Test<String>("!");
		
		t1.setData("Hello");
		t2.setData("World");
		
		System.out.println(t1.getData());
		System.out.println(t2.getData());
		System.out.println(t3.getData());
	}
	
	/////////////////////////////////////////////////////////////////
	
	interface UnaryFunction<T> {
		T apply(T o);
	}
	
	private static UnaryFunction<Object> IDENTITY_FUNCTION =
			new UnaryFunction<Object>() {
		@Override
		public Object apply(Object o) {
			return o;
		}
	};
	
	/* 
	 * It is OK to suppress the warning here as IDENTITY_FUNCTION
	 * just returns the object without doing anything
	*/
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	
	public static void useIdentityFunction() {
		String[] strings = { "A", "B", "C" };
		UnaryFunction<String> sameString = identityFunction();
		for (String s : strings) {
			System.out.println(sameString.apply(s));
		}
		
		Number[] numbers = { 1, 2, 3 };
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number n : numbers) {
			System.out.println(sameNumber.apply(n));
		}
	}
	
	/////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		useUnion();
		
		initializeInGenericClasses();
		
		useIdentityFunction();
		
	}
	
//	public static void useSumClass() {
//
//		Sum math = new Sum();
//
//		Timer t = new Timer ();
//		t.method = new IMethod() {
//			@Override
//			public void execute() {
//				math.sumFromZeroUpTo(Integer.MAX_VALUE);
//			}
//		};
//		 
//		System.out.println(t.timerExecute());
//		
//		t.method = new IMethod() {
//			@Override
//			public void execute() {
//				math.sumFromZeroUpToAutoboxed(Integer.MAX_VALUE);
//			}
//		};
//		
//		System.out.println(t.timerExecute());
//	}
//	
}
