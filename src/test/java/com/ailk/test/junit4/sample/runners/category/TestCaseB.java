package com.ailk.test.junit4.sample.runners.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTests.class, FastTests.class})
public class TestCaseB {
  @Test
  public void c() {
  }
}