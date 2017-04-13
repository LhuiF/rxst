package com.unionx.sys.injuryrate.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class RsInjuryrate implements Serializable {
    private Integer id;

    private String company;

    private String year;

    private Date startTime;

    private Date endTime;
    
    private String isdel;
    /*
     * 费率
     */
    private Double rate;

    private static final long serialVersionUID = 2L;

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
        RsInjuryrate other = (RsInjuryrate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        return result;
    }
}