package com.unionx.base.material.vo1;

import java.io.Serializable;

public class SysCailiao implements Serializable {
    private String uuid;

    private Integer clnum;

    private String clname;

    private String clrqst;

    private String tjUuid;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getClnum() {
        return clnum;
    }

    public void setClnum(Integer clnum) {
        this.clnum = clnum;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getClrqst() {
        return clrqst;
    }

    public void setClrqst(String clrqst) {
        this.clrqst = clrqst;
    }

    public String getTjUuid() {
        return tjUuid;
    }

    public void setTjUuid(String tjUuid) {
        this.tjUuid = tjUuid;
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
        SysCailiao other = (SysCailiao) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getClnum() == null ? other.getClnum() == null : this.getClnum().equals(other.getClnum()))
            && (this.getClname() == null ? other.getClname() == null : this.getClname().equals(other.getClname()))
            && (this.getClrqst() == null ? other.getClrqst() == null : this.getClrqst().equals(other.getClrqst()))
            && (this.getTjUuid() == null ? other.getTjUuid() == null : this.getTjUuid().equals(other.getTjUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getClnum() == null) ? 0 : getClnum().hashCode());
        result = prime * result + ((getClname() == null) ? 0 : getClname().hashCode());
        result = prime * result + ((getClrqst() == null) ? 0 : getClrqst().hashCode());
        result = prime * result + ((getTjUuid() == null) ? 0 : getTjUuid().hashCode());
        return result;
    }
}