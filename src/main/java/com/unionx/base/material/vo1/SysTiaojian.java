package com.unionx.base.material.vo1;

import java.io.Serializable;

public class SysTiaojian implements Serializable {
    private String id;

    private String tjcontent;

    private String matlUuid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjcontent() {
        return tjcontent;
    }

    public void setTjcontent(String tjcontent) {
        this.tjcontent = tjcontent;
    }

    public String getMatlUuid() {
        return matlUuid;
    }

    public void setMatlUuid(String matlUuid) {
        this.matlUuid = matlUuid;
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
        SysTiaojian other = (SysTiaojian) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTjcontent() == null ? other.getTjcontent() == null : this.getTjcontent().equals(other.getTjcontent()))
            && (this.getMatlUuid() == null ? other.getMatlUuid() == null : this.getMatlUuid().equals(other.getMatlUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTjcontent() == null) ? 0 : getTjcontent().hashCode());
        result = prime * result + ((getMatlUuid() == null) ? 0 : getMatlUuid().hashCode());
        return result;
    }
}