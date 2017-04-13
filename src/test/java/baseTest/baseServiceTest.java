package baseTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unionx.base.material.dao.SysCailiaoMapper;
import com.unionx.base.material.dao.SysMaterialMapper;
import com.unionx.base.material.dao.SysTiaojianMapper;
import com.unionx.base.material.vo.SysMaterial;
import com.unionx.core.util.Identities;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class baseServiceTest {

	@Autowired
	private SysMaterialMapper sysMaterialMapper;
	
	@Autowired
	private SysCailiaoMapper sysCailiaoMapper;
	
	@Autowired
	private SysTiaojianMapper sysTiaojianMapper;
	
//	@Before
	/*public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}*/

	@Test
	public void test() {
		 SysMaterial sysMaterial = new SysMaterial();
		 String maUuid = Identities.uuid19();
		 String a = sysMaterial.getConditon01();
		 	sysMaterial.setId(maUuid);
		 	sysMaterial.setUuid("RTHTRH");
		 	sysMaterial.setCondition01("gregg");
		 	sysMaterial.setCondition01("ghrth");
		 	//sysMaterialMapper.deleteByUuid("1771fe9e8a8648298e6652bf4b88b1cf");
		sysMaterialMapper.insertSelective(sysMaterial);
		
	}
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("12");
		list.add("34");
		String string = list.toString();
		String s = string.substring(string.indexOf("[") + 1,string.lastIndexOf("]"));
		 String json = JSONArray.fromObject(list).toString();
		System.out.println(string);
		System.out.println(json);
		System.out.println(s);
		sysCailiaoMapper.deleteByPrimaryKey("1");
		
	}

}
