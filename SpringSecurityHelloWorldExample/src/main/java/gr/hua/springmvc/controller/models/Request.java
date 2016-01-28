package gr.hua.springmvc.controller.models;

public class Request {
	private int id;
	private int amka;
	private String name;
	private String surname;
	private String tameio;
	private String email;
	private String approve;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmka() {
		return amka;
	}
	public void setAmka(int amka) {
		this.amka = amka;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTameio() {
		return tameio;
	}
	public void setTameio(String tameio) {
		this.tameio = tameio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	
	
	
}