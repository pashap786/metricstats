package com.metrics.metrics.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		
		Collections.sort(metrics);
		
		stats.setName(metrics.get(0).getName());
		
		Double sum = sumAllMetrics(metrics);
		
		stats.setMean(getMean(sum, metrics.size()));
		
		stats.setMin(getMinimum(metrics));
		
		metrics = removeTheZeros(metrics);
		
		stats.setMedian(getMedian(metrics));
		
		stats.setMax(getMaximum(metrics));
		
		log.info("STATS {}", stats);
		
		return stats;
	}
	
	public List<Metric> removeTheZeros(List<Metric> values) {
		return values.stream().filter(e -> e.getDecimalValue()!=0.0).collect(Collectors.toList());
	}
	
	public Double getMinimum(List<Metric> values) {
		return values.get(0).getDecimalValue();
	}
	
	public Double getMaximum(List<Metric> values) {
		return values.get(values.size()-1).getDecimalValue();
	}
	
	public Double getMedian(List<Metric> values) {
		
		int result = values.size()%2;
		
		if(result>=1) {
			int index = ((values.size()+1)/2-1);
			return values.get(index).getDecimalValue();
		} else {
			int divideByTwo = values.size()/2;
			int divideByTwoMinus1 = values.size()/2-1;
			return (values.get(divideByTwoMinus1).getDecimalValue()+values.get(divideByTwo).getDecimalValue())/2;
		}
	}
	
	public Double getMean(Double sum, int total) {
		return sum/total;
	}

	public Double sumAllMetrics(List<Metric> values) {
		return values.stream().map(m -> { return m.getDecimalValue(); }).reduce(0.0, (a,b)->a+b);
	}
	
}
