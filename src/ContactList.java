import java.util.*;

public class ContactList implements Iterable<Contact> {

    private class ArrayListIterator implements Iterator<Contact> {
        private int index;

        public ArrayListIterator() {
            index=0;
        }

        public boolean hasNext() {
            return index < size();
        }
        public Contact next() {
            index++;
            return arrayListOfContacts.get(index-1);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayList<Contact> arrayListOfContacts;

    public ContactList(){
        arrayListOfContacts = new ArrayList<>();
    }

    public ContactList(Contact[] contacts){
        Arrays.sort(contacts, new Comparator<Contact>() { // Sorting using sort(), using a comparator to sort by last name
            @Override
            public int compare(Contact contact, Contact t1) {
                return contact.getLastName().compareTo(t1.getLastName());
            }
        });
        arrayListOfContacts = new ArrayList<>(Arrays.asList(contacts)); // makes an array into an arraylist
    }

    public Contact findByLastName(String last) {
        Contact searchKey = new Contact(last,null);
        int index = Collections.binarySearch(arrayListOfContacts, searchKey, Contact::compareTo);
        return arrayListOfContacts.get(index);
    }
    // A method that searches for a Contact by phone number, and returns a reference to the Contact.
    public Contact findByPhoneNumber(String phone){
        Contact key = new Contact(null,phone); // creates a contact object to search through a binary search
        int index = Collections.binarySearch(arrayListOfContacts, key, Contact::compareToNum); // binary search returns index if found
        return arrayListOfContacts.get(index);
    }
    // A method that searches for and returns a ContactList containing all Contacts with a last name starting with a particular letter
    public ContactList findAllByLastInitial(char ch){
        ContactList listBySameInitial = new ContactList(); // Creates a new contactlist object
        for(Contact c: arrayListOfContacts){ // iterates through the arraylist
            if(c.getLastName().charAt(0) == ch){ // if the char matches the char parameter it adds it to the contactlist
                listBySameInitial.add(c);
            }
        }
        return listBySameInitial;
    }
    // A method that searches for and returns a ContactList containing all Contacts that live in a particular city
    public ContactList findAllByCity(String city){
        ContactList listBySameCity = new ContactList(); // creates a new contactlist object
        for (Contact c: arrayListOfContacts){ // iterates through the arraylist
            if(c.getCity().equals(city)){ // if the city is equal to the string parameter it adds it to the contactlist
                listBySameCity.add(c);
            }
        }
        return listBySameCity;
    }
    // A method that allows you to add a Contact to the ContactList in sorted order.
    public boolean add(Contact c){
        for(Contact a: arrayListOfContacts) { // iterates ArrayList
            if (a.compareTo(c) == 0) // if the new Contact is the same as the Contact in the ArrayList return false
                return false;
        }
        arrayListOfContacts.add(c); // adds new contact
        Collections.sort(this.arrayListOfContacts); // sorts the ArrayList
        return true;
    }
    // A method that returns the size of the ContactList.
    public int size(){
        return arrayListOfContacts.size();
    }
    // A method that allows you to remove and return a Contact from the ContactList.
    public Contact remove(Object obj){
        int index = arrayListOfContacts.indexOf(obj);
        arrayListOfContacts.remove(obj);
        return arrayListOfContacts.get(index);
    }
    // A method that allows the client to get a Contact from the ContactList by index.
    public Contact get(int index){
        if(index > size() || index < 0)
            throw new IndexOutOfBoundsException();
        return arrayListOfContacts.get(index);
    }

    public boolean equals(Object obj){
        return false;
    }

    public String toString(){
        return "";
    }

    @Override
    public Iterator<Contact> iterator() {
        return new ArrayListIterator();
    }

}
