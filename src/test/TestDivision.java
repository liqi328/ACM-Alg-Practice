package test;

import leetcode.Division;

import org.junit.Assert;
import org.junit.Test;

public class TestDivision {
	@Test
	public void test() {
		int[] dividend = {-2147483648, 1004958205,2147483647, -2147483648, -2147483648, 2147483647};
		int[] divisor = {-3, -2137325331, 2147483647, -2147483648, 2, 2};
		int[] result = {715827882, 0, 1, 1, -1073741824, 1073741823};
		
		
		for(int i = 0; i < dividend.length; ++i){
			//System.out.println(Division.divide(dividend[i], divisor[i]));
			Assert.assertEquals(result[i], Division.divide(dividend[i], divisor[i]));
		}
		
	}

}
