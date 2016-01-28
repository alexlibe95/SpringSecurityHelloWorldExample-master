package gr.hua.springmvc.controller.models;

public class Appointment {
	private int amka;
	private String name;
	private String surname;
	private String tameio;
	private String ejetash;
	private int emergency;
	private String date;
	private String time;
	
	
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
	public String getEjetash() {
		return ejetash;
	}
	public void setEjetash(String ejetash) {
		this.ejetash = ejetash;
	}
	public int getEmergency() {
		return emergency;
	}
	public void setEmergency(int emergency) {
		this.emergency = emergency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
