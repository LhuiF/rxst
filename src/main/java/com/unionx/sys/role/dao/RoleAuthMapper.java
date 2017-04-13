package com.unionx.sys.role.dao;

import java.util.List;

import com.unionx.sys.module.vo.Module;
import org.springframework.stereotype.Repository;
import com.unionx.sys.role.vo.RoleAuth;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author
 */
@Repository
public interface RoleAuthMapper {
    /**
     * 根据主键查询
     */
    RoleAuth getRoleAuthById(@Param("moduleCode") String moduleCode, @Param("roleId") String roleId);

    /**
     * 查询出所有记录
     */
    List<RoleAuth> findAllRoleAuth();

    /**
     * 保存
     */
    int saveRoleAuth(RoleAuth roleAuth);

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateRoleAuth(RoleAuth roleAuth);

    /**
     * 根据主键删除
     */
    int deleteRoleAuth(@Param("moduleCode") String moduleCode
            , @Param("roleId") String roleId);

    int deleteByRoleId(@Param("roleId") String roleId);
}

