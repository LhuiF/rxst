package com.unionx.web.archive.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RsConditionArchive implements Serializable {
    private Integer id;

    private String produtUuid;

    private String produtName;

    private List<RsCondition> conditions;

    private String isOnlineApply;

    private String isdel;

    private String remark;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;
    
    private String situation;

    private static final long serialVersionUID = 1L;

    public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdutUuid() {
        return produtUuid;
    }

    public void setProdutUuid(String produtUuid) {
        this.produtUuid = produtUuid;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public List<RsCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<RsCondition> conditions) {
		this.conditions = conditions;
	}

	public String getIsOnlineApply() {
        return isOnlineApply;
    }

    public void setIsOnlineApply(String isOnlineApply) {
        this.isOnlineApply = isOnlineApply;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RsConditionArchive other = (RsConditionArchive) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProdutUuid() == null ? other.getProdutUuid() == null : this.getProdutUuid().equals(other.getProdutUuid()))
            && (this.getProdutName() == null ? other.getProdutName() == null : this.getProdutName().equals(other.getProdutName()))
            && (this.getConditions() == null ? other.getConditions() == null : this.getConditions().equals(other.getConditions()))
            && (this.getIsOnlineApply() == null ? other.getIsOnlineApply() == null : this.getIsOnlineApply().equals(other.getIsOnlineApply()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProdutUuid() == null) ? 0 : getProdutUuid().hashCode());
        result = prime * result + ((getProdutName() == null) ? 0 : getProdutName().hashCode());
        result = prime * result + ((getConditions() == null) ? 0 : getConditions().hashCode());
        result = prime * result + ((getIsOnlineApply() == null) ? 0 : getIsOnlineApply().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}