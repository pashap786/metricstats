package com.metrics.metrics.service;

import org.springframework.http.ResponseEntity;

import com.metrics.metrics.entity.Metric;

public interface MetricService {
	
	public ResponseEntity<Metric> createMetric(Metric metric);
	public ResponseEntity<Metric> addValueToMetric(Metric metric);
	public ResponseEntity<Metric> getStatsOfMetric(String metricName);

}
