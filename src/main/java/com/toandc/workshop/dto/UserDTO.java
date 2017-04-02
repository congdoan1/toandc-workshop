package com.toandc.workshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toandc.workshop.entity.User;
import com.toandc.workshop.util.Constants;

import java.util.Date;

/**
 * Created by toandc on 3/31/17.
 */
public class UserDTO {

    private int userId;

    private String fullName;

    private String address;

    private String phone;

    private String note;

    @JsonFormat(pattern = Constants.DATETIME_FORMAT_JSON, timezone = Constants.TIMEZONE_FORMAT_JSON)
    private Date modifyDate;

    @JsonFormat(pattern = Constants.DATETIME_FORMAT_JSON, timezone = Constants.TIMEZONE_FORMAT_JSON)
    private Date createDate;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.fullName = user.getFullName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.note = user.getNote();
        this.modifyDate = user.getModifyDate();
        this.createDate = user.getCreateDate();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return String.format(
                "UserDTO[userId=%d, fullName='%s', address='%s', phone='%s', note='%s', modifyDate='%s', createDate='%s']",
                userId, fullName, address, phone, note, modifyDate.toString(), createDate.toString());
    }
}
