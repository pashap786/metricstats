package com.metrics.metrics.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MetricProcessor {

	public Statistics populateStats(List<Metric> metrics) {
		if(metrics.isEmpty()) {
			return new Statistics();
		}
		Statistics stats = new Statistics();
		
		Double sum = sumAllMetrics(metrics);
		log.info("sum of all metric {}", sum);
		stats.setMean(getMean(sum, metrics.size()));
		
		return stats;
	}
	
	public Double getMean(Double sum, int total) {
		return sum/total;
	}

	public Double sumAllMetrics(List<Metric> values) {
		return values.stream().map(m -> { return m.getDecimalValue(); }).reduce(0.0, (a,b)->a+b);
	}
	
}
