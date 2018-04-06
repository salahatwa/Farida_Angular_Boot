package com.igi.utils;

public enum BusinessStepType {
	Validation("0"), // 0
	Service("1"), // 1
	Transaction("2")// 2
	;

	private String businessStepTypeString;

	private BusinessStepType(String businessStepTypeString) {
		this.businessStepTypeString = businessStepTypeString;
	}

	public String getBusinessStepTypeString() {
		return businessStepTypeString;
	}

	public void setBusinessStepTypeString(String businessStepTypeString) {
		this.businessStepTypeString = businessStepTypeString;
	}
}
