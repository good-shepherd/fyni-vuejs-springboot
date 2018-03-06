package com.vueprac.fyni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(exclude = "userPassword")
@Entity
public class User implements Serializable {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Id @Column(name = "user_id") @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userID;

	// @Basic(optional = false) the persistence provider may throw an exception when you try to persist or update an object where the property is null.
	@Column(name = "user_email", nullable = false, unique = true, length = 64)
	private String userEmail;

	@Column(name = "user_password", nullable = false)
	@JsonIgnore
	private String userPassword;

	@Column(name = "user_nickname", nullable = false, length = 16)
	private String userNickname;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "user_location_x")
	private String userLocationX;

	@Column(name = "user_location_y")
	private String userLocationY;

	@Column(name = "user_exp")
	private int userEXP;

	@Column(name = "user_privacy")
	private boolean userPrivacy;

	@Column(name = "user_date")
	@Temporal(TemporalType.DATE)
	private Date userDate;

	@Column(name = "user_roles")
	private String[] userRoles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Event> events = new ArrayList<>();

	public void setUserPassword(String password) {
		this.userPassword = PASSWORD_ENCODER.encode(password);
	}

	public User(String userEmail, String userPassword, String userNickname, String userAddress, String userLocationX, String userLocationY, int userEXP, boolean userPrivacy, String... userRoles) {
		this.userEmail = userEmail;
		this.setUserPassword(userPassword);
		this.userNickname = userNickname;
		this.userAddress = userAddress;
		this.userLocationX = userLocationX;
		this.userLocationY = userLocationY;
		this.userEXP = userEXP;
		this.userPrivacy = userPrivacy;
		this.userDate = new Date();
		this.userRoles = userRoles;
	}
}
