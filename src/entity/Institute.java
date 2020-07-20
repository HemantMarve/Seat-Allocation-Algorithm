package entity;

import java.util.HashMap;
public class Institute {
 private HashMap<String,Course> h=new HashMap<>();
 private String name;
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public void addCourse(String name,int totalseats)
{
	h.put(name,new Course(name,totalseats));
}
public HashMap<String,Course> getCourse()
{
	

return h;
}

}
