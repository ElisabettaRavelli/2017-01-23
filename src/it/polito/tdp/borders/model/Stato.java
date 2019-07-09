package it.polito.tdp.borders.model;

public class Stato implements Comparable<Stato>{
	private String stateAbb ; 
	private String stateName ; 
	private Integer statiConfinanti;
	public Stato(String stateAbb, String stateName, Integer statiConfinanti) {
		super();
		this.stateAbb = stateAbb;
		this.stateName = stateName;
		this.statiConfinanti = statiConfinanti;
	}
	public String getStateAbb() {
		return stateAbb;
	}
	public String getStateName() {
		return stateName;
	}
	public Integer getStatiConfinanti() {
		return statiConfinanti;
	}
	@Override
	public int compareTo(Stato o) {
		return - (statiConfinanti.compareTo(o.statiConfinanti));
	}
	@Override
	public String toString() {
		return String.format("AtateAbb=%s, StateName=%s, StatiConfinanti=%s ", stateAbb, stateName,
				statiConfinanti);
	}
	
	

}
