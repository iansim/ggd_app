package com.example.ggd.controller;

import com.example.ggd.model.FamilyMember;
import com.example.ggd.model.Household;
import com.example.ggd.repository.HouseholdRepository;
import com.example.ggd.service.HouseHoldService;
import com.example.ggd.viewmodel.HouseholdVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class HouseholdController {

    @Autowired
    HouseHoldService houseHoldService;

    /**
     * Find all household
     * @return
     */
    @GetMapping("/household")
    public List<HouseholdVO> getAllNotes() {
        return houseHoldService.findAll();
    }

    /*
     * create househould
     */
    @PostMapping("/household")
    public HouseholdVO createHousehold(@Valid @RequestBody Household household) {
        return houseHoldService.save(household);
    }
    
    /**
     * Add member to household
     * @param householdId
     * @param member
     * @return
     */
    @PostMapping("/household/{householdId}")
    public HouseholdVO createFamilyMember(@PathVariable("householdId") Long householdId,@Valid @RequestBody FamilyMember member) {
    	return houseHoldService.saveMember(householdId, member);
    }
    /**
     * Get household detail
     * @param householdId
     * @return
     */
    @GetMapping("/household/{householdId}")
    public HouseholdVO findHousehold(@PathVariable("householdId") Long householdId) {
    	return houseHoldService.saveHousehold(householdId);
    }
    
    /*
     * find Household for Student Encouragement Bonus
     */
    @GetMapping("/household/seb")
    public List<HouseholdVO> findHouseholdForSEB() {
    	return houseHoldService.findForSEB();
    }
    /*
     * find Household for Family Togetherness Scheme
     */
    @GetMapping("/household/fts")
    public List<HouseholdVO> findHouseholdForFTS() {
    	return houseHoldService.findForFTS();
    }
    /*
     * find Household for Elder Bonus
     */
    @GetMapping("/household/eb")
    public List<HouseholdVO> findHouseholdForEB() {
    	return houseHoldService.findForEB();
    }
    /*
     * find Baby Sunshine Grant
     */
    @GetMapping("/household/bsg")
    public List<HouseholdVO> findHouseholdForBSG() {
    	return houseHoldService.findForBSG();
    }
    /*
     * find YOLO GST Grant
     */
    @GetMapping("/household/yolo")
    public List<HouseholdVO> findHouseholdForYolo() {
    	return houseHoldService.findForYolo();
    }
    
    @DeleteMapping("/household/{householdId}")
    public HouseholdVO deleteHousehold(@PathVariable("householdId") Long householdId) {
    	return houseHoldService.deleteHousehold(householdId);
    }
    
    @DeleteMapping("/household/{householdId}/{memberId}")
    public HouseholdVO removeMember(@PathVariable("householdId") Long householdId,
    		@PathVariable("memberId") Long memberId) {
    	return houseHoldService.removeMember(householdId,memberId);
    }
}
