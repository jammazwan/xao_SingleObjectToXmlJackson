package jammazwan.xao;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.City;

public class XaoTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXao() throws Exception {
		City city = new City(1, "Austin, TX", "USA", 1234567, 123, 12345);
		String reply = template.requestBodyAndHeader("direct:xao", city,"CamelFileName", "city.xml", String.class);
		assertTrue(reply.contains("<city>Austin, TX</city>"));
	}

}
