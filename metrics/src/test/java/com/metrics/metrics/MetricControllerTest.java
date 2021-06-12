package com.metrics.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.metrics.metrics.controller.MetricController;
import com.metrics.metrics.dto.Statistics;
import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.exceptions.InvalidMetricException;

@SpringBootTest
public class MetricControllerTest {

	@Autowired
	private MetricController metricController;
	
	@Test
	void testInit() {
		assertTrue(metricController!=null);
	}
	
	@Test
	void testCreateMetricNoName() throws InvalidMetricException {
		Metric m = new Metric();
		 Exception exception = assertThrows(InvalidMetricException.class, () -> {
			 ResponseEntity<Metric> response = metricController.creatMetric(m);
			 assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		 });
		assertEquals("We need a name", exception.getMessage());
	}
	
	@Test
	void testCreateMetricNoDecimalValue() throws InvalidMetricException {
		Metric m = new Metric();
		m.setName("Mark");
		 Exception exception = assertThrows(InvalidMetricException.class, () -> {
			 ResponseEntity<Metric> response = metricController.creatMetric(m);
			 assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		 });
		assertEquals("With no value this serves no purpose", exception.getMessage());
	}
	
	@Test
	void testCreateMetricHappyPath() throws InvalidMetricException {
		Metric m = new Metric();
		m.setName("Mark");
		m.setDecimalValue(111.1);
		
		ResponseEntity<Metric> response = metricController.creatMetric(m);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		
	}
	
	@Test
	void testGetStatistics() {
		ResponseEntity<Statistics> stats = metricController.getStatistics("BTC");
		assertEquals(stats.getStatusCode(), HttpStatus.OK);
		Statistics s = stats.getBody();
		
		assertEquals("BTC", s.getName());
		assertEquals(new Double(31250.0), s.getMean());
		assertEquals(new Double(31500.0), s.getMedian());
		assertEquals(new Double(30000.0), s.getMin());
		assertEquals(new Double(32000.0), s.getMax());
	}
	
}
