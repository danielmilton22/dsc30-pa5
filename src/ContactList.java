import java.util.*;

public class ContactList {

    Person person;
    ArrayList<Person> personArray;
    int nelems;
    HashMap<String, String>  hashStructure;

    // add
    public boolean createContact(Person person) {
        if (hashStructure.get(person) != null) {
            return false;
        }
        nelems++;
        int sizeCatcher = personArray.size();
        personArray.add(person);
        hashStructure.put(person.name, String.valueOf(sizeCatcher));
        return true;
    }

    // contains
    public boolean lookupContact(String name) {
        return false;
    }

    // search
    public Person getContact(String name) {
        return null;
    }

    // sorted heap?
    public Person[] getContactByRange(String start, String end) {
        return null;
    }

    // delete
    public boolean deleteContact(String name) {
        return true;
    }

    public int size() {
        return nelems;
    }

    // sort
    public String[] fetchAllNames() {
        return null;
    }

    // sort numbers and no duplicates
    public String[] fetchAllPhoneNumbers() {
        return null;
    }
}