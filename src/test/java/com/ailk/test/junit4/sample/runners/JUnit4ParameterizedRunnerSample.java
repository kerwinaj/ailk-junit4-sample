package com.ailk.test.junit4.sample.runners;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.ailk.util.CommonUtil;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description Parameterized Runner：JUnit框架标准Runner，实现了参数化的测试，这样只要写一个测试方法，
 *              就可以使用多个数据进行测试<br/>
 * @date 2013-1-9
 */
@RunWith(Parameterized.class)
public class JUnit4ParameterizedRunnerSample {
	private static CommonUtil util;

	private String inputStr;
	private String inputSubstr;
	private boolean except;

	@BeforeClass
	public static void tearUpBeforeClass() {
		util = new CommonUtil();
	}

	// 构造函数，对变量进行初始化
	public JUnit4ParameterizedRunnerSample(String inputStr, String inputSubstr, boolean except) {
		super();
		this.inputStr = inputStr;
		this.inputSubstr = inputSubstr;
		this.except = except;
	}

	/**
	 * Parameters 提供参数化数据，通常为static方法
	 * 
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "yyyy", "x", false }, { "yyyy", "y", false }, { "yyyyMM", "ym", false },
				{ null, null, true }, { "", "", true } ,{"yyyy","x",true}});
	}

	@Test
	public void testContains() {
		assertEquals(this.except, util.contains(inputStr, inputSubstr));
	}
	
	@Test
	public void testContainsByYuk(){
		assertThat("未包含期望的字符串",inputStr,containsString(inputSubstr));
	}
}
