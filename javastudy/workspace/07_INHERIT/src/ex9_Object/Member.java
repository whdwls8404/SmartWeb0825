package ex9_Object;

public class Member {

	private String id;
	private String password;

	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	@Override
	public boolean equals(Object obj) {
		// id, password 모두 동일하면 true 반환
		Member other = (Member)obj;
		return id.equals(other.getId()) && password.equals(other.getPassword());
	}
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/*
	@Override
	public String toString() {
		return id + "(" + password + ")";
	}
	*/
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + "]";
	}
	
}
