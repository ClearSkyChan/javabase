package com.clearsky.javabase.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t7001_new")
public class Airport {
    @Id
    @Column(name="airport_4code")
    private String Ap4Code;
    @Column(name="airport_3code")
    private String Ap3Code;
    private String ChineseName;
    private String EnglishName;

    public String getAp4Code() {
        return Ap4Code;
    }

    public void setAp4Code(String ap4Code) {
        Ap4Code = ap4Code;
    }

    public String getAp3Code() {
        return Ap3Code;
    }

    public void setAp3Code(String ap3Code) {
        Ap3Code = ap3Code;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String chineseName) {
        ChineseName = chineseName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }
}
