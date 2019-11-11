package my.sc.queue.server.admin;

import java.util.Date;

public class Queue {
	
	private Integer id;
	
	private String name;
	
	private Party sender;
	
	private Party receiver;
	
	private Integer createdBy;
	
	private Date createdOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Party getSender() {
		return sender;
	}

	public void setSender(Party sender) {
		this.sender = sender;
	}

	public Party getReceiver() {
		return receiver;
	}

	public void setReceiver(Party receiver) {
		this.receiver = receiver;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	
}
