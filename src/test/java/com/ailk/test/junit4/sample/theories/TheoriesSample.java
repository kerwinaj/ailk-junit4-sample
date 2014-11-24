package com.ailk.test.junit4.sample.theories;

import static com.ailk.test.hamcrest.machers.ContainsString.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesSample {
	private static final Log log = LogFactory.getLog(TheoriesSample.class);

	@DataPoint
	public static String GOOD_USERNAME = "optimus";
	@DataPoint
	public static String USERNAME_WITH_SLASH = "optimus/prime";

	@Theory
	public void filenameIncludesUsername(String username) {
		log.info("Execute test width:" + username);
		assumeThat(username, not(containsString("/")));
		assertThat(new User(username).configFileName(), containsString(username));
	}
}

class User {
	private String configName;
	private static final String BASE_URL = "http://localhost/";

	public User(String username) {
		this.configName = BASE_URL + username;
	}

	public String configFileName() {
		return this.configName;
	}
}