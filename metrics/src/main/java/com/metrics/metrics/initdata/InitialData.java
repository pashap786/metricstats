package com.metrics.metrics.initdata;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.metrics.metrics.entity.Metric;
import com.metrics.metrics.repository.MetricRepo;
import com.metrics.metrics.service.impl.MetricProcessor;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialData {

	private final MetricRepo metricRepo;
	private final MetricProcessor mp;
	
	@PostConstruct
	public void loadData() {
		List<Metric> ms = new ArrayList<>();
		
		Metric m = new Metric();

		m.setName("BTC");
		m.setDecimalValue(30000.00);
		
		ms.add(m);
		m = new Metric();

		m.setName("BTC");
		m.setDecimalValue(31000.00);
		ms.add(m);
		m = new Metric();

		m.setName("BTC");
		m.setDecimalValue(32000.00);
		ms.add(m);
		m = new Metric();

		m.setName("BTC");
		m.setDecimalValue(30000.00);
		ms.add(m);
		
		metricRepo.saveAll(ms);
		
		List<Metric> mets = metricRepo.findAll();
		mets.stream().forEach(s -> System.out.println(s.getDecimalValue()));
		
		mp.populateStats(ms);
	}
	
	
}
