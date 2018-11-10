package com.hzed.qmqb.admin.persistence.auto.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号账号
     */
    private String mobileAccount;

    /**
     * 密码（加密保存）
     */
    private String password;

    /**
     * 用户头像
     */
    private String profilePhoto;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别 0-未知 1-男 2-女 3-女改男 4-男改女 5-其他
     */
    private Byte gender;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 宗教
     */
    private String religion;

    /**
     * 注册平台 android、ios、H5等等
     */
    private String platform;

    /**
     * 注册渠道 Rupiah Get-app注册
     */
    private String client;

    /**
     * 设备唯一标识
     */
    private String imei;

    /**
     */
    private Long createBy;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     */
    private Long updateBy;

    /**
     */
    private LocalDateTime updateTime;

    /**
     */
    private String remark;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 身份
     */
    private String identityType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileAccount() {
        return mobileAccount;
    }

    public void setMobileAccount(String mobileAccount) {
        this.mobileAccount = mobileAccount == null ? null : mobileAccount.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion == null ? null : religion.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobileAccount=").append(mobileAccount);
        sb.append(", password=").append(password);
        sb.append(", profilePhoto=").append(profilePhoto);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", realName=").append(realName);
        sb.append(", idCardNo=").append(idCardNo);
        sb.append(", religion=").append(religion);
        sb.append(", platform=").append(platform);
        sb.append(", client=").append(client);
        sb.append(", imei=").append(imei);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", birthday=").append(birthday);
        sb.append(", identityType=").append(identityType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static User.Builder builder() {
        return new User.Builder();
    }

    public static class Builder {
        private User obj;

        public Builder() {
            this.obj = new User();
        }

        public Builder id(Long id) {
            obj.setId(id);
            return this;
        }

        public Builder mobileAccount(String mobileAccount) {
            obj.setMobileAccount(mobileAccount);
            return this;
        }

        public Builder password(String password) {
            obj.setPassword(password);
            return this;
        }

        public Builder profilePhoto(String profilePhoto) {
            obj.setProfilePhoto(profilePhoto);
            return this;
        }

        public Builder nickName(String nickName) {
            obj.setNickName(nickName);
            return this;
        }

        public Builder gender(Byte gender) {
            obj.setGender(gender);
            return this;
        }

        public Builder realName(String realName) {
            obj.setRealName(realName);
            return this;
        }

        public Builder idCardNo(String idCardNo) {
            obj.setIdCardNo(idCardNo);
            return this;
        }

        public Builder religion(String religion) {
            obj.setReligion(religion);
            return this;
        }

        public Builder platform(String platform) {
            obj.setPlatform(platform);
            return this;
        }

        public Builder client(String client) {
            obj.setClient(client);
            return this;
        }

        public Builder imei(String imei) {
            obj.setImei(imei);
            return this;
        }

        public Builder createBy(Long createBy) {
            obj.setCreateBy(createBy);
            return this;
        }

        public Builder createTime(LocalDateTime createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        public Builder updateBy(Long updateBy) {
            obj.setUpdateBy(updateBy);
            return this;
        }

        public Builder updateTime(LocalDateTime updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        public Builder remark(String remark) {
            obj.setRemark(remark);
            return this;
        }

        public Builder birthday(String birthday) {
            obj.setBirthday(birthday);
            return this;
        }

        public Builder identityType(String identityType) {
            obj.setIdentityType(identityType);
            return this;
        }

        public User build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id"),
        mobileAccount("mobile_account"),
        password("password"),
        profilePhoto("profile_photo"),
        nickName("nick_name"),
        gender("gender"),
        realName("real_name"),
        idCardNo("id_card_no"),
        religion("religion"),
        platform("platform"),
        client("client"),
        imei("imei"),
        createBy("create_by"),
        createTime("create_time"),
        updateBy("update_by"),
        updateTime("update_time"),
        remark("remark"),
        birthday("birthday"),
        identityType("identity_type");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}