package com.koreait.ex01.java.quiz02;

import java.util.Arrays;
import java.util.Map;

public class Soldier {

    private String name;
    private Gun gun;
    private Map<String, String> army;
    
    public Soldier() {
		// TODO Auto-generated constructor stub
	}
	public Soldier(String name, Gun gun, Map<String, String> army) {
		super();
		this.name = name;
		this.gun = gun;
		this.army = army;
	}
	
	public void soldierInfo() {
		System.out.println("name : " + name);
		System.out.println("model : " + gun.getModel());
		System.out.println("bullet : " + gun.getBullet());
		Arrays.sort( army.keySet().toArray() );  // key 정렬을 위해서 key만 빼고 정렬할 수 있는 배열로 변경
		for (Map.Entry<String, String> entry : army.entrySet()) {
			System.out.println("army's " + entry.getKey() + " : " + entry.getValue());
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gun getGun() {
		return gun;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	public Map<String, String> getArmy() {
		return army;
	}
	public void setArmy(Map<String, String> army) {
		this.army = army;
	}
	
}
