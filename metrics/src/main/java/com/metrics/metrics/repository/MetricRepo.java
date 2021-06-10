package com.metrics.metrics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metrics.metrics.entity.Metric;

public interface MetricRepo extends JpaRepository<Metric, Long> {
	
	@Query("select m from Metric m where m.name=:name")
	public List<Metric> findAllMetricByName(@Param("name") String name);
	@Query("select m from Metric m where m.name=:name")
	public boolean metricExists(@Param("name") String name);

}
