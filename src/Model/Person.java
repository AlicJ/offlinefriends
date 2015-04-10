package Model;

/**
 * Created by David on 2015-04-04.
 */
public class Person implements Comparable<Person>{
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

	@Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

	@Override
	public int compareTo(Person that) {
		return this.toString().compareTo(that.toString());
	}
	
	public boolean equals(Person that){
		return this.toString().equals(that.toString());
	}
	
	public int compareToFirst(Person that) {
		return this.toString().compareTo(that.toString());
	}
	
	public int compareToLast(Person that) {
		return this.getLastName().compareTo(that.getLastName());
	}
}
