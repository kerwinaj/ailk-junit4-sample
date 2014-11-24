package com.ailk.test.hamcrest.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static com.ailk.test.hamcrest.machers.StartWith.startWith;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description 
 * <pre>
 *  ExpectedException Rule：
 *  	对注解@Test(excepted=xxx.class)的一种替代实现，能在测试方法中更详细的指定期望的异常类型和异常消息
 * </pre>
 * 
 * <br/>
 * @date 2013-1-10
 */
@RunWith(JUnit4.class)
public class ExceptExceptionRuleSample {
	/**
	 * 试试去掉@Rule注解再测试，会出现什么情况？
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwsNothing() {

	}

	@Test
	public void throwsNullPointerException() {
		// 这个等效于使用注解@Test(excepted=NullPointerException.class)
		thrown.expect(NullPointerException.class);
		throw new NullPointerException();
	}

	@Test
	public void throwsNullPointerExceptionWithMessage() {
		thrown.expect(NullPointerException.class);

		// 是否包含子指定的子字符串"happened?"
		thrown.expectMessage("happened?");
		//指定更详细的
		thrown.expectMessage(startWith("What"));
		// 试试这个 thrown.expectMessage(startWith("what"));
		throw new NullPointerException("What happened?");
	}
}
