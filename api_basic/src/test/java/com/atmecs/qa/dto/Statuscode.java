package com.atmecs.qa.dto;

public enum Statuscode {
	
	ok(200);

	private int sucesscode;

	Statuscode(int sucesscode) {
		this.sucesscode=sucesscode;
	}
	public int getCode() {
		return sucesscode;
	}

}
