package com.atmecs.qa.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Activities {
	
	private int id;
	private String title;
	private String dueDate;
	private boolean completed;
	
}
