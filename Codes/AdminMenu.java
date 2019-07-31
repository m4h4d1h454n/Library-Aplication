package Management;

import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class AdminMenu 
{
	public AdminMenu()
	{
		
	}
	
	public void AdminOpt()
	{
		Scanner s = new Scanner(System.in);	
		BooksGUI bookGui = new BooksGUI();
		MemberGUI memGui = new MemberGUI();
		int inp;
		Members[] mem = new Members[5];
		Books[] book = new Books[4];
		
		
		
		for(int i = 0; i<book.length; i++)
		{
			book[i]  = null;
		}
		for(int i = 0; i<mem.length; i++)
		{
			mem[i] = null;
		} 
		
		for(;;)
		{
		System.out.print("Enter Your Choice: ");
		inp = s.nextInt();
		if(inp == 1)
		{
			bookGui.addBook(book);
		}
		else if(inp == 2)
		{
			bookGui.disBook(book);
		}
		else if(inp == 3)
		{
			memGui.addMemBer(mem);
		}
		else if(inp == 4)
		{
			memGui.disMem(mem);
		}
		else if(inp == 0)
		{
			break;
		}
		}
	}
		
}
