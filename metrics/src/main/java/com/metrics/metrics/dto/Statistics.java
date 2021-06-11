package com.metrics.metrics.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class Statistics {

	private String name;
	private Double mean;
	private Double median;
	private Double min;
	private Double max;
	
}
