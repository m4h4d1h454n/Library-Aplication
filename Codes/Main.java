package Management;


public class Main 
{

	public static void main(String[] args) 
	{ 
		Books[] b = new Books[4];
		Members[] mem1 = new Members[4];
		LogIn li = new LogIn();
		li.Check();
		AdminMenuGUI amg = new AdminMenuGUI();
		//amg.Admin();
		MemberGUI mem = new MemberGUI();
		//mem.addMemBer(mem1);
		SearchBook sb = new SearchBook();
		//sb.search();
		DeleteBook db = new DeleteBook();
		//db.delete();
		BooksGUI bg = new BooksGUI();
		//bg.addBook(b);
		viewMem vm = new viewMem();
		//vm.view();
		disMem dm = new disMem();
		//dm.delete();
		srcMem sm = new srcMem();
		//sm.search();
		ViewBook vb = new ViewBook();
		//vb.view();
		StudentMenu sm2 = new StudentMenu();
		//sm2.sMenu();
		
	}
	
}
