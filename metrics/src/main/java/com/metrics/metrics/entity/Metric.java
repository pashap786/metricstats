package com.metrics.metrics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metric")
public class Metric {
	
	@Id
	private Long id;

}
