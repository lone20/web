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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ward generated by hbm2java
 */
@Entity
@Table(name = "ward", catalog = "mydb")
public class Ward implements java.io.Serializable {

	private Integer id;
	private District district;
	private String name;
	private Set<Commune> communes = new HashSet<Commune>(0);

	public Ward() {
	}

	public Ward(District district, String name) {
		this.district = district;
		this.name = name;
	}

	public Ward(District district, String name, Set<Commune> communes) {
		this.district = district;
		this.name = name;
		this.communes = communes;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ward")
	public Set<Commune> getCommunes() {
		return this.communes;
	}

	public void setCommunes(Set<Commune> communes) {
		this.communes = communes;
	}

}