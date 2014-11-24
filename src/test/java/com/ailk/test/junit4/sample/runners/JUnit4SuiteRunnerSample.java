package com.ailk.test.junit4.sample.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ailk.test.junit4.sample.runners.suites.TestCase0;
import com.ailk.test.junit4.sample.runners.suites.TestCase1;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description 
 * <pre>
 * Suite Runner：JUnit框架标准Runner，通过指定RunWith注解为Suite.class。可以使你手工的创建一个测试套件
 *              ， 套件里面包含了多个类的多个测试 方法 Suite.SuiteClasses注解，用来指定这个测试套件所要包含的测试类
 * ，利于模块化测试
 * <pre>
 * <br/>
 * @date 2013-1-9
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestCase0.class, TestCase1.class })
public class JUnit4SuiteRunnerSample {
	// 类body里不需要任何内容
	// the class remains empty
	// used only as a holder for the above annotations
}
