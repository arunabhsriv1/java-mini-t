package com.cybage.dao;

import java.util.List;

import com.cybage.pojos.AllPlansInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Plans;

public interface ManagerDaoI {
	public String getRole(String username) throws Exception;
	public void getAllBatches() throws Exception;
	public int addBatch(Batch batch) throws Exception;
	public int removeBatch(int batchId) throws Exception;
	public int updateBatch(Batch batch,int batchId) throws Exception;

	public List<AllPlansInfo> getAllPlans()throws Exception;
	public int addPlan(Plans plan)throws Exception;
	public int removePlan(int planId)throws Exception;
	public int updatePlan(Plans plan,int planId)throws Exception;
	
	public int addSports(String sportsName) throws Exception;
	public int removeSports(String sportsName)throws Exception;
	

}
