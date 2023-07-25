package com.atmecs.qa.dto;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ActivitiesDTO {

	
	
	public static String payloadActives(int activityId,String titleName,String dateValue,boolean value) {
		
		String response = null;
		
		try {
			Activities build = Activities.builder().id(activityId).title(titleName).dueDate(dateValue).completed(value).build();
			ObjectMapper mapper = new ObjectMapper();
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(build);
		//	System.out.println(response);
			return response;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		ActivitiesDTO value=new ActivitiesDTO();
		
		value.payloadActives(12,"ARIVU","23/03/2023",true);
	}
}
