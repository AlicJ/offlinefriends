package Model;

/**
 * Created by David on 2015-04-04.
 */
public class Person {
    String firstName;
    String lastName;

    public Person(){
		this.firstName = "";
        this.lastName = "";
	}

    public Person(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public void setFirstName(String first){
        firstName = first;
    }

    public void setLastName(String last){
        lastName = last;
    }
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}

    public int compareTo(String that){
        return this.toString().compareTo(that);
    }

    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
