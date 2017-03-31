package com.toandc.workshop.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by toandc on 3/31/17.
 */
@Entity
@NamedQuery(name = "user.findByFullName", query = "SELECT u FROM User u WHERE LOWER(u.fullName) = LOWER(?1)")
@Table(name = "User")
public class User {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "FullName", nullable = true)
    private String fullName;

    @Column(name = "Address", nullable = true)
    private String address;

    @Column(name = "Phone", nullable = true)
    private String phone;

    @Column(name = "Note", nullable = true)
    private String note;

    @Column(name = "ModifyDate", nullable = false)
    private Date modifyDate;

    @Column(name = "CreateDateUser", nullable = false)
    private Date createDateUser;

    public User() {
    }

    public User(String fullName, String address, String phone, String note) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.note = note;
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

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, fullName='%s', lastName='%s']",
                userId, fullName, address);
    }

}
