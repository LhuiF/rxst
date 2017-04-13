package com.unionx.sys.organ.dao;

import java.math.BigInteger;
import java.util.List;
import com.unionx.sys.organ.vo.Organ;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 组织机构
 * @author songjunjie
 */
@Repository
public interface OrganMapper{
    /**
     * 根据主键查询
     */
    Organ getOrganById(@Param("id") String id);

    /**
     * 查询出所有记录
     */
    List<Organ> findAllOrgan();

    /**
     * 根据条件模糊查询出机构
     * @param name
     * @param contactPerson
     * @param tel
     * @return
     */
    List<Organ> findOrganTree(@Param("name") String name,
                              @Param("contactPerson") String contactPerson,
                              @Param("tel") String tel);

    /**
     * 根据父节点id，找到其子节点中层级妈最大的
     * @param parentId 父节点id，如果为0表示在顶级节点中查找
     * @return
     */
    Long findChildrenMaxTierCode(String parentId);

    /**
     * 保存
     */
    int saveOrgan(Organ organ);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateOrgan(Organ organ);
    
    /**
     * 根据主键删除
     */
    int deleteOrgan(@Param("id") String id);


    /**
     * 根据机构名称查询机构对象
     * @param code 机构编码
     * @return
     */
    Organ findOrganByCode(String code);

    /**
     * 根据层级码查询机构列表
     * @param tierCode 层级码
     * @return
     */
    List<Organ> findOrganByTierCode(@Param("tierCode") String tierCode);
}

