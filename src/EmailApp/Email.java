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
		//cogemos mediante el input del usuario el nombre y el apellido
		this.firstName=firstName.toLowerCase();
		this.lastName=lastName.toLowerCase();
		System.out.println("Welcome "+ this.firstName + this.lastName+"");
		//Declaramos que department es igual a la clase setDepartment para poder acceder a el y pasamos los valores a minusculas
		this.department=setDepartment().toLowerCase();
		//agregamos el domain de la empresa, lo inicializamos aqui por que arriba no pilla department
		this.companyDomain="@"+this.department+"company.com";
		System.out.println("Department: "+this.department);
		//aqui le pasamos al parametro del method randomPassword el length definido al principio
		this.password=randomPassword(passwordLength);
		//SIntaxis del email
		this.email=this.firstName+this.lastName+this.companyDomain;
		System.out.println(this.email);
		
	}
//Private method donde procesamos el department del usuario
	private String setDepartment() {
		System.out.print("Choose your Department:\n1)Sales\n2)Development\n3)Accounting\n0)None\nAnswer: ");
		//Usamos scanner y lo definimos
		Scanner in= new Scanner(System.in);
		//inicializamos el depChoice para que coja el valor de la variable in de tipo scanner y decimos que recibirá un entero
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
	//Metodo privado para la creación de una random password 
	private String randomPassword(int length) {
		//definimos una variable donde definimos todos los caracteres que usaran nuestra password
		String passwordSet="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890@/()!";
		// definimos un array de caracteres que será igual de grande que el length
		char[] password=new char[length];
		//Bucle for para recorrer la string
		for(int i=0; i<length;i++) {
			//definimos una variable que guardara un valor entero y que será la posición de un caracter de la string
			//casteamos el resultado del math.random como (int) para despues poder pasarlo a la variable
			int ran=(int) (Math.random()*passwordSet.length());
			//guardamos en password en la posición [i]  hasta un máximo de length, cada caracter de la string 
			//que marque la variable ran que recibia un valor random es seleccionado estudiando cada caracter con el charAt(). 
			password[i]=passwordSet.charAt(ran);
		}
		System.out.println(password);
		//convertimos password a String ya que tenia formato char y teniamos que devolver una String
		return new String (password);
	}
	//set mail capacity 
	public void mailCapacity(int capacity) {
		this.emailBoxCapacity=capacity;
	}
	//Set alternate email
	public void alternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	//Change password method
	public void changePassword(String password) {
		this.password=password;
		
	}
	//Declarar los methodos get, serán los que utilizaremos para llamar los valores cambiados con los metodos set.
	//todo esto es encapsulacion y data binding. 
	public int getMailCapacity() {return emailBoxCapacity;	}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	//Show method, will be used to show all the user info
	public String showInfo() {
		return "User info: "+firstName+" "+lastName+"\nEmail: "+email;
	}




} 