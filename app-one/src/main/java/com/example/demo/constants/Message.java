package com.example.demo.constants;

public class Message {
	
	private int id;
	private String status;
	private String message;
	private int code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", status=" + status + ", message=" + message + ", code=" + code + "]";
	}
	
	

}
