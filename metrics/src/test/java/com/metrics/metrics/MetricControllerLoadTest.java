package com.metrics.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.metrics.metrics.controller.MetricController;
import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.exceptions.InvalidMetricException;
import com.metrics.metrics.repository.MetricRepo;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MetricControllerLoadTest {
	
	
	@Autowired
	private MetricController metricController;
	@Autowired
	private MetricRepo metricRepo;
	
	private int randy() {
		return new Random().nextInt(1000)+1;
	}
	
	private Double getRandydouble() {
		return new Random().nextDouble()+0.1;
	}
	
	@Test
	void testInit() {
		assertTrue(metricController!=null);
	}

	@Test
	void testMetricControllerCreateAndStatRandomized() throws InvalidMetricException {
		
		int createsTodo = randy();
		
		for(int x=0; x<createsTodo; x++) {
			Metric metric = new Metric();
			metric.setName("BTC");
			metric.setDecimalValue(getRandydouble());
			metricController.creatMetric(metric);
		}
		
		long startTime = System.nanoTime();
		
		log.info("CREATED {} metrics randomized", createsTodo);

		//actual call
		ResponseEntity<Statistics> stats=metricController.getStatistics("BTC");
		
		long stopTime = System.nanoTime();
		System.out.println("RESPORT RUN TIME in milli seconds = "+TimeUnit.MILLISECONDS.convert((stopTime - startTime), TimeUnit.NANOSECONDS));
		assertEquals(stats.getStatusCode(), HttpStatus.OK);
	}
	
}
