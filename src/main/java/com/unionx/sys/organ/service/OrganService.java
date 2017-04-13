package com.unionx.sys.organ.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.unionx.core.util.Identities;
import com.unionx.sys.organ.dao.OrganMapper;
import com.unionx.sys.organ.vo.Organ;
import com.unionx.sys.user.dao.UserMapper;
import com.unionx.sys.user.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 组织机构
 * @author songjunjie
 */
@Service
public class OrganService {
    @Resource
    private OrganMapper organMapper;
    @Resource
    private UserMapper userMapper;
    /**
     * 根据主键查询
     */
    public Organ getOrganById(String id) {
        return this.organMapper.getOrganById(id);
    }

    /**
     * 查询出所有记录
     */
    public List<Organ> findAllOrgan() {
        return this.organMapper.findAllOrgan();
    }

    /**
     * 根据条件模糊查询出机构列表
     * @author xuanYin
     * @date 2016/05/16
     * @param organ
     * @return
     */
    public List<Organ> findOrganTree(Organ organ){
        List<Organ> allOrgan=this.organMapper.findOrganTree(organ.getName(),organ.getContactPerson(),organ.getTel());
        return allOrgan;
    }

   /**
    * @Author xuanYin
    * @Param organ
    * @Date 2016/5/16 18:03
    * 保存组织机构数据
    */
   @Transactional
    public void saveOrgan(Organ organ) {
        String parentId = organ.getParentId();
        if (StringUtils.isBlank(parentId)){
            parentId="0";
            organ.setParentId(parentId);
        }
        organ.setId(Identities.uuid());
        organ.setTierCode(generateTierCode(organ.getParentId()));
        organ.setDeleted(0);
        organ.setUpdateDatatime(new Date());
        organ.setCreateDatatime(new Date());
        this.organMapper.saveOrgan(organ);
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    @Transactional
    public void updateOrgan(Organ organ) {
        this.organMapper.updateOrgan(organ);
    }

    /**
     * 根据主键删除
     */
    public void deleteOrgan(String id) {
        this.organMapper.deleteOrgan(id);
    }

    /**
     * @author xuanYin
     * @param parentId
     * @date 2016/05/16
     * @return
     */
    public String  generateTierCode(String parentId){
        String  tierCode="100";
        Long tierCodeMax = this.organMapper.findChildrenMaxTierCode(parentId);
        if (tierCodeMax == null) {
            Organ parentOrgan = this.organMapper.getOrganById(parentId);
            if (parentOrgan == null) {
                return tierCode;
            }else{
                tierCode=parentOrgan.getTierCode()+"001";
            }
        }else{
            tierCode=(tierCodeMax+1)+"";
        }
        return tierCode;
    }

    /**
     * 验证组织机构表单
     * @Author xuanYin
     * @Param organ
     * @Date 2016/5/17 9:37
     */
    public boolean validateOrgan(Organ organ){
        List<Organ> organList=this.organMapper.findAllOrgan();
        boolean flag=true;
        for (Organ organ1 : organList) {
            if(StringUtils.isNotBlank(organ.getId())){
                if (StringUtils.isNotBlank(organ.getName())){
                    if (organ.getName().equals(organ1.getName()) && !organ.getId().equals(organ1.getId())){
                        flag=false;
                        break;
                    }
                }
                if (StringUtils.isNotBlank(organ.getCode())){
                    if (organ.getCode().equals(organ1.getCode()) && !organ.getId().equals(organ1.getId())){
                        flag=false;
                        break;
                    }
                }
            }else{
                if (StringUtils.isNotBlank(organ.getName())){
                    if (organ.getName().equals(organ1.getName())){
                        flag=false;
                        break;
                    }
                }
                if (StringUtils.isNotBlank(organ.getCode())){
                    if (organ.getCode().equals(organ1.getCode())){
                        flag=false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 判断就当前机构下是否有子结构
     * @Author xuanYin
     * @Param id
     * @Date 2016/5/18 11:14
     */
    public boolean isHaveChildren(String id) {
        //获取所有菜单
        List<Organ> organList=this.organMapper.findAllOrgan();
        //for循环逻辑判断
        for (int i=0;i<organList.size();i++){
            if (StringUtils.isNotBlank(organList.get(i).getParentId()) && StringUtils.isNotBlank(id)){
                if (organList.get(i).getParentId().equals(id)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 查询当前机构下的用户
     * @Author xuanYin
     * @Param
     * @Date 2016/5/18 11:19
     */
    public List<User> findUserListByOrgan(String id){
        List<User> userList=this.userMapper.findUserListByOrgan(id);
        return userList;
    }

    /**
     * 验证所属机构
     * @Author xuanYin
     * @Param
     * @Date 2016/6/28 10:53
     */
    public boolean validateOrganTree(Organ organ) {
        boolean flag=true;
        if(StringUtils.isNotBlank(organ.getId())){
        if (StringUtils.isNotBlank(organ.getCode())){
            //根据机构名称查询机构对象
            Organ organById=this.organMapper.getOrganById(organ.getId());
            if(null!=organById){
                //根据机构层级码查询所有下属机构
                List<Organ> organList=this.organMapper.findOrganByTierCode(organById.getTierCode());
                if(CollectionUtils.isNotEmpty(organList)&& StringUtils.isNotBlank(organ.getName())){
                    for (Organ organ1 : organList) {
                        if(organ1.getName().equals(organ.getName())){
                            flag=false;
                            break;
                        }
                    }
                }else{
                    flag=false;
                }
            }else{
                flag=false;
            }
        }
        }
        return flag;
    }


}
