package com.cybage.pojos;

public class AllPlansInfo {

	private int planId;
	private int sportId ; 
	private String planName;
	private double fees;
	private int duration;
	private String sportName;
	public AllPlansInfo(int planId, int sportId, String planName, double fees, int duration, String sportName) {
		super();
		this.planId = planId;
		this.sportId = sportId;
		this.planName = planName;
		this.fees = fees;
		this.duration = duration;
		this.sportName = sportName;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getSportId() {
		return sportId;
	}
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	@Override
	public String toString() {
		return "AllPlansInfo [planId=" + planId + ", sportId=" + sportId + ", planName=" + planName + ", fees=" + fees
				+ ", duration=" + duration + ", sportName=" + sportName + "]";
	}
	
	
}
