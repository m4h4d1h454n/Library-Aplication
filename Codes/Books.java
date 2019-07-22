package Management;

public class Books 
{
	private String name;
	private String department;
	private String author;
	private String subject;
	private int serialNo;
	private boolean isHired = false;
	public Books()
	{
		
	}
	public Books(String name, String department, String author, String subject, int serialNo)
	{
		this.name = name;
		this.department = department;
		this.author = author;
		this.subject = subject;
		this.serialNo = serialNo;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDepartment() 
	{
		return department;
	}
	public void setDepartment(String department) 
	{
		this.department = department;
	}
	public String getAuthor() 
	{
		return author;
	}
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	public String getSubject() 
	{
		return subject;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}
	public int getSerialNo() 
	{
		return serialNo;
	}
	public void setSerialNo(int serialNo) 
	{
		this.serialNo = serialNo;
	}
	public boolean getIsHired() 
	{
		return isHired;
	}
	public void setIsHired(boolean isHired) 
	{
		this.isHired = isHired;
	}
	public String toString()
	{
		return("Book Name: " + getName() + "\nAuthor Name: " + getAuthor() + "\nDepartment: " + getDepartment() + "\nSubject: " + getSubject());
	}
	
}
