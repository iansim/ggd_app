package com.example.ggd.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ggd.model.FamilyMember;
import com.example.ggd.model.Household;
import com.example.ggd.repository.FamilyMemberRepository;
import com.example.ggd.repository.HouseholdRepository;
import com.example.ggd.viewmodel.HouseholdVO;

@Service
public class HouseHoldService {
	public static final String DELETE = "D";

	@Autowired
	HouseholdRepository householdRepository;

	@Autowired
	FamilyMemberRepository familyMemberRepository;

	public HouseholdVO saveMember(Long householdId, FamilyMember member) {
		Optional<Household> houseHold = householdRepository.findById(householdId);
		if (houseHold.isPresent()) {
			member.setHousehold(houseHold.get());
			familyMemberRepository.save(member);
			Household hd = householdRepository.findByIdAndFetchMember(householdId);
			return new HouseholdVO(hd);
		} else {
			return null;
		}

	}

	public HouseholdVO save(Household household) {
		return new HouseholdVO(householdRepository.save(household));
	}

	public List<HouseholdVO> findAll() {
		List<Household> hds = householdRepository.findAllAndFetchMember();
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	public HouseholdVO saveHousehold(Long householdId) {
		return new HouseholdVO(householdRepository.findByIdAndFetchMember(householdId));
	}

	/**
	 * Find for Student Encouragement Bonus
	 * 
	 * @return HouseholdVO
	 */
	public List<HouseholdVO> findForSEB() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -16);
		List<Household> hds = householdRepository.findForSEB(c.getTime(), new BigDecimal(150000));
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	/**
	 * Find for Family Togetherness Scheme
	 * 
	 * @return HouseholdVO
	 */
	public List<HouseholdVO> findForFTS() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -18);
		List<Household> hds = householdRepository.findForFTS(c.getTime());
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	/**
	 * Find for Elder Bonus
	 * 
	 * @return HouseholdVO
	 */
	public List<HouseholdVO> findForEB() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -50);
		List<Household> hds = householdRepository.findForEB(c.getTime());
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	/**
	 * Find for Elder Bonus
	 * 
	 * @return HouseholdVO
	 */
	public List<HouseholdVO> findForBSG() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -5);
		List<Household> hds = householdRepository.findForBSG(c.getTime());
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	/**
	 * Find for YOLO GST Grant
	 * 
	 * @return HouseholdVO
	 */
	public List<HouseholdVO> findForYolo() {
		List<Household> hds = householdRepository.findForYolo(new BigDecimal(100000));
		List<HouseholdVO> hdvs = new ArrayList<>();
		hds.stream().forEach(obj -> hdvs.add(new HouseholdVO(obj)));
		return hdvs;
	}

	public HouseholdVO deleteHousehold(Long householdId) {
		Household hd = householdRepository.findByIdAndFetchMember(householdId);
		if (hd != null) {
			hd.setStatus(DELETE);
			householdRepository.save(hd);
			List<FamilyMember> mems = hd.getMembers();
			for (FamilyMember mem : mems) {
				mem.setStatus(DELETE);
				familyMemberRepository.save(mem);
			}
			return new HouseholdVO(hd);
		} else {
			return null;
		}
	}

	public HouseholdVO removeMember(Long householdId, Long memberId) {
		Household hd = householdRepository.findByIdAndFetchMember(householdId);
		if (hd != null) {
			List<FamilyMember> mems = hd.getMembers();
			for (FamilyMember mem : mems) {
				if (mem.getId().equals(memberId)) {
					mem.setHousehold(null);
					familyMemberRepository.save(mem);
				}
			}
			return new HouseholdVO(hd);
		} else {
			return null;
		}
	}
}
