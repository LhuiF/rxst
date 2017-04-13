package com.unionx.core.util;

import com.sun.media.sound.SoftTuning;
import com.unionx.sys.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.data.mongodb.core.query.Update;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author jayson
 */
@Slf4j
public class BeanToUpdate {

    /**
     * 将给定的Bean对象转成操作mongodb的Update对象.当bean的属性是null的时候，不转换
     * @param bean 可以是普通的Bean 也可以是 Map
     * @return
     */
    public static Update convert(Object bean) {
        PropertyUtilsBean propertyUtils = BeanUtilsBean.getInstance().getPropertyUtils();
        Update update = new Update();
        if (bean instanceof Map) {
            Iterator entries = ((Map) bean).entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String name = (String)entry.getKey();
                if (entry.getValue() != null) {
                    update.set(name, entry.getValue());
                }
            }
        } else /* if (orig is a standard JavaBean) */ {
            PropertyDescriptor[] origDescriptors = propertyUtils.getPropertyDescriptors(bean);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                if (propertyUtils.isReadable(bean, name)) {
                    try {
                        Object value = propertyUtils.getSimpleProperty(bean, name);
                        if (value != null) {
                            update.set(name, value);
                        }
                    } catch (NoSuchMethodException e) {
                        // Should not happen
                    } catch (InvocationTargetException e) {
                        log.error("",e);
                    } catch (IllegalAccessException e) {
                        log.error("",e);
                    }
                }
            }
        }
        return update;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setCity("aaaa");
        user.setRoleIdList(Arrays.asList("1","2"));
        Update update = BeanToUpdate.convert(user);
        System.out.println(update.toString());
        System.out.println("-------------------------");
        Map map = new HashMap();
        map.put("name", "aaaa");
        map.put("sex", "nan");
        map.put("lsit", Arrays.asList("1", "2"));
        System.out.println(BeanToUpdate.convert(map).toString());

    }

}
