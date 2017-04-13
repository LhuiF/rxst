package com.unionx.sys.prompt.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.Identities;
import com.unionx.sys.prompt.dao.PromptMapper;
import com.unionx.sys.prompt.vo.Prompt;
import com.unionx.sys.user.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.Date;
import java.util.List;

/**
 * @author rjm
 *
 */
@Service
public class PromptServiceImpl {
    @Autowired
    private PromptMapper promptMapper;

    /**
     * 列表查询，使用分页插件
     * @param prompt
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<Prompt> getAllPrompt(Prompt prompt, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Prompt> list =promptMapper.findPromptByCondition(prompt);
        return new PageInfo(list);
    }

    /**
     * 检验，"xz"是页面传递的flg
     * @return
     */
    public boolean validate(Prompt prompt,String flg){
        List<Prompt> sr = null;
        Boolean b = false;
        String id = "";
        if(prompt != null){
            id = prompt.getId();
        }
        if(!"xz".equals(flg)){
            sr =promptMapper.findPromptByConditionNoLike(prompt);
            if(null == sr || sr.size()<=0){
                b=true;
            }
            if(null != sr && sr.size() ==1){
               String idDB =sr.get(0).getId();
                if(id.equals(idDB)){
                    b=true;
                }
            }
        }else{
            //新增验证
            sr = promptMapper.findPromptByConditionNoLike(prompt);
            if(sr == null || sr.size()<=0){
                b = true;
            }
        }

        return b;
    }

    /**
     * 保存
     * @param prompt
     * @return
     */
    public int savePrompt(Prompt prompt) {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        prompt.setContent(prompt.getContent().trim());
        prompt.setId(Identities.uuid());
        prompt.setUpdateDatatime(new Date());
        prompt.setUpdateUserId(user.getId());
        int x =promptMapper.savePrompt(prompt);
        return x;
    }
    /**
     * 根据id取值
     * @param id
     * @return
     */
    public Prompt getPromptById(String id) {
        return promptMapper.getPromptById(id);
    }

    /**
     * 更新name/时间/人/content
     * @param prompt
     */
    public void updatePrompt(Prompt prompt) {
        prompt.setContent(prompt.getContent().trim());
        promptMapper.updateContentAndName(prompt);
    }
}
