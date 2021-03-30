// Jeffrey Lopez

public class MainClass {
    public static void main(String[] args) {
        // Creates contacts
        Contact one = new Contact("John","Zrook","(718) 111-1111","7663 Nicolls Dr.","Butte","MT");
        Contact two = new Contact("Ellen","Bree","(317)-295-2723","2900 Bedford Avenue","Brooklyn","NY");
        Contact three = new Contact("Ellen","Mcgee","(630)-404-8901","7840 Livingston Ave.","Munice","IN");
        Contact four = new Contact("Wallace","Goodman","(803)-622-7511","7240 Cedar Swamp Ave.","New Britain","CT");
        Contact[] emptyArr = {one,two,three,four}; // Creates an array of contacts

        ContactList contacts = new ContactList(emptyArr); // Creates an ContactList object with the array as a parameter

        // Prints the contacts
        for(Contact c: contacts)
            System.out.println(c + "\n");

        // Creates 2 more contacts and adds them to the ArrayList in the ContactList object
        Contact five = new Contact("Daryl","Tate","(440)-803-1054","433 Bayport St.","Munice","IN");
        Contact six = new Contact("Steve","Sandoval","(773)-850-4115","8786 Railroad Dr.","Savannah","GA");
        addContact(contacts,five);
        addContact(contacts,six);

        // looks for 2 last names, one in the contacts and another that isn't in the contacts
        findByLast(contacts, "Tate");
        findByLast(contacts, "James");

        // looks for 2 phone numbers, one in the contacts and another that isn't in the contacts
        findByNumber(contacts, "(614)-901-6984");
        findByNumber(contacts, "(630)-404-8901");

        System.out.println();

        findByLastInitial(contacts,'B');
        findByLastInitial(contacts,'D');
        Contact seven = new Contact("Steve","Sandoval","(773)-850-4115","8786 Railroad Dr.","Savannah","GA");
        addContact(contacts,seven);
        Contact eight = new Contact("Kimberly", "Silva","(760)-966-5227","9371 Bayport St.","Abingdon","MD");
        addContact(contacts,eight);
        findByLastInitial(contacts,'S');

        findByCity(contacts,"Munice");
        // Prints final arraylist
        System.out.println("Final ArrayList: ");
        for(Contact c: contacts)
            System.out.println(c + "\n");

    }
    public static void addContact(ContactList contact,Contact c){
        if(!contact.add(c)){
            System.out.println("Can't add duplicate contacts" + "\n");
        }
    }
    // method that calls the findByLastName method in the ContactList class or catches exceptions
    public static void findByLast(ContactList contacts, String last){
        try{
            System.out.println(contacts.findByLastName(last)+ "\n");
        }catch (Exception e){
            System.out.println("Last name " + last +" was not found" +"\n");
        }
    }
    // method that calls findByPhoneNumber in the ContactList class or catches exceptions
    public static void findByNumber(ContactList contacts, String number){
        try{
            System.out.println(contacts.findByPhoneNumber(number));
        }catch (Exception e){
            System.out.println("Phone number: " + number +" was not found" +"\n");
        }
    }
    // method that calls findAllByLastInitial in the ContactList class receives an ArrayList with contacts of same last intial
    public static void findByLastInitial(ContactList contacts, char c){
        ContactList g = contacts.findAllByLastInitial(c);
        if(g.size() == 0)
            System.out.println("No last names with initial " + c + "\n");
        else
            for(Contact d: g)
                System.out.println(d + "\n");
    }
    // method that calls findByAllCity, receives an ArrayList with contacts of same city
    public static void findByCity(ContactList contacts, String city){
        ContactList g = contacts.findAllByCity(city);
        if(g.size() == 0)
            System.out.println("No contacts with city " + city + "\n");
        else
            for(Contact d: g)
                System.out.println(d + "\n");
    }

}
