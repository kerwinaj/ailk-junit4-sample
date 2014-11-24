package com.ailk.test.hamcrest.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.ailk.util.CommonUtil;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description 
 * <pre>
 * Timeout Rule:
 * 		对注解@Test(timeout=<time>)的一种替代实现
 * </pre>
 * 
 * <br/>
 * @date 2013-1-10
 */
public class TimeoutRuleSample {
	/**
	 * 这个规则适用于当前测试类的所有@Test注解的方法， 而不需要对每个@Test注解设置timeout属性
	 */
	@Rule
	public Timeout timeout = new Timeout(1000);

	private static CommonUtil util = new CommonUtil();

	@Test
	public void test0() {
		util.deadLoop();
	}

	@Test
	public void test1() {
		util.deadLoop();
	}

	@Test(timeout = 3000L)
	public void test3() {
		// timeout属性会被忽略掉
		util.sleepTwoSeconds();
	}
}