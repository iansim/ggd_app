package com.example.ggd.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.example.ggd.model.FamilyMember;
import com.example.ggd.model.Household;

public class HouseholdVO {
	public HouseholdVO(Household hd) {
		if(hd==null)return;
		this.type = hd.getType();
		List<FamilyMember> mems = hd.getMembers();
		if(mems!=null) {
			this.members = new ArrayList<>();
			for(FamilyMember mem:mems) {
				this.members.add(new FamilyMemberVO(mem));
			}
		}
	}

	private String type;

	private List<FamilyMemberVO> members;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FamilyMemberVO> getMembers() {
		return members;
	}

	public void setMembers(List<FamilyMemberVO> members) {
		this.members = members;
	}


}
