package javaweb.Entity;
// Generated Apr 11, 2021, 1:55:39 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * District generated by hbm2java
 */
@Entity
@Table(name = "district", catalog = "mydb")
public class District implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Ward> wards = new HashSet<Ward>(0);

	public District() {
	}

	public District(String name) {
		this.name = name;
	}

	public District(String name, Set<Ward> wards) {
		this.name = name;
		this.wards = wards;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	public Set<Ward> getWards() {
		return this.wards;
	}

	public void setWards(Set<Ward> wards) {
		this.wards = wards;
	}

}