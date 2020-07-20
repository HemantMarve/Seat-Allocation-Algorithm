package entity;

public class Course {
private String name;
private int totalseats;
public Course(String name, int totalseats) {
	this.name=name;
	this.totalseats=totalseats;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getTotalseats() {
	return totalseats;
}
public void setTotalseats(int totalseats) {
	this.totalseats = totalseats;
}

}
