package edu.kh.collection.model.vo;

import java.util.Objects;

public class Member {

	private String id;
	private String pw;
	private int age;
	
	public Member() {}

	public Member(String id, String pw, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	
	//getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}
	
	// alt+ shif+ s -> generator hashCode + equals
	@Override
	public int hashCode() {
		return Objects.hash(age, id, pw); // 숫자?
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 매개변수랑 현재 클래스의 필드랑 같은지 확인  
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
