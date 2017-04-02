package com.toandc.workshop.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by toandc on 3/31/17.
 */
@Entity
@NamedQuery(name = "User.findByFullName", query = "SELECT u FROM User u WHERE LOWER(u.fullName) LIKE LOWER(?1)")
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "full_name")
    @NotNull
    private String fullName;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "note")
    @NotNull
    private String note;

    @Column(name = "modify_date", nullable = false)
    private Date modifyDate;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    public User() {
    }

    public User(String fullName, String address, String phone, String note, Date modifyDate, Date createDate) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.modifyDate = modifyDate;
        this.createDate = createDate;
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

    @PreUpdate
    public void preUpdate() {
        modifyDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        createDate = now;
        modifyDate = now;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, fullName='%s', lastName='%s']",
                userId, fullName, address);
    }

}
