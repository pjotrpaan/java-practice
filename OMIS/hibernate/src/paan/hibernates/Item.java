package paan.hibernates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="level")
	private int level;
	
	@Column(name="strength")
	private double strength;
	
	@Column(name="endurance")
	private int endurance;
	
	@Column(name="visible")
	private Boolean visible;

	public Item(String name, int level, double strength, int endurance, Boolean visible) {
		super();
		this.name = name;
		this.level = level;
		this.strength = strength;
		this.endurance = endurance;
		this.visible = visible;
	}
	
	
}
