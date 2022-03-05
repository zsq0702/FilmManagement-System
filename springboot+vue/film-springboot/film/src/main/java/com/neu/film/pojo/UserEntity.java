package com.neu.film.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "", catalog = "film")
public class UserEntity {
    private int uId;
    private String uName;
    private String uPwd;
    private Date uBirth;
    private String uMobile;
    private String uImg;
    private String uSex;
    private Integer uScore;
    private Integer uRole;
    private Double uBalance;
    private Integer uState;

    @Id
    @Column(name = "U_ID")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "U_NAME")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "U_PWD")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "U_BIRTH")
    public Date getuBirth() {
        return uBirth;
    }

    public void setuBirth(Date uBirth) {
        this.uBirth = uBirth;
    }

    @Basic
    @Column(name = "U_MOBILE")
    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile;
    }

    @Basic
    @Column(name = "U_IMG")
    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    @Basic
    @Column(name = "U_SEX")
    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uId == that.uId &&
                Objects.equals(uName, that.uName) &&
                Objects.equals(uPwd, that.uPwd) &&
                Objects.equals(uBirth, that.uBirth) &&
                Objects.equals(uMobile, that.uMobile) &&
                Objects.equals(uImg, that.uImg) &&
                Objects.equals(uSex, that.uSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uName, uPwd, uBirth, uMobile, uImg, uSex);
    }

    @Basic
    @Column(name = "U_SCORE")
    public Integer getuScore() {
        return uScore;
    }

    public void setuScore(Integer uScore) {
        this.uScore = uScore;
    }

    @Basic
    @Column(name = "U_ROLE")
    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    @Basic
    @Column(name = "U_BALANCE")
    public Double getuBalance() {
        return uBalance;
    }

    public void setuBalance(Double uBalance) {
        this.uBalance = uBalance;
    }

    @Basic
    @Column(name = "U_STATE")
    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }
}
