package com.ailk.test.hamcrest.rules;

import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> 
 * @description 
 * <pre>
 * 	TestName Rule:
 * 		可以某个测试方法中获取该测试方法的字面上意义的名字，继承WatchmanRule
 * </pre>
 * <br/>
 * <br/>
 * @date 2013-1-10
 */
public class TestNameRuleSample {
	 @Rule
	  public TestName name = new TestName();
	  
	  @Test
	  public void testA() {
	    assertEquals("testA", name.getMethodName());
	  }
	  
	  @Test
	  public void testB() {
	    assertEquals("testB", name.getMethodName());
	  }
}
