package com.cybage.services;



import java.sql.Date;
import java.util.List;

import com.cybage.pojos.AllPlansInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;

public interface ManagerServiceI {
	
	public int addSport(String sportName) throws Exception; 
	public int removeSport(String sportName) throws Exception; 
	public int addBatch(Batch batch) throws Exception;
	public Date getDate(String date);
	public int removeBatch(int batchId)throws Exception;
	public int updateBatch(Batch batch,int batchId) throws Exception;
	
	public void getAllBatches()throws Exception;
	
	public List<AllPlansInfo> getAllPlans()throws Exception;
	public int addPlan(Plans plan)throws Exception;
	public int removePlan(int planId)throws Exception;
	public int updatePlan(Plans plan,int planId)throws Exception;
	
	
	/////UI testing methods//
	public void addSportUI();
	public void addBatchUI();	
	public void removeSportsUI();
	public void removeBatchUI();
	public void updateBatchUI();
	public void getAllBatchesUI();
	
	public void addPlanUI();
	public void removePlanUI();
	public void updatePlanUI();
	public void getAllPlansUI();

}



