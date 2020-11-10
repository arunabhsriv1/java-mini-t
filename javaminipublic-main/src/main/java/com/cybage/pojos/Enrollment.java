package com.cybage.pojos;

import java.sql.Date;

public class Enrollment {
	
	private int enrollId;
	private int batchId;
	private Date startDate ;
	private Date endDate;
	private String mStatus;
	public Enrollment() {
		super();
	}
	public Enrollment(int enrollId, int batchId, Date startDate, Date endDate, String mStatus) {
		super();
		this.enrollId = enrollId;
		this.batchId = batchId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mStatus = mStatus;
	}
	public int getEnrollId() {
		return enrollId;
	}


	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	@Override
	public String toString() {
		return "Enrollment [enrollId=" + enrollId + ", batchId=" + batchId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", mStatus=" + mStatus + "]";
	}
	
	
	

}
