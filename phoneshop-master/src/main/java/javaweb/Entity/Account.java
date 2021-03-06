package javaweb.Entity;
// Generated Apr 11, 2021, 1:55:39 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "mydb")
public class Account implements java.io.Serializable {

	@NotEmpty(message = "Không được bỏ trống")
	@Pattern(regexp = "[a-zA-Z0-9]{8,20}", message = "8 đến 20 ký tự chữ số")
	private String username;
	@NotEmpty(message = "Không được bỏ trống")
	@Pattern(regexp = "[a-zA-Z0-9]{8,20}", message = "8 đến 20 ký tự chữ số")
	private String password;
	private String passwordConfirm;
	@NotEmpty(message = "Không được bỏ trống")
	@Email(message = "Không đúng định dạng email !")
	private String email;
	@NotEmpty(message = "Không được bỏ trống")
	@Pattern(regexp = "[0-9]{9,11}", message = "Không đúng định dạng !")
	private String phone;
	private int type;
	private byte status;
	@NotEmpty(message = "Không được bỏ trống")
	@Pattern(regexp = "[a-z A-Z]{1,100}", message = "Họ tên có số hoặc ký tự đặc biệt trong đó")
	private String name;
	private int gender;
	private String resetPasswordToken;
	private Set<Rating> ratings = new HashSet<Rating>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Bill> bills = new HashSet<Bill>(0);

	public Account() {
	}

	public Account(String username, String password, String phone, int type, byte status, String name, int gender,
			String resetPasswordToken) {
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.type = type;
		this.status = status;
		this.name = name;
		this.gender = gender;
		this.resetPasswordToken = resetPasswordToken;
	}

	public Account(String username, String password, String email, String phone, int type, byte status, String name,
			int gender, String resetPasswordToken, Set<Rating> ratings, Set<Comment> comments, Set<Bill> bills) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.status = status;
		this.name = name;
		this.gender = gender;
		this.resetPasswordToken = resetPasswordToken;
		this.ratings = ratings;
		this.comments = comments;
		this.bills = bills;
	}

	@Id

	@Column(name = "USERNAME", unique = true, nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONE", nullable = false, length = 10)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "TYPE", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "STATUS", nullable = false)
	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	@Column(name = "GENDER", nullable = false)
	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "reset_password_token", nullable = true)
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

}
