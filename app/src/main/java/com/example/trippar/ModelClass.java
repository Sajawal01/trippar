package com.example.trippar;

public class ModelClass {

    private String img;
    private String header;
    private String desc;
    private String phone;


    ModelClass(){

    }

    public ModelClass(String img, String header, String desc, String phone) {
        this.img = img;
        this.header = header;
        this.desc = desc;
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
