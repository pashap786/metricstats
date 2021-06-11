package com.metrics.metrics.service.impl;

import java.util.Collections;
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
		
		Collections.sort(metrics);
		stats.setName(metrics.get(0).getName());
		metrics.stream().forEach(System.out::println);
		
		Double sum = sumAllMetrics(metrics);
		log.info("sum of all metric {}", sum);
		stats.setMean(getMean(sum, metrics.size()));
		stats.setMedian(getMedian(metrics));
		stats.setMin(getMinimum(metrics));
		stats.setMax(getMaximum(metrics));
		log.info("STATS {}", stats);
		return stats;
	}
	
	public Double getMinimum(List<Metric> values) {
		return values.get(0).getDecimalValue();
	}
	
	public Double getMaximum(List<Metric> values) {
		return values.get(values.size()-1).getDecimalValue();
	}
	
	public Double getMedian(List<Metric> values) {
		log.info("lsit size {}", values.size());
		int result = values.size()%2;
		log.info("result of div {}", result);
		if(result>=1) {
			int index = ((values.size()+1)/2-1);
			log.info("result was one {}", index);
			return values.get(index).getDecimalValue();
		} else {
			int divideByTwo = values.size()/2;
			int divideByTwoMinus1 = values.size()/2-1;
			log.info("aver {} + {} / 2 = ", values.get(divideByTwo), values.get(divideByTwoMinus1));
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
