package com.metrics.metrics.validator;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.exceptions.InvalidMetricException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MetricValidator {

	public boolean isValidMetric(Metric metric) throws InvalidMetricException {
		if(metric == null) {
			throw new InvalidMetricException("There is no metric here man.");
		}
		if(!StringUtils.hasText(metric.getName())) {
			throw new InvalidMetricException("We need a name");
		}
		if(null==metric.getDecimalValue()) {
			throw new InvalidMetricException("With no value this serves no purpose");
		}
		return true;
	}
	
}
