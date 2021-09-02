import java.util.*;

public class ContactList {

    private static final int R = 128;
    private Node root;
    int nelems;

    // Node constructor
    private static class Node {
        boolean endOfWord;
        ContactList.Node brachChildren[];
        Person person;

        private Node() {
            endOfWord = false;
            brachChildren = new ContactList.Node[R];
        }
    }

    public ContactList() {
        nelems = 0;
        root = new Node();
    }

    public boolean createContact(Person person) {
        Node nodeHolder = root;
        for (char c: person.name.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                nodeHolder.brachChildren[(int) c] = new Node();
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        if (nodeHolder.endOfWord == true){
            return false;
        } else {
            nelems++;
            nodeHolder.endOfWord = true;
            nodeHolder.person = person;
            return true;
        }
    }

    // contains
    public boolean lookupContact(String name) {
        Node nodeHolder = root;
        for (char c: name.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                return false;
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        return true;
    }

    // search
    public Person getContact(String name) {
        Node nodeHolder = root;
        for (char c: name.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                return null;
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        return nodeHolder.person;
    }

    // sorted heap?
    public Person[] getContactByRange(String start, String end) {
        return null;
    }

    // delete
    public boolean deleteContact(String name) {
        char deleteHolder = 'a';
        Node parent = root;
        Node delete = null;
        if (name.length() == 0 || name == null) {
            return false;
        }
        for (char c: name.toCharArray()) {
            Node child = parent.brachChildren[(int) c];
            if (parent.brachChildren.length > 1 || parent.endOfWord) {
                delete = parent;
                deleteHolder = c;
            }
            if (child == null) {
                return false;
            }
            parent = child;
        }
        if (parent.endOfWord == false) {
            return false;
        }
        if (parent.brachChildren.length == 0) {
            delete.brachChildren[(int) deleteHolder] = null;
        } else {
            parent.endOfWord = false;
        }
        nelems--;
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