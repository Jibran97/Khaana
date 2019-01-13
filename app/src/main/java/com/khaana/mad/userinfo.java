package com.khaana.mad;

public class userinfo {

    private String fname;
    private String sname;
    private String user;
    private String email;
    private String pass;

    public userinfo() {
    }

    public userinfo(String fname, String sname, String user, String email, String pass) {
        this.fname = fname;
        this.sname = sname;
        this.user = user;
        this.email = email;
        this.pass = pass;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
