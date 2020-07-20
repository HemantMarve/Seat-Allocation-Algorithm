package controller;
import java.util.*;

import entity.Candidate;
import entity.Choice;
import entity.Course;
import entity.Institute;
import entity.Result;



class SortCandidates implements Comparator<Candidate>
{

	@Override
	public int compare(Candidate o1, Candidate o2) {
		if(o1.getRank()>o2.getRank())
			return 1;
		else
		return -1;
	}
	}
public class Algorithm {
	public List<Result> seatAllocation(HashMap<String, Institute> h, List<Candidate> canlist) {
		Collections.sort(canlist,new SortCandidates());
		List<Result> p=new LinkedList<Result>();
			l1:for(int j=0;j<canlist.size();j++)
			{
				boolean status=false;
				for(int i=0;i<canlist.get(0).getChoice().size();i++)
				{
				Candidate c1=canlist.get(j);
			Choice c=c1.getChoice().get(i);
			Institute iobj=h.get(c.getInstituename());
			String instituename=iobj.getName();
			Course d=iobj.getCourse().get(c.getCoursename());
			int number_seats=d.getTotalseats();
			
			if(status==false)
			{
				if(number_seats>0)
				{
					Result r=new Result();
					r.setInstituename(instituename);
					r.setCourse(d.getName());
					r.setName(c1.getName());
					status=true;
					c.setResult(true);
					d.setTotalseats(number_seats-1);
					p.add(r);
					continue l1;
				}
			}
				}
			}
		return p;
	}

}
