package com.metrics.metrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.exceptions.InvalidMetricException;
import com.metrics.metrics.service.MetricService;
import com.metrics.metrics.validator.MetricValidator;

@RestController("/metrics")
public class MetricController {
	
	@Autowired
	private MetricService metricService;
	@Autowired
	private MetricValidator mv;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Metric> creatMetric(Metric metric) throws InvalidMetricException {
		//do some basic validation
		if(mv.isValidMetric(metric)) {
			return metricService.createMetric(metric);
		}
		return new ResponseEntity<Metric>(new Metric(), HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public ResponseEntity<Statistics> getStatistics(@PathVariable("name") String name) {
		return metricService.getStatsOfMetric(name);
	}
	
}
