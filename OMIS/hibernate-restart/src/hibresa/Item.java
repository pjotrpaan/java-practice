package hibresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="endurance")
	private int endurance;
	
	@Column(name="level")
	private Level level;
	
	@Column(name="strength")
	private double strength;
	
	@Column(name="visible")
	private Boolean visible;

	public Item(String name, int endurance, Level level, double strength, Boolean visible) {
		super();
		this.name = name;
		this.endurance = endurance;
		this.level = level;
		this.strength = strength;
		this.visible = visible;
	}
	
	

	public Item() {
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, endurance=%s, level=%s, strength=%s, visible=%s]", id, name,
				endurance, level, strength, visible);
	}

}
