package com.ailk.test.hamcrest.machers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class StartWith extends BaseMatcher<String> {
	private String except;

	private StartWith(String except) {
		this.except = except;
	}

	public static Matcher<String> startWith(String actual) {
		return new StartWith(actual);
	}

	@Override
	public boolean matches(Object actual) {
		return ((String) actual).startsWith(except);
	}

	@Override
	public void describeTo(Description arg0) {

	}
}
