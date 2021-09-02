import java.util.*;

public class ContactList {

    private static final int R = 128;
    private Node root;
    int nelems;
    String start;
    String end;
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<Person> contactList = new ArrayList<Person>();
    ArrayList<String> numberList = new ArrayList<String>();

    // Node constructor
    private static class Node {
        boolean endOfWord;
        ContactList.Node brachChildren[];
        Person person;

        private Node() {
            endOfWord = false;
            brachChildren = new ContactList.Node[R];
            person = null;
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


    public Person[] getContactByRange(String start, String end) {
        this.start = start;
        this.end = end;
        fetchAllNamesHelper(root);
        Person[] personArray = contactList.toArray(new Person[contactList.size()]);
        return personArray;
    }

    public void fetchAllContactHelper(Node root){
        char s = start.charAt(0);
        char e = end.charAt(0);
            for (int i = s; i < e; i++) {
                if (root.brachChildren[i] == null) {
                    continue;
                }
                else {
                    if (root.brachChildren[i].endOfWord == true) {
                        contactList.add(root.brachChildren[i].person);
                        fetchAllContactHelper(root.brachChildren[i]);
                    } else {
                        fetchAllContactHelper(root.brachChildren[i]);
                    }
                }
            }
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
        fetchAllNamesHelper(root);
        String[] strArray = nameList.toArray(new String[nameList.size()]);
        return strArray;
    }

    // sort helper
    public void fetchAllNamesHelper(Node root){
        for (int i = 0; i < 127; i++) {
            if (root.brachChildren[i] == null) {
                continue;
            }
            else {
                if (root.brachChildren[i].endOfWord == true) {
                    nameList.add(root.brachChildren[i].person.name);
                    fetchAllNamesHelper(root.brachChildren[i]);
                } else {
                    fetchAllNamesHelper(root.brachChildren[i]);
                }
            }
        }
    }

    // sort numbers and no duplicates
    public String[] fetchAllPhoneNumbers() {
        fetchAllNumbersHelper(root);
        Collections.sort(numberList);
        String[] numArray = numberList.toArray(new String[numberList.size()]);
        return numArray;
    }

    public void fetchAllNumbersHelper(Node root){
        for (int i = 0; i < 127; i++) {
            if (root.brachChildren[i] == null) {
                continue;
            }
            else {
                if (root.brachChildren[i].endOfWord == true) {
                    numberList.addAll(root.brachChildren[i].person.pnArray);
                    fetchAllNamesHelper(root.brachChildren[i]);
                } else {
                    fetchAllNamesHelper(root.brachChildren[i]);
                }
            }
        }
    }
}