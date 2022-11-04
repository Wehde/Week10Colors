/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 30, 2022
 */
package dmacc.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Palette {
	//Variables
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int count;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<HexColor> colors;
	
	//Getters and Setters
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the colors
	 */
	public List<HexColor> getColors() {
		return colors;
	}
	/**
	 * @param colors the colors to set
	 */
	public void setColors(List<HexColor> colors) {
		this.colors = colors;
	}
	
	//Constructors
	/**
	 * 
	 */
	public Palette() {
		super();
	}
	/**
	 * @param name
	 */
	public Palette(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param name
	 * @param count
	 * @param colors
	 */
	public Palette(String name, int count, List<HexColor> colors) {
		super();
		this.name = name;
		this.count = count;
		this.colors = colors;
	}
	/**
	 * @param id
	 * @param name
	 * @param count
	 * @param colors
	 */
	public Palette(long id, String name, int count, List<HexColor> colors) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.colors = colors;
	}

	//Methods
	@Override
	public String toString() {
		return "Palette [id=" + id + ", name=" + name + ", count=" + count + ", colors=" + colors + "]";
	}
}
