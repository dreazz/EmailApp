//TODO creacion de password random
//This class is were we are creating the objects
package EmailApp;

import java.util.Scanner;

public class Email {
	//Made private so no one could acces to it. 
	//We could access it with our class API
	private String firstName;
	private String lastName;
	private String department;
	private String company;
	private String password;
	private  int passwordLength=8;
	private String email;
	private int emailBoxCapacity;
	private String alternateEmail;
	private String companyDomain;
	
	
	
	//Creating constructors 
	//Constructor lastName and firstName
	public Email(String firstName , String lastName) {
		this.firstName=firstName.toLowerCase();
		this.lastName=lastName.toLowerCase();
		System.out.println("Email works: "+ this.firstName + this.lastName+"");
		//Declaramos que department es igual a la clase setDepartment para poder acceder a el
		this.department=setDepartment().toLowerCase();
		this.companyDomain="@"+this.department+"company.com";
		System.out.println("Department: "+this.department);
		this.password=randomPassword(passwordLength);
		
		this.email=this.firstName+this.lastName+this.companyDomain;
		System.out.println(this.email);
		
	}

	private String setDepartment() {
		System.out.print("Choose your Department:\n1)Sales\n2)Development\n3)Accounting\n0)None\nAnswer: ");
		Scanner in= new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice == 1 ) {
		return "Sales.";
		}else if(depChoice==2) {
		return "Development.";
		}else if(depChoice==3) {
		return	"Accounting.";
		}else {
			return "";
		}
		
	}
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890@/()!";
		char[] password=new char[length];
		for(int i=0; i<length;i++) {
			
			int ran=(int) (Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(ran);
		}
		System.out.println(password);
		//convertimos password a String ya que tenia formato char y teniamos que devolver una String
		return new String (password);
	}
}