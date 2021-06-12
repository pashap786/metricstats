package com.metrics.metrics.service;

import org.springframework.http.ResponseEntity;

import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;

public interface MetricService {
	
	public ResponseEntity<Metric> createMetric(Metric metric);
	public ResponseEntity<Statistics> getStatsOfMetric(String metricName);

}
