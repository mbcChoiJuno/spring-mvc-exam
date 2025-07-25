package org.spring.exam.core;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "isSuccess", "resCode", "resMessage", "data" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {

	@JsonProperty("isSuccess")
	private boolean isSuccess;
	private int resCode;
	private String resMessage;
	private T data;
	
	public ApiResult(T data) {
		isSuccess = true;
		resCode = HttpServletResponse.SC_OK;
		resMessage = "SUCCESS";
		
		this.data = data;
	}
}
