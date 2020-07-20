package controller;

import java.util.*;


import entity.Result;
import entity.Candidate;
import entity.Course;
import entity.Institute;

public class Main {	
	static HashMap<String,Institute> h=new HashMap<>();
	static List<Candidate> canlist=new LinkedList<>();
	private static Scanner scan=new Scanner(System.in);
	
	//add institutes
public void addInstitutes()
	{
		System.out.println("Enter Institues:");
		int i=0;
		do
		{
			Institute temp=new Institute();
			System.out.print("Enter Institue Name=");
			temp.setName(scan.nextLine());
			do
			{
				System.out.print("Enter Course Name=");
				String name=scan.nextLine();
				System.out.print("Enter No. of seats in course=");
				int seats=scan.nextInt();
				scan.nextLine();
				temp.addCourse(name,seats);
				System.out.print("Press 1 to enter more courses otherwise 0=");
				i=scan.nextInt();
				scan.nextLine();
			}while(i==1);
			h.put(temp.getName(),temp);
			System.out.print("press 1 to enter more institute otherwise 0=");	
			i=scan.nextInt();
			scan.nextLine();
		}while(i==1);
	}

//add candidates with choices
public void addCandidates(int n) {
	int i=0;
	scan.nextLine();
	do
	{
		Candidate temp=new Candidate();
	System.out.print("Enter name of Candidate=");
	temp.setName(scan.nextLine());
	System.out.print("Enter Email=");
	temp.setEmail(scan.nextLine());
	System.out.print("Enter JEE Rank=");
	temp.setRank(scan.nextInt());
	scan.nextLine();
	int j=1;
	while(j<=n)
	{
	System.out.print("Enter name of Institue as ("+j+") choice=");
	String insname=scan.nextLine();
	System.out.print("Enter name of Course as (" +j+") in that Institute=");
	String csname=scan.nextLine();
	temp.addChoice(insname, csname);
	j++;
	}
	canlist.add(temp);
	System.out.print("press 1 to enter more Candidates otherwise 0=");	
	i=scan.nextInt();
	scan.nextLine();
	}while(i==1);
	
}
	
	public static void main(String[] args)
	{
    Main m=new Main();
    m.addInstitutes();
    System.out.print("Enter no. of Rounds in Counselling:");
    int rounds=scan.nextInt();
    for(int j=0;j<rounds;j++)
    {
    System.out.print("Enter no. of Choices a Candidate can Fill=");
    m.addCandidates(scan.nextInt());
    
    Algorithm obj=new Algorithm();
    
    List<Result> result=obj.seatAllocation(h,canlist);
    System.out.println(":::::::::::::::::::::::Seat Allocation::::::::::::::::::::::");
    for(Result t:result)
    {
    	System.out.println("Candidate Name:"+t.getName()+"      Course:"+t.getCourse()+"        Institute:"+t.getInstituename());
    }
    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    System.out.println(":::::::::::::::::::::::Seats Left After Round::::::::::::::::::::::");
    for(Map.Entry<String,Institute> map:h.entrySet())
    {
    	Institute i=map.getValue();
    	System.out.println("Innstitue Name:     "+map.getKey());
    	HashMap<String,Course> c=i.getCourse();
    	for(Course p:c.values())
    	{
    		System.out.println("Course Name: "+p.getName()+"                                 Total Seats Left:  "+p.getTotalseats());
    	}
    	System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
    
    }
   }



}
