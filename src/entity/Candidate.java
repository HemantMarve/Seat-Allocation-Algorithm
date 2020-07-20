package entity;

import java.util.LinkedList;
import java.util.List;

public class Candidate {
private int rank;
private String name;
private String email;
private List<Choice> l=new LinkedList<Choice>();

public void addChoice(String name,String course)
{
	l.add(new Choice(name,course));

}

public List<Choice> getChoice()
{
	return l;
	}

public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
