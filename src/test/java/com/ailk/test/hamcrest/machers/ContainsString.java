package com.ailk.test.hamcrest.machers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class ContainsString extends BaseMatcher<String> {
	private String except;

	private ContainsString(String except) {
		this.except = except;
	}

	public static Matcher<String> containsString(String actual) {
		return new ContainsString(actual);
	}

	@Override
	public boolean matches(Object actual) {
		return ((String) actual).contains(except);
	}

	@Override
	public void describeTo(Description arg0) {

	}
}
