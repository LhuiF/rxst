
import com.unionx.sys.injuryrate.service.RsInjuryrateService;
import com.unionx.sys.injuryrate.vo.RsInjuryrate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class injury{
	  @Resource
	    private RsInjuryrateService rsInjuryrateService;
	@Test
	public void findAll(){
		List<RsInjuryrate> allInjuryrates = rsInjuryrateService.findAllInjuryrates();
		for (RsInjuryrate rsInjuryrate : allInjuryrates) {
			System.out.println(rsInjuryrate.getCompany()+"********"+rsInjuryrate.getYear());
		}
	}
	@Test
	public void saveInjury(){
		RsInjuryrate rInjuryrate=new RsInjuryrate();
		rInjuryrate.setCompany("dfsf");
		rInjuryrate.setStartTime(new Date());
		rInjuryrate.setEndTime(new Date());
		rInjuryrate.setYear("2014");
		rsInjuryrateService.saveInjuryrate(rInjuryrate);
		
	}
	@Test
	public void delInjury(){
		RsInjuryrate injuryrate = rsInjuryrateService.getInjuryrateById(2);
		System.out.println(injuryrate);
		injuryrate.setCompany("sdfsf");
		injuryrate.setRate(0.05);
		rsInjuryrateService.updateInjuryrate(injuryrate);
		
	}
}
