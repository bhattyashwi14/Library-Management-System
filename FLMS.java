import java.util.Scanner;
class Book
{
	String bTitle;
	String author;
	int copies;
	void setbook(String t,String a,int c)
	{
		bTitle=t;
		author=a;
		copies=c;
		
	}
	void displayBook()
	{
		System.out.println();
		System.out.println("*****************");
		System.out.println("Book Title: "+bTitle);
		System.out.println("Written By: "+author);
		System.out.println("Number of Available copies: "+copies);
		System.out.println();
	}
	void searchBook(String title,Book[]b)
	{
		System.out.println();
		System.out.println("******Search Book*******");
		int index=-1;
		for(int i=0;i<b.length;i++)
		{
			if(b[i].bTitle.equalsIgnoreCase(title))
			{
				b[i].displayBook();
				index=i;
				break;
			}
		}
		if(index==-1){
			System.out.println("This book is not available in the library ");
			System.out.println("  Please contact librarian  ");
		}
		System.out.println("*****************");	
	}
}
class Library extends Book

{
	int count;
	Book [] newbook;
	Book [] addBook(Book [] book, Book Book1)
	{
		newbook=new Book[book.length+1];
		for(int i=0;i<book.length;i++)
		{
			newbook[i]=book[i];
		}
		newbook[book.length]=Book1;
		return newbook;
	}
	Book [] addCopy(Book [] book ,String Book1)
	{
		int index=-1;
		for(int i=0;i<newbook.length;i++)
		{
			if(book[i].bTitle.equalsIgnoreCase(Book1))
			{
				book[i].copies++;
				index=i;
			}
		}
		System.out.println("COPIES OF "+Book1+" IS "+book[index].copies);
		return book;
	}
	Book [] removeBook(Book [] book,String book1)
	{
		newbook=new Book[book.length-1];
		int index=-1;
		for(int i=0;i<book.length;i++)
		{
			if(book[i].bTitle.equalsIgnoreCase(book1))
			{
				index=i;
				break;
			}
		}
		System.out.print(index);
		if(index==-1)
		{
			System.out.println("NO SUCH BOOK FOUND");
		}
		else
		{
			for(int i=0;i<index;i++)
			{
				newbook[i]=book[i];
			}
			for(int i=index+1;i<book.length;i++)
			{
				newbook[i-1]=book[i];
			}
		}
		return newbook;
	}	
}
class Member extends Book
{
	static{
		System.out.println("Welcome to L.J.I.E.T :)\nThis is a basic Library Management System \nThis program implements  ");
		
		System.out.println("Inheritance concept of Object oriented programming");
		System.out.println("Static block");
		System.out.println();
		
		}
	Scanner sc=new Scanner(System.in);
	String ID;
    String name;
	int n;
	Member [] newM;
	void set()
	{
		System.out.print("Enter Member name:");
		name=sc.next();
		System.out.print("Enter Members ID:");
		ID=sc.next();
		System.out.print("Enter the number of books borrowed:");
		n=sc.nextInt();
	}
	void get()
	{
		System.out.println("Name:"+name);
		System.out.println("ID:"+ID);
		System.out.println("Number of books borrowed:"+n);
	}
	Member [] addMember(Member newMember,Member [] m1)
	{
		newM=new Member[m1.length+1];
		for(int i=0;i<m1.length;i++)
		{
			newM[i]=m1[i];
		}
		newM[m1.length]=newMember;
		return newM;
	}
	Member [] delMember(Member [] m1,String id1)
	{
		newM=new Member[m1.length-1];
		int index=-1;
		for(int i=0;i<m1.length;i++)
		{
			if(m1[i].ID.equals(id1))
			{
			index=i;
			break;
			}	
		}
		if(index==-1)
		{
			System.out.println("No such Member found with such ID");
		}
		for(int i=0;i<index;i++)
		{
			newM[i]=m1[i];
		}
		for(int i=index+1;i<m1.length;i++)
		{
			newM[i-1]=m1[i];
		}
		return newM;
	}
	  void BorrowBook(Book [] b,String bName,Member m1)
	  { 
	      int index=-1;
		  for(int i=0;i<b.length;i++)
		  {
			  if(b[i].bTitle.equalsIgnoreCase(bName))
			  {
				index=i;			
			  }
		  }
		  if(index==-1)
		  {
			  System.out.println("No such Book available in Library");
		  }
		  else{
			if(b[index].copies==0)
			{System.out.println("NO COPIES AVAILABLE");}
			else if(m1.n>=3)
			{System.out.println("YOU HAVE CROSSED YOUR BORROWING LIMIT");}
			else
			{
				m1.n++;
			    System.out.println("The Book is Borrowed to you");
			    b[index].copies--;
			} 
		  }			
	  }
	  void ReturnBook(Book [] b,String bName,Member m1)
	  {
		int index=-1;
		  for(int i=0;i<b.length;i++)
		  {
			  if(b[i].bTitle.equalsIgnoreCase(bName))
			  {
				index=i;
                b[i].copies++;
                m1.n--;	
				System.out.println("Return Accepted");
				break;
				
			  }
		  }
           if(index==-1)
		   {
			   System.out.println("The book doesn't belong to the Library");
		   }			   
	  }
}
class Main
{
	
	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		 Member m=new Member();
		 Book b1=new Book();
		 Library l=new Library();
		 System.out.print("Enter the number of members:");
		 int n=sc.nextInt();
		 Member [] m1=new Member[n];
		 Book [] b=new Book[6];
		 for(int i=0;i<6;i++)
		 {b[i]=new Book();}
     		 b[0].bTitle="JAVA";
     		 b[0].copies=3;
			 b[0].author="Dr. AB AGNIHOTRI";
     		 b[1].bTitle="PYTHON";
			 b[1].copies=3;
			 b[1].author="VIHAAN AWASTI";
     		 b[2].bTitle="RRB-JE";
			 b[2].copies=2;
			 b[2].author="SWAMI SUBRAMANIUM";
     		 b[3].bTitle="ELECTRICAL CIRCUITS";
			 b[3].copies=2;
			 b[3].author="JAY SWAMINATHAM";
     		 b[4].bTitle="HARRY POTTER";
			 b[4].author="J.K ROWLING";
			 b[4].copies=3;
     		 b[5].bTitle="TOO GOOD TO BE TRUE";
			 b[5].copies=3;
			 b[5].author="PRAJAKTA KOLI";
		 for(int i=0;i<n;i++)
		 {
			m1[i]=new Member();
			System.out.println("Setting details of Members:");
			m1[i].set();
		 }
		System.out.println("!! WELCOME TO LIBRARY !!");
		System.out.println("ARE YOU MEMBER OR LIBRARIAN ?");
		System.out.println("PRSS 1 FOR MEMBER \nPRESS 2 FOR LIBRARIAN");
		int n1=sc.nextInt();
		if(n1==1)
		{
			System.out.print("ENTER YOUR MEMBER ID:");
			String en2=sc.next();
			System.out.println("--------LOGINING IN--------");
			System.out.println("-------------------------------");
					System.out.println("MENU:");
			System.out.println("CHOOSE YOUR GENRE:");
			System.out.println("PRESS 1 FOR ACADEMIC & PRESS 2 FOR NON-ACADEMIC");
			System.out.print("ENTER YOUR CHOICE:");
			int choice=sc.nextInt();
			if(choice==1)
			{
			System.out.println("ACADEMIC BOOKS:");
			System.out.println("CS :\n1.JAVA \n2.PYTHON");
			System.out.println("MECHANICAL : \n1.RRB-JE");
			System.out.println("ELECTRICAL : \n1.ELECTRICAL CIRCUITS");
			
			}
			else
			{
			System.out.println("NON ACADEMIC:");
			System.out.println("Select from the below choices:");
			System.out.println("1.HARRY POTTER");
			System.out.println("2.TOO GOOD TO BE TRUE");
			}
		 int x;
		do{
			 System.out.println("Press 1 to display your profile ");
			 System.out.println("Press 2 to borrow a book");
			 System.out.println("Press 3 to return a book");
			 System.out.println("Press 4 to exit");
			 System.out.print("Enter your choice:");
			 x=sc.nextInt();
	 switch(x)
	 {
		 case 1:
		  int c1=-1;
		 for(int i=0;i<m1.length;i++)
		 {
			if(m1[i].ID.equals(en2))
			{
				c1=i;
				m1[i].get();
			}
		 }
		 if(c1==-1)
		 {
			 System.out.println("No Such ID found");
		 }
		 break;
		  case 2:
		  int c2=-1; 
		  for(int i=0;i<n;i++)
		  {
			if(m1[i].ID.equals(en2))
			{
				c2=i;
				System.out.print("Enter the name of book:");
				String bName=sc.next();
				m.BorrowBook(b,bName,m1[c2]);
			}
		  }
			if(c2==-1)
			{
				System.out.println("No such ID found");
			}
		 break;
		  case 3:
		  int c3=-1;
		  for(int i=0;i<n;i++)
		  {
			if(m1[i].ID.equals(en2))
			{
				c3=i;
				System.out.print("Enter the name of book:");
				String bName1=sc.next();
				m.ReturnBook(b,bName1,m1[c3]);
			}
		  }
			if(c3==-1)
			{
				System.out.println("No such ID found");
			}
		 break;
		  case 4:
		  System.out.println("Exiting");
		 break;
		 default:
		 System.out.println("Enter a valid choice");
	 }
	  }while(x!=4);
	}		
		 else if(n1==2)
		{
			System.out.print("ENTER YOUR LIBRARIAN ID :");
			String en1=sc.next();
			System.out.println("--------LOGINING IN--------");
            int x1;
			  do
			 {
			 System.out.println("Press 1 to display details");
			 System.out.println("Press 2 to add a member");
			 System.out.println("Press 3 to delete a member");
			 System.out.println("Press 4 to display list of members with their details");
			 System.out.println("Press 5 to addbook");
			 System.out.println("Press 6 to addcoppy");
			 System.out.println("Press 7 to remove book");
			 System.out.println("Press 8 to search book");
			 System.out.println("Press 9 to exit");
			 System.out.print("Enter your choice:");
			 x1=sc.nextInt();
			 switch(x1)
			 {
				 case 1:
				 System.out.print("Enter the ID of the member whose details are to displayed:");
				 String id=sc.next();
				 int c1=-1;
				 for(int i=0;i<m1.length;i++)
				 
				 {
					if(m1[i].ID.equals(id))
					{
						c1++;
						m1[i].get();
					}
				 }
				 if(c1==-1)
				 {
					 System.out.println("No Such ID found");
				 }
				 break;
				  case 2:
				  Member newMember=new Member();
				  newMember.set();
				  m1=m.addMember(newMember,m1);
				 break;
				  case 3:
				  System.out.print("Enter the ID of the Member you want to delete:");
				  String id1=sc.next();
				  m1=m.delMember(m1,id1);
				 break;
				  case 4:
				  for(int i=0;i<m1.length;i++)
				  {
					  m1[i].get();
				  }
				 break;
					case 5:
					Book bb=new Book();
					System.out.println("ENTER TITLE OF THE BOOK :");
					String t=sc.next();
					System.out.println("ENTER AUTHOR OF THE BOOK : ");
					String aa=sc.next();
					System.out.println("ENTER COPIES OF THE BOOK : ");
					int cc=sc.nextInt();
					bb.setbook(t,aa,cc);
					b=l.addBook(b,bb);
			     break;
					case 6:
					System.out.println("ENTER NAME OF BOOK WHOSE COPY YOU WANT TO ADD : ");
					String bb1=sc.next();
					l.addCopy(b,bb1);
			     break;
					case 7:
					System.out.println("ENTER A BOOK TO REMOVE : ");
					String bb2=sc.next();
					b=l.removeBook(b,bb2);
				 break;
					case 8:
					System.out.println("ENTER THE BOOK TO SEARCH : ");
					String bb3=sc.next();
					l.searchBook(bb3,b);
				 break;
				  case 9:
				  System.out.println("Exiting");
				 break;
				 default:
				 System.out.println("Enter a valid choice");
			}
			  }while(x1!=9);	 	
		}	
		else
		{
			System.out.println("ENTER VALID CHOICE");
		}
		
	}
}