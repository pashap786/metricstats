package com.metrics.metrics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "metric")
public class Metric implements Comparable<Metric> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "value_decimal")
	private Double decimalValue;


	@Override
	public int compareTo(Metric o) {
		return this.getDecimalValue().compareTo(o.getDecimalValue());
	}

}
