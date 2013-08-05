package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ginwavelz.sms.bean.user.ContactInfo;
import com.ginwavelz.sms.bean.user.User;
import com.ginwavelz.sms.service.user.UserService;

public class UserTest {
	private static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			ClassPathXmlApplicationContext act= new ClassPathXmlApplicationContext("beans.xml");
			userService= (UserService) act.getBean("userServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void exit() {
		System.out.print(userService.exsit("robin"));
		
	}

	@Test
	public void save() {
////		new ClassPathXmlApplicationContext("beans.xml");
//		User user=new User();
//		user.setUsername("robin");
//		user.setPassword("robin");
//		user.setRealname("zhu");
//		user.setEmail("robinzyx@gmail.com");
//		user.setGender(Gender.MAN);
//		user.setContactInfo(ContactInfo)
//		userService.save(user);
		
		User user = new User("robin@gmail.com","123456","test@sina.com");
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setAddress("�����г��������ׯ");
		contactInfo.setMobile("13671323507");
		contactInfo.setPhone("010-64469090-9");
		contactInfo.setPostalcode("100028");
		user.setContactInfo(contactInfo);
		user.setRealname("����");
		userService.save(user);
		
	}
	@Test
	public void delete(){
		userService.delete("robin");
	}
	

}
