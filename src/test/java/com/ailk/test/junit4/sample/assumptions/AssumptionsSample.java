/**
 * 
 */
package com.ailk.test.junit4.sample.assumptions;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assume.*;
import static org.junit.Assert.*;

/**
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a>
 * @description <pre>
 * 
 * </pre>
 * @date 2013-1-15
 */
@RunWith(Parameterized.class)
public class AssumptionsSample {
	private int i;
	private int m;
	private int v;

	public AssumptionsSample(int i, int m, int v) {
		this.i = i;
		this.m = m;
		this.v = v;
	}

	@Parameters
	public static Collection<Integer[]> getData() {
		return Arrays.asList(new Integer[][] { { 20, 4, 5 }, { 20, 0, 10 }, { 30, 5, 6 } });
	}

	@Test
	public void testDivide() {
		/*:assumeThat(this.m, not(0));中如果this.m是0，则不执行后面的assertThat断言测试，直接跳过该测试用例函数,而且也返回该测试方法测试成功*/
//		System.out.println("["+this.m+"]before assumeThat");
//		assumeThat(this.m, not(0));
//		System.out.println("["+this.m+"]after assumeThat");
		assertThat(this.m,not(0));//assertThat出错的话,就不会继续向下执行了,直接返回该测试方法测试失败.如果没出错就会继续执行后面的语句
		assertThat(this.divide(this.i, this.m), is(this.v));
	}

	private int divide(int i, int m) {
		return i / m;
	}
}
