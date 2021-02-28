package com.example.ggd.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ggd.model.Household;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Long> {
	
	
    @Query("SELECT p FROM Household p JOIN FETCH p.members WHERE p.id = (:id) and p.status='A' ")
    public Household findByIdAndFetchMember(@Param("id")Long id);
    
    @Query("SELECT p FROM Household p JOIN FETCH p.members  where p.status='A' ")
    public List<Household> findAllAndFetchMember();
    
    
    @Query(value = "select * from household h join (" + 
    		"select household_id,sum(annual_income) income from family_member " + 
    		"where household_id in (select household_id from family_member where dob >= (:dob)  and status='A')" + 
    		"having  sum(annual_income) <= (:income) " + 
    		") x on h.id = x.household_id where  h.status='A'", nativeQuery = true)
    public List<Household> findForSEB(@Param("dob") Date dob,@Param("income") BigDecimal income);

    
    
    @Query(value = "select * from household h " + 
    		"where  h.status='A' and "
    		+ "exists (select household_id from family_member where   household_id = h.id and dob >= (:dob)  and status='A')  " + 
    		"and  exists (select household_id from family_member where   household_id = h.id and gender = 'Male' and marital_Status = 'Y'  and status='A') " +
    		"and  exists (select household_id from family_member where   household_id = h.id and gender = 'Female' and marital_Status = 'Y'  and status='A')",
    		nativeQuery = true)
    public List<Household> findForFTS(@Param("dob") Date dob);
    
    
    @Query(value = "select * from household h " + 
    		"where  h.status='A' and exists (select household_id from family_member where   household_id = h.id and dob <= (:dob) ) and status='A'",
    		nativeQuery = true)
    public List<Household> findForEB(@Param("dob") Date dob);
    
    @Query(value = "select * from household h " + 
    		"where  h.status='A' and exists (select household_id from family_member where   household_id = h.id and dob >= (:dob) ) and status='A'",
    		nativeQuery = true)
    public List<Household> findForBSG(@Param("dob") Date dob);
    
    
    @Query(value = "select * from household h join (" + 
    		"select household_id,sum(annual_income) income from family_member " + 
    		"having  sum(annual_income) <= (:income) " + 
    		") x on h.id = x.household_id where  h.status='A'", nativeQuery = true)
    public List<Household> findForYolo(@Param("income") BigDecimal income);


}
