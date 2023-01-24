package com.jspiders.springrest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springrest.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
	
	private String status;
	private String description;
	private StudentPOJO data;
	private List<StudentPOJO> list;

}
