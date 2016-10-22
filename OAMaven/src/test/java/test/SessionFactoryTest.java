package test;

import org.junit.Test;

public class SessionFactoryTest extends SpringUtil {

	@Test
	public void testSessionFactory() {
		context.getBean("sessionFactory");
	}
}
