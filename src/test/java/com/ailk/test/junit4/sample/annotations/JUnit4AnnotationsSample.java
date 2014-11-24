package com.ailk.test.junit4.sample.annotations;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ailk.util.CommonUtil;
import com.ailk.util.IncorrectIp4FormatException;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description 描述了junit4各个注解的使用方法： <br/>
 * @date 2013-1-9
 */
@RunWith(JUnit4.class)
// @RunWith注解，标明运行这个测试类所使用的runner，未指定时为JUnit4
public class JUnit4AnnotationsSample {
	private static final Log log = LogFactory.getLog(JUnit4AnnotationsSample.class);
	private static CommonUtil util;
	private long start;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// @BeforeClass注解， 初始化资源，只运行一次，此方法必须为static
		log.info("Initialize test fixtures");
		util = new CommonUtil();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// @AfterClass注解， 释放或销毁资源，只运行一次，此方法必须为static
		log.info("Destroy test fixtures");
	}

	@Before
	public void setUp() throws Exception {
		// @Before注解， 针对每个测试方法运行之前都会调用一次
		start = System.currentTimeMillis();
		log.info("Reset timestamp 'start' to:" + start);
	}

	@After
	public void tearDown() throws Exception {
		// @After注解， 针对每个测试方法运行之后都会调用一次
		long timeUsedMills = System.currentTimeMillis() - start;
		log.info("Test time used:" + timeUsedMills + "ms");
	}

	@Test
	public void testIp2Long() {
		// @Test注解，每个注解对应一个测试方法/测试用例
		log.info("Execute testIp2Long");
		assertEquals(2130706433L, util.ip2Long("127.0.0.1"));
	}

	@Test(expected = IncorrectIp4FormatException.class)
	public void testIp2LongException() {
		// @Test注解的excepted属性，标明这个测试用例会抛出异常，且和expected指定的异常相同，相同则测试通过，不相同则不通过
		log.info("Execute testIp2LongException");
		assertEquals(1L, util.ip2Long(null));
	}

	@Test(timeout = 3000L)
	public void testSleepTwoSeconds() {
		// @Test注解的timeout属性，标明这个测试运行时间不能超过timeout指定的时间（单位：毫秒）,超过了则测试不通过
		log.info("Execute testSleepTwoSeconds");
		util.sleepTwoSeconds();
	}

	@Test(timeout = 1000L)
	public void testDeadLoop() {
		// 指定了timeout属性会启动一个新的线程来运行该测试（参照日志）
		// 测试死循环
		log.info("Execute testDeadLoop");
		util.deadLoop();
	}

	@Test
	@Ignore
	public void testMethodIngore() {
		// @Ignore注解，指定这个测试方法会忽略，不会执行
		log.info("Execute testMethodIngore");
		util.sleepTwoSeconds();
	}
}
