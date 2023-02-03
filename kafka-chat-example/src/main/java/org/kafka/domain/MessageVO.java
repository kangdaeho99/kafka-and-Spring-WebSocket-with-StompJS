package org.kafka.domain;

public class MessageVO {
	private String sender;
	private String message;
	
	public MessageVO() {
		
	}
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
}
