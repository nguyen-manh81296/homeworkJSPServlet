package com.example.homework.entity;

import com.example.homework.util.DateTimeHelper;

import java.time.LocalDateTime;

public class Customer {

    private String id;
    private String name;
    private String image;
    private String phone;
    private LocalDateTime dob;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private int status;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", status=" + status +
                '}';
    }


    public Customer(String id, String name, String image, String phone, LocalDateTime dob) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.dob = dob;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer() {
        this.id = "";
        this.name = "";
        this.image = "";
        this.phone = "";
    }

    public Customer(String id, String name, String image, String phone, LocalDateTime dob, LocalDateTime createAt, LocalDateTime updateAt, int status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.dob = dob;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}




