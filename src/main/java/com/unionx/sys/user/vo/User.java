package com.unionx.sys.user.vo;

import com.unionx.core.security.shiro.UserDetails;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 *
 * @xuchengbin
 */
@Data
public class User extends UserDetails{
    public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperCode() {
		return paperCode;
	}

	public void setPaperCode(String paperCode) {
		this.paperCode = paperCode;
	}

	public Integer getIsMarry() {
		return isMarry;
	}

	public void setIsMarry(Integer isMarry) {
		this.isMarry = isMarry;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getQq() {
		return qq;
	}

	public void setQq(Integer qq) {
		this.qq = qq;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
     *
     */
    private String id;
    /**
     *
     */
    private String loginName;
    /**
     * 机构id
     */
    private String organId;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String nickname;
    /**
     *
     */
    private String sex;
    /**
     *
     */
    private String birthday;
    /**
     *
     */
    private String position;
    /**
     *
     */
    private String post;
    private String postName;
    /**
     *
     */
    private String tel;
    /**
     *
     */
    private String email;
    /**
     * 是否领导 1 是 0否
     */
    private Integer leader;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 是否删除 1是 0否
     */
    private Integer deleted;
    /**
     * 最后修改时间
     */
    private Date updateDatatime;
    /**
     * 最后操作人id
     */
    private String updateUserId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 证件类型 数据字典
     */
    private String paperType;
    /**
     * 证件号码
     */
    private String paperCode;
    /**
     * 婚否  0：否 1：是
     */
    private Integer isMarry;
    /**
     * 民族  数据字典
     */
    private String nation;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 详细地址
     */
    private String address;
    /**
     * QQ号
     */
    private Integer qq;

    private String icon;

    private String password;

    private List<String> roleIdList;

     /**
     *
     */
    public String getId(){
        return this.id;
    }

    /**
     *
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     *
     */
    public String getLoginName(){
        return this.loginName;
    }

    /**
     *
     */
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }
    /**
     * 机构id
     */
    public String getOrganId(){
        return this.organId;
    }

    /**
     * 机构id
     */
    public void setOrganId(String organId){
        this.organId = organId;
    }
    /**
     *
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     *
     */
    public String getNickname(){
        return this.nickname;
    }

    /**
     *
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    /**
     *
     */
    public String getSex(){
        return this.sex;
    }

    /**
     *
     */
    public void setSex(String sex){
        this.sex = sex;
    }
    /**
     *
     */
    public String getBirthday(){
        return this.birthday;
    }

    /**
     *
     */
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    /**
     *
     */
    public String getPosition(){
        return this.position;
    }

    /**
     *
     */
    public void setPosition(String position){
        this.position = position;
    }
    /**
     *
     */
    public String getPost(){
        return this.post;
    }

    /**
     *
     */
    public void setPost(String post){
        this.post = post;
    }
    /**
     *
     */
    public String getTel(){
        return this.tel;
    }

    /**
     *
     */
    public void setTel(String tel){
        this.tel = tel;
    }
    /**
     *
     */
    public String getEmail(){
        return this.email;
    }

    /**
     *
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * 是否领导 1 是 0否
     */
    public Integer getLeader(){
        return this.leader;
    }

    /**
     * 是否领导 1 是 0否
     */
    public void setLeader(Integer leader){
        this.leader = leader;
    }
    /**
     * 备注
     */
    public String getRemark(){
        return this.remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark){
        this.remark = remark;
    }
    /**
     * 排序号
     */
    public Integer getOrderNo(){
        return this.orderNo;
    }

    /**
     * 排序号
     */
    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }
    /**
     * 是否删除 1是 0否
     */
    public Integer getDeleted(){
        return this.deleted;
    }

    /**
     * 是否删除 1是 0否
     */
    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }
    /**
     * 最后修改时间
     */
    public Date getUpdateDatatime(){
        return this.updateDatatime;
    }

    /**
     * 最后修改时间
     */
    public void setUpdateDatatime(Date updateDatatime){
        this.updateDatatime = updateDatatime;
    }
    /**
     * 最后操作人id
     */
    public String getUpdateUserId(){
        return this.updateUserId;
    }

    /**
     * 最后操作人id
     */
    public void setUpdateUserId(String updateUserId){
        this.updateUserId = updateUserId;
    }

    
	

    
}