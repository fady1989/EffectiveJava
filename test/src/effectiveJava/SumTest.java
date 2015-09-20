package effectiveJava;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class SumTest {

	private Sum mathObj = new Sum();
	
	@Test
	public void testSumFromZeroUpToAutobxed_Ten() {
		long res = mathObj.sumFromZeroUpToAutoboxed(10);
		
		assertEquals(45, res);
	}
	
	@Test
	public void testSumFromZeroUpToAutobxed_Negative() {
		long res = mathObj.sumFromZeroUpToAutoboxed(-10);
		
		assertEquals(0, res);
	}

	@Test
	public void testSumFromZeroUpTo_Ten() {
		long res = mathObj.sumFromZeroUpTo(10);
		
		assertEquals(45, res);
	}

	@Test
	public void testSumFromZeroUpTo_Negative() {
		long res = mathObj.sumFromZeroUpTo(-10);
		
		assertEquals(0, res);
	}
	
	@Ignore("Takes long time")
	@Test
	public void testSumFromZeroUpTo_MaxInt() {
		long res = mathObj.sumFromZeroUpTo(Integer.MAX_VALUE);
		
		assertEquals(2305843005992468481L, res);
	}
	
	@Ignore("Takes really long time")
	@Test
	public void testSumFromZeroUpToAutoboxed_MaxInt() {
		long res = mathObj.sumFromZeroUpToAutoboxed(Integer.MAX_VALUE);
		
		assertEquals(2305843005992468481L, res);
	}

	@Test
	public void testSumList_Positive() {
		
		List<Integer> vals = new ArrayList<Integer>();
		
		vals.add(1);
		vals.add(3);
		vals.add(100);

		long sum = (long) mathObj.sumList(vals);		
		assertEquals(104, sum);
	}
}
