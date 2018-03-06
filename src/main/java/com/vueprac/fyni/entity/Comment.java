package com.vueprac.fyni.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Comment implements Serializable {

	@Id
	@Column(name = "comment_id") @GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentID;

	@Column(name = "comment_content", nullable = false)
	private String commentContent;

	@Column(name = "comment_vote")
	private int commentVote;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comment_when_written")
	private Date commentWhenWritten;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
