package com.metrics.metrics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metrics.metrics.entity.Metric;

@RestController("/metrics")
public class MetricController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Metric> creatMetric(Metric metric) {
		
		return null;
	}
	
	
}
