package com.toandc.workshop.dto;

/**
 * Created by toanqri on 4/1/17.
 */
public class UserInputDTO {

    private String fullName;

    private String address;

    private String phone;

    private String note;

    public UserInputDTO() {
    }

    public UserInputDTO(String fullName, String address, String phone, String note) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.note = note;
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

    @Override
    public String toString() {
        return String.format(
                "UserInputDTO[fullName='%s', address='%s', phone='%s', note='%s']",
                fullName, address, phone, note);
    }
}
