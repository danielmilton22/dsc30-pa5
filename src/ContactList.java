import java.util.*;

public class ContactList {

    Person person;

    public boolean createContact(Person person) {
        this.person = person;
        return false;
    }

    public boolean lookupContact(String name) {
        return false;
    }


    public Person getContact(String name) {
        return null;
    }


    public Person[] getContactByRange(String start, String end) {
        return null;
    }

    public boolean deleteContact(String name) {
        return true;
    }

    public int size() {
        return 42;
    }

    public String[] fetchAllNames() {
        return null;
    }

    public String[] fetchAllPhoneNumbers() {
        return null;
    }
}