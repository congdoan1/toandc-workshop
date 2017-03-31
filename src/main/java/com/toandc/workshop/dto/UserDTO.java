package com.toandc.workshop.dto;

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

    private Date modifyDate;

    private Date createDateUser;

    public UserDTO(int userId, String fullName, String address, String phone, String note, Date modifyDate, Date createDateUser) {
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.modifyDate = modifyDate;
        this.createDateUser = createDateUser;
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

    public Date getCreateDateUser() {
        return createDateUser;
    }

    public void setCreateDateUser(Date createDateUser) {
        this.createDateUser = createDateUser;
    }
}
