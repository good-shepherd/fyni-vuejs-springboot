package com.vueprac.fyni.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Event implements Serializable {

	@Id @Column(name = "event_id") @GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventID;

	@Column(name = "event_title", nullable = false)
	private String eventTitle;

	@Column(name = "event_content", nullable = false)
	private String eventContent;

	@Column(name = "event_vote")
	private int eventVote;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_when_begins")
	private Date eventWhenBegins;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_when_ends")
	private Date eventWhenEnds;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_when_written")
	private Date eventWhenWritten;

	@Column(name = "event_picture")
	private String eventPicture;

	@Column(name = "event_hit")
	private int eventHit;

	@Column(name = "event_address")
	private String eventAddress;

	@Column(name = "event_location_x")
	private String eventLocationX;

	@Column(name = "event_location_y")
	private String eventLocationY;

	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Event(String eventTitle, String eventContent, int eventVote, Date eventWhenBegins, Date eventWhenEnds, String eventPicture, String eventAddress, String eventLocationX, String eventLocationY, User user) {
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.eventVote = eventVote;
		this.eventWhenBegins = eventWhenBegins;
		this.eventWhenEnds = eventWhenEnds;
		this.eventPicture = eventPicture;
		this.eventAddress = eventAddress;
		this.eventLocationX = eventLocationX;
		this.eventLocationY = eventLocationY;
		this.user = user;
		this.eventHit = 0;
		this.eventWhenWritten = new Date();
	}
}
