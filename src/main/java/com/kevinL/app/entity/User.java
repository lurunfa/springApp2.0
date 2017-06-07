package com.eyric.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
public class User {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String uname;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 生日
     */
    private Date birth;

    public User() {

    }

    public User(String uname, String pwd, Date birth) {
        this.uname = uname;
        this.pwd = pwd;
        this.birth = birth;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "birth")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
