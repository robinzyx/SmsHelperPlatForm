package junit.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.service.holiday.HolidayService;

public class HolidayTest {
	private static HolidayService holidayService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ClassPathXmlApplicationContext act= new ClassPathXmlApplicationContext("beans.xml");
			holidayService= (HolidayService) act.getBean("holidayServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

@Test
public void delete(){
	holidayService.delete(1);
}

}
