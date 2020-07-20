package entity;

public class Choice {
private String instituename;
boolean result;
 private String coursename;
public String getInstituename() {
	return instituename;
}
public void setInstituename(String instituename) {
	this.instituename = instituename;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public boolean isResult() {
	return result;
}
public void setResult(boolean result) {
	this.result = result;
}

	public Choice(String name, String course){
		this.instituename=name;
		this.coursename=course;
	}

}
