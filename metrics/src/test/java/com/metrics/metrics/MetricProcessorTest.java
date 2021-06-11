package com.metrics.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.service.impl.MetricProcessor;

@RunWith(MockitoJUnitRunner.class)
class MetricProcessorTest {
	

	private MetricProcessor mp = new MetricProcessor();
	private List<Metric> mets = new ArrayList<>();
	
	
	@Test
	void testRemoveZeros() {
		List<Metric> metrics = new ArrayList<>();
		int oldsize = metrics.size();
		
		Metric m = new Metric();
		m.setDecimalValue(0.0);
		metrics.add(m);
		
		m= new Metric();
		m.setDecimalValue(0.1);
		metrics.add(m);
		
		metrics = mp.removeTheZeros(metrics);
		
		assertNotEquals(oldsize, metrics.size());
		
	}
	
	@Test
	void testGetMinimum() {
		Metric m1 = new Metric();
		m1.setDecimalValue(100.0);
		mets.add(m1);
		m1=new Metric();
		m1.setDecimalValue(110.0);
		mets.add(m1);
		Collections.sort(mets);
		Double min = mp.getMinimum(mets);
		assertEquals(new Double(100.0), min);
	}
	
	@Test
	void testGetMaximum() {
		Metric m1 = new Metric();
		m1.setDecimalValue(100.0);
		mets.add(m1);
		m1=new Metric();
		m1.setDecimalValue(110.0);
		mets.add(m1);
		Double min = mp.getMaximum(mets);
		assertEquals(new Double(110.0), min);
	}
}
