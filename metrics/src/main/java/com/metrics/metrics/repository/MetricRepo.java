package com.metrics.metrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrics.metrics.entity.Metric;

public interface MetricRepo extends JpaRepository<Long, Metric> {

}
