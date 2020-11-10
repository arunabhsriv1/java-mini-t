package com.cybage.pojos;

public class Plans {

	private int planId;
	private int sportId ; 
	private String planName;
	private double fees;
	private int duration;
	public Plans() {
		super();
	}
	public Plans(int planId, int sportId, String planName, double fees, int duration) {
		super();
		this.planId = planId;
		this.sportId = sportId;
		this.planName = planName;
		this.fees = fees;
		this.duration = duration;
	}
	
	
	
	public Plans(int sportId, String planName, double fees, int duration) {
		super();
		this.sportId = sportId;
		this.planName = planName;
		this.fees = fees;
		this.duration = duration;
	}
	public int getPlanId() {
		return planId;
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
	
	@Override
	public String toString() {
		return "Plans [planId=" + planId + ", sportId=" + sportId + ", planName=" + planName + ", fees=" + fees
				+ ", duration=" + duration + "]";
	}
	
	
	
}
