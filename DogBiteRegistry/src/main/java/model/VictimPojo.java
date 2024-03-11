package model;

import java.util.Objects;
/*
public class VictimPojo 
{
	private String name;
	private int age;
	private String dogBreed;
	private boolean dogVaccinatedStatus;
	private String address;
	public VictimPojo(String name, int age, String dogBreed, boolean dogVaccinatedStatus, String address) {
		super();
		this.name = name;
		this.age = age;
		this.dogBreed = dogBreed;
		this.dogVaccinatedStatus = dogVaccinatedStatus;
		this.address = address;
	}
	public VictimPojo(int i, String vAddress, String vDogBreed, String vName, int vStatus, String string) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDogBreed() {
		return dogBreed;
	}
	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	public boolean isDogVaccinatedStatus() {
		return dogVaccinatedStatus;
	}
	public void setDogVaccinatedStatus(boolean dogVaccinatedStatus) {
		this.dogVaccinatedStatus = dogVaccinatedStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, age, dogBreed, dogVaccinatedStatus, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VictimPojo other = (VictimPojo) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(dogBreed, other.dogBreed)
				&& dogVaccinatedStatus == other.dogVaccinatedStatus && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "VictimPojo [name=" + name + ", age=" + age + ", dogBreed=" + dogBreed + ", dogVaccinatedStatus="
				+ dogVaccinatedStatus + ", address=" + address + "]";
	}

}

*/
//VictimPojo.java
package model;

import java.util.Objects;

public class VictimPojo {
 private String name;
 private int age;
 private String dogBreed;
 private boolean dogVaccinatedStatus;
 private String address;

 public VictimPojo(String name, int age, String dogBreed, boolean dogVaccinatedStatus, String address) {
     this.name = name;
     this.age = age;
     this.dogBreed = dogBreed;
     this.dogVaccinatedStatus = dogVaccinatedStatus;
     this.address = address;
 }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getDogBreed() {
	return dogBreed;
}

public void setDogBreed(String dogBreed) {
	this.dogBreed = dogBreed;
}

public boolean isDogVaccinatedStatus() {
	return dogVaccinatedStatus;
}

public void setDogVaccinatedStatus(boolean dogVaccinatedStatus) {
	this.dogVaccinatedStatus = dogVaccinatedStatus;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public int hashCode() {
	return Objects.hash(address, age, dogBreed, dogVaccinatedStatus, name);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	VictimPojo other = (VictimPojo) obj;
	return Objects.equals(address, other.address) && age == other.age && Objects.equals(dogBreed, other.dogBreed)
			&& dogVaccinatedStatus == other.dogVaccinatedStatus && Objects.equals(name, other.name);
}

@Override
public String toString() {
	return "VictimPojo [name=" + name + ", age=" + age + ", dogBreed=" + dogBreed + ", dogVaccinatedStatus="
			+ dogVaccinatedStatus + ", address=" + address + "]";
}

 
}




