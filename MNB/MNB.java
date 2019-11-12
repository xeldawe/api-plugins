package com.xel.mnb;

import java.sql.Timestamp;

public class MNB {

	int unit;
	String nat;
	Double value;
	Timestamp date;

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDateAsString() {
		String tmp =  date.toString();
		return tmp.substring(0, tmp.indexOf(" "));
	}
	
	@Override
	public String toString() {
		return "{\"unit\":" + unit + ", \"nat\":\"" + nat + "\", \"value\":" + value + ", \"date\":\"" + getDateAsString() + "\"}";
	}

}
