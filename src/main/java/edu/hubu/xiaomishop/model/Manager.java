package edu.hubu.xiaomishop.model;

import java.io.Serializable;

/**
 * manager
 *
 * @author moonlan
 */
public class Manager implements Serializable {
    private String mgrId;

    private String mgrAccount;

    private String mgrPwd;

    private String mgrName;

    private String mgrImg;

    private String mgrTel;

    private static final long serialVersionUID = 1L;

    public String getMgrId() {
        return mgrId;
    }

    public void setMgrId(String mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrAccount() {
        return mgrAccount;
    }

    public void setMgrAccount(String mgrAccount) {
        this.mgrAccount = mgrAccount;
    }

    public String getMgrPwd() {
        return mgrPwd;
    }

    public void setMgrPwd(String mgrPwd) {
        this.mgrPwd = mgrPwd;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getMgrImg() {
        return mgrImg;
    }

    public void setMgrImg(String mgrImg) {
        this.mgrImg = mgrImg;
    }

    public String getMgrTel() {
        return mgrTel;
    }

    public void setMgrTel(String mgrTel) {
        this.mgrTel = mgrTel;
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
        Manager other = (Manager) that;
        return (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId())) && (this.getMgrAccount() == null ? other.getMgrAccount() == null : this.getMgrAccount().equals(other.getMgrAccount())) && (this.getMgrPwd() == null ? other.getMgrPwd() == null : this.getMgrPwd().equals(other.getMgrPwd())) && (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName())) && (this.getMgrImg() == null ? other.getMgrImg() == null : this.getMgrImg().equals(other.getMgrImg())) && (this.getMgrTel() == null ? other.getMgrTel() == null : this.getMgrTel().equals(other.getMgrTel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrAccount() == null) ? 0 : getMgrAccount().hashCode());
        result = prime * result + ((getMgrPwd() == null) ? 0 : getMgrPwd().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getMgrImg() == null) ? 0 : getMgrImg().hashCode());
        result = prime * result + ((getMgrTel() == null) ? 0 : getMgrTel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mgrId=").append(mgrId);
        sb.append(", mgrAccount=").append(mgrAccount);
        sb.append(", mgrPwd=").append(mgrPwd);
        sb.append(", mgrName=").append(mgrName);
        sb.append(", mgrImg=").append(mgrImg);
        sb.append(", mgrTel=").append(mgrTel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}