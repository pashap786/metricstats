package com.metrics.metrics.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.service.MetricService;

@Service
public class MetricServiceImpl implements MetricService {

	@Override
	public ResponseEntity<Metric> createMetric(Metric metric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Metric> addValueToMetric(Metric metric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Metric> getStatsOfMetric(String metricName) {
		// TODO Auto-generated method stub
		return null;
	}

}
