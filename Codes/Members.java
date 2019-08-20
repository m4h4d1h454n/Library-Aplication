package Management;

public class Members 
{
	private String memberName;
	private String Dessignation;
	private String memID;
	private String memPass;
	private int attandance = 0;
	
	public Members()
	{
		
	}
	public Members(String memberName, String dess, String memID, String memPass)
	{
		this.memberName = memberName;
		this.Dessignation = dess;
		this.memID = memID;
		this.memPass = memPass;
	}
	public String getMemberName() 
	{
		return memberName;
	}
	public void setMemberName(String memberName) 
	{
		this.memberName = memberName;
	}
	public String getDessignation() 
	{
		return Dessignation;
	}
	public void setDessignation(String dessignation) 
	{
		this.Dessignation = dessignation;
	}
	public String getMemID()
	{
		return memID;
	}
	public void setMemID(String memID)
	{
		this.memID = memID;
	}
	public String getMemPass()
	{
		return memPass;
	}
	public void setMemPass(String memPass) 
	{
		this.memPass = memPass;
	}
	public int getAttandance() 
	{
		return attandance;
	}
	public void CountAttandance() 
	{
		this.attandance++ ;
	}
	public String toString()
	{
		return("Member Name: " + this.getMemberName() + "\nDessignation: " + this.getDessignation() + "\nMember ID: " + this.getMemID()+"\nAttandance: "+ this.getAttandance() );
	}
	
	
}
