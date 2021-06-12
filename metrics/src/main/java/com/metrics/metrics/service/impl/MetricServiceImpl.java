package com.metrics.metrics.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.repository.MetricRepo;
import com.metrics.metrics.service.MetricService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricServiceImpl implements MetricService {

	private final MetricProcessor metricProcessor;
	private final MetricRepo metricRepo;

	@Override
	public ResponseEntity<Metric> createMetric(Metric metric) {
		log.info("Creating metric");
		return new ResponseEntity<Metric>(metricRepo.save(metric), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Statistics> getStatsOfMetric(String metricName) {
		log.info("Get stats for metric {}", metricName);
		List<Metric> metrics = metricRepo.findAllMetricByName(metricName);
		if (metrics.isEmpty()) {
			return null;
		}
		try {
			Statistics stats = metricProcessor.populateStats(metrics);
			return new ResponseEntity<Statistics>(stats, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Statistics>(new Statistics(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
