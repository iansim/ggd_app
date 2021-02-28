package com.example.ggd.viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import com.example.ggd.model.FamilyMember;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FamilyMemberVO {
	public FamilyMemberVO(FamilyMember fm) {
		this.name = fm.getName();
		this.gender = fm.getGender();
		this.maritalStatus = fm.getMaritalStatus();
		this.spouseName = fm.getSpouseName();
		this.occupationType = fm.getOccupationType();
		this.annualIncome = fm.getAnnualIncome();
		this.dob = fm.getDob();
	}
    private String name;
    private String gender;
    private String maritalStatus;
    private String occupationType;
    private BigDecimal annualIncome;
    private String spouseName;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}
	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
    
}
