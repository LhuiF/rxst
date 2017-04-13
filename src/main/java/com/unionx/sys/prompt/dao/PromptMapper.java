package com.unionx.sys.prompt.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.unionx.sys.prompt.vo.Prompt;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 * @author 
 */
 @Repository
public interface PromptMapper{   
    /**
     * 根据主键查询
     */
    Prompt getPromptById(@Param("id")String id); 

    /**
     * 查询出所有记录
     */
    List<Prompt> findAllPrompt();    
    
    /**
     * 保存
     */
    int savePrompt(Prompt prompt);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updatePrompt(Prompt prompt);
    
    /**
     * 根据主键删除
     */
    int deletePrompt(@Param("id")String id);

    List<Prompt> findPromptByCondition(Prompt prompt);

    int updateContentAndName(Prompt prompt);

    List<Prompt> findPromptByConditionNoLike(Prompt prompt);
}

