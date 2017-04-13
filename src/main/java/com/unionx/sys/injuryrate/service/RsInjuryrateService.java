package com.unionx.sys.injuryrate.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.sys.injuryrate.dao.RsInjuryrateMapper;
import com.unionx.sys.injuryrate.vo.RsInjuryrate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lhf
 *
 */
@Service
public class RsInjuryrateService {
    @Autowired
    private RsInjuryrateMapper rsInjuryrateMapper;
    
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public List<RsInjuryrate> findAllInjuryrates(){
    	return rsInjuryrateMapper.findAllInjuryrate();
    }
    /**
     * 列表查询，使用分页插件
     * @param rsInjuryrate
     * @param page
     * @param rows
     * @return
     */
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public PageInfo<RsInjuryrate> getAllInjuryrate(RsInjuryrate rsInjuryrate, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<RsInjuryrate> list = rsInjuryrateMapper.getInjuryrateList(rsInjuryrate); 
        return new PageInfo(list);
    }

    /**
     * 保存
     * @param prompt
     * @return
     */
    @Transactional
    public void saveInjuryrate(RsInjuryrate rsInjuryrate) {
//        User user = (User)SecurityUtils.getSubject().getPrincipal();
         rsInjuryrateMapper.saveInjuryrate(rsInjuryrate);
     
    }
    /**
     * 根据id取值
     * @param id
     * @return
     */
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public RsInjuryrate getInjuryrateById(int id) {
        return rsInjuryrateMapper.getInjuryrateById(id);
    }

    /**
     * 更新
     * @param prompt
     */
    @Transactional
    public void updateInjuryrate(RsInjuryrate rsInjuryrate) {
    	rsInjuryrateMapper.updateInjuryrate(rsInjuryrate);
    }
    /**
     * 冻结
     * @param prompt
     */
    @Transactional
    public void deleteInjuryrate(int id) {
    	rsInjuryrateMapper.deleteInjuryrate(id);
    }
    
}
