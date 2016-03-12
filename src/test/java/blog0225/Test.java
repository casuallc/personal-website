package blog0225;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.qing.welcome.WelAction;

import junit.framework.TestCase;

public class Test extends TestCase {

	public void testGson() {
		Gson gson = new Gson();
		String s = gson.toJson("23");
		System.out.println(s);
	}
	
	public void testFinally() {
		System.out.println(getName());
	}
	
	public String getName() {
		String s = "33";
		try {
			
			return s;
		} catch (Exception e) {
			// TODO: handle exception
			return "7";
		} finally {
			s = "444";
		}
	}
	
	@SuppressWarnings("resource")
	public void testSpring() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		WelAction action = ctx.getBean(WelAction.class);
		System.out.println(action);
	}
}
