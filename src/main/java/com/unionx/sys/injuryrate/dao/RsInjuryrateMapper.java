package com.unionx.sys.injuryrate.dao;

import com.unionx.sys.injuryrate.vo.RsInjuryrate;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsInjuryrateMapper {
	
	 /**
     * 根据主键查询
     */
	RsInjuryrate getInjuryrateById(@Param("id")int id); 

    /**
     * 查询出所有记录
     */
    List<RsInjuryrate> findAllInjuryrate(); 
    /**
     * 按条件查询
     */
    List<RsInjuryrate> getInjuryrateList(RsInjuryrate rsInjuryrate);  
    /**
     * 保存
     */
   int saveInjuryrate(RsInjuryrate rsInjuryrate);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
   int updateInjuryrate(RsInjuryrate rsInjuryrate);
    
    /**
     * 根据主键删除
     */
   void deleteInjuryrate(@Param("id")int id);

  
}