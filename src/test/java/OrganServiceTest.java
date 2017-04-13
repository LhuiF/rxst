import com.unionx.core.util.Identities;
import com.unionx.sys.organ.service.OrganService;
import com.unionx.sys.organ.vo.Organ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class OrganServiceTest {
    @Resource
    private OrganService organService;
   /* @Test
    public void findOrganByName() throws Exception {
//        List<Organ> organList = this.organService.findOrganByName("服务课");
//        System.out.println(organList.size());

    }*/
//    @Test
    public void save() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        Organ organ = new Organ();
//        organ.setId(Identities.uuid());
//        organ.setName("张三服务课11");
//        organ.setCode("ZYFWK11");
//        organ.setRemark("备注");
//        organ.setParentId("7a4f79728f1f45d0b611aeaf951ef291");
//        this.organService.saveOrgan(organ);
//
//        organ.setId(Identities.uuid());
//        organ.setName("李梦然服务课");
//        organ.setCode("LMRFWK");
//        organ.setRemark("备注");
//        organ.setParentId("ed0297d72e71435d94637942bcd15a9d");
//        this.organService.saveOrgan(organ);
    }


}
