package com.ailk.test.junit4.sample.runners;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.ailk.test.junit4.sample.runners.category.FastTests;
import com.ailk.test.junit4.sample.runners.category.SlowTests;
import com.ailk.test.junit4.sample.runners.category.TestCaseA;
import com.ailk.test.junit4.sample.runners.category.TestCaseB;

/**
 * 
 * @author <a href="mailto:liulj5@asiainfo-linkage.com">liulj5</a> <br/>
 * @description 对测试类或方法分类<br/>
 * 
 *              <pre>
 *    步骤：
 *      Step1、定义一个Category标识，通常是一个空的接口，如（SlowTests，FastTests）
 *      Step2、通过@Category注解声明测试类（如TestCaseA，TestCaseB）属于某个Category标识
 *      Step3、定义一个Runner（如JUnit4CategoriesRunner）通过@IncludeCategory注解标明要执行哪个
 *             Category的测试类或方法，通过@ExcludeCategory注解标明不执行哪个Category的测试类或
 *             方法，通过@SuiteClasses注解指定要测试哪些类，如果某个测试类同时包含在IncludeCategory
 *             和ExcludeCategory中，则ExcludeCategory具有优先级。测试类的未声明@Category的方法不会
 *             在这个Runner中运行
 * </pre>
 * @date 2013-1-9
 */

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@ExcludeCategory(FastTests.class)
@SuiteClasses({ TestCaseA.class, TestCaseB.class })
public class JUnit4CategoriesRunnerSample {
	// empty body. Will run A.b and B.c, but not A.a
}
