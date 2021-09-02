import java.util.*;

public class ContactList {

    int nelems;
    TrieTree trieTree;
    // add

    public ContactList() {
        this.trieTree = new TrieTree();
    }

    public boolean createContact(Person person) {
        nelems++;
        return trieTree.insert(person);
    }

    // contains
    public boolean lookupContact(String name) {
        boolean search = trieTree.search(name);
        return search;
    }

    // search
    public Person getContact(String name) {
        Person getContact = trieTree.get(name);
        return getContact;
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