package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.AllPlansInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class ManagerDaoImpl implements ManagerDaoI{
	

	public ManagerDaoImpl()
	{}



	@Override
	public String getRole(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//////////////////////Batch tables CRUD operations

	@Override
	public void getAllBatches() throws Exception {
		String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName from Batch b inner join Sports s on  s.sportId=b.sportId";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<Object>list=new ArrayList<Object>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			
			System.out.println(rs.getInt("batchId")+" "+rs.getDate("startDate")+" "+rs.getDate("endDate")+" "+rs.getInt("batchSize")+" "+rs.getString("sportName"));
			
			
		}
				
	}

	@Override
	public int addBatch(Batch batch) throws Exception {
		String sql = "insert into Batch(startDate,endDate ,batchSize,sportId) values(?,?,?,?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
			
		ps.setDate(1, batch.getStartDate());
		ps.setDate(2, batch.getEndDate());
		ps.setInt(3, batch.getBatchSize());
		ps.setInt(4, batch.getSportId());
		//ps.setInt(5, batch.getBatchId());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not insert batch record");
		}
	}

	//to delete a record from Batch table
	@Override
	public int removeBatch(int batchId) throws Exception {
		String sql = "delete from Batch where batchId= ?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
			
		
		ps.setInt(1, batchId);		
		
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not delete batch record");
		}
	}
	
	
	///update record in Batch table
	public int updateBatch(Batch batch,int batchId) throws Exception {
		String sql = "update Batch SET startDate=? ,endDate=?,batchSize=?  where batchId=? ";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, batch.getStartDate());
		ps.setDate(2,batch.getEndDate() );
		ps.setInt(3, batch.getBatchSize());
		
		ps.setInt(4,batchId);
		
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not update Batch tables record");
		}
	}
	
////////////////////Sports table CRUD operations
	

	@Override
	public int addSports(String sportName) throws Exception {
		String sql = "insert into Sports(sportName) values(?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setString(1, sportName);
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not insert Sports record");
		}
	}

	@Override
	public int removeSports(String sportName) throws Exception {
		String sql = "delete from Sports where sportName=?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		String sportName1=sportName.toUpperCase(); 
		ps.setString(1, sportName1);
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not delete Sports record");
		}
	}

	////Plan table CRUD
	
	
	@Override
	public int addPlan(Plans plan) throws Exception {
		
		String sql = "insert into plans(sportId,planName,fees,duration) values(?,?,?,?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, plan.getSportId());
			ps.setString(2, plan.getPlanName());
			ps.setDouble(3, plan.getFees());
			ps.setInt(4, plan.getDuration());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not insert batch record");
		}
	}
	
	@Override
	public int removePlan(int planId) throws Exception {
		
		String sql = "delete from plans where planId= ?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
			
		
		ps.setInt(1, planId);		
		
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not delete batch record");
		}
		
	}
	
	@Override
	public int updatePlan(Plans plan, int planId) throws Exception {
	
		String sql = "update Batch SET sportId=?,planName=?,fees=?,duration=?  where planId=? ";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, plan.getSportId());
		ps.setString(2, plan.getPlanName());
		ps.setDouble(3, plan.getFees());
		ps.setInt(4, plan.getDuration());
		
		ps.setInt(5,plan.getPlanId());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}
		
		else {
			
			throw new Exception("Could not update Batch tables record");
		}
		
	}
	
	@Override
	public List<AllPlansInfo> getAllPlans() throws Exception {
		String sql = "select p.planId,s.sportId,p.planName,p.fees,p.duration,s.sportName from plans p inner join Sports s on  s.sportId=p.sportId";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<AllPlansInfo>list=new ArrayList<AllPlansInfo>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			
			list.add(new AllPlansInfo(rs.getInt("planId"), rs.getInt("sportId"), rs.getString("planName"),rs.getDouble("fees"), rs.getInt("duration"), rs.getString("sportName")));
			//System.out.println(rs.getInt("batchId")+" "+rs.getDate("startDate")+" "+rs.getDate("endDate")+" "+rs.getInt("batchSize")+" "+rs.getString("sportName"));
				
		}
		return list;
	}

}
