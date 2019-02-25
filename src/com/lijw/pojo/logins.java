package com.lijw.pojo;

public class logins {
    private int id;
    private String username;
    private String userpass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public logins() {
    }

    public logins(int id, String username, String userpass) {
        this.id = id;
        this.username = username;
        this.userpass = userpass;
    }

    @Override
    public String toString() {
        return "logins{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                '}';
    }
}
