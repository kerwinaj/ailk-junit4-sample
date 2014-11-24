/**
 * 
 */
package com.ailk.test.hamcrest.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a>
 * @description <pre>
 * 		TestWatchman (4.9版本后过时，使用TestWatcher)
 * </pre>
 * @date 2013-1-10
 */
public class WatchmanRuleSample {
	private static String watchedLog;

	@Rule
	public TestWatchman watchman = new TestWatchman() {

	};

	@Test
	public void fails() {
		//fail();
	}

	@Test
	public void succeeds() {
	}
}
