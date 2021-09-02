import org.junit.Test;

import java.util.ArrayList;

import org.junit.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class contactTesting {
    ArrayList<String> pn = new ArrayList<String>();
    ContactList contacts = new ContactList();
    Person person1 = new Person("Daniel", pn);
    Person person2 = new Person("Aria", pn);
    Person person3 = new Person("Brian", pn);
    Person person4 = new Person("Jessy", pn);
    Person person5 = new Person("Chris", pn);

    @Test
    public void personGetNameTest() {
        pn.add("3412343543");
        pn.add("34123435543");
        pn.add("3241253637");
        pn.add("7653545435");
        pn.add("1545675436");
        assertEquals("Daniel", person1.getName());
    }

    @Test
    public void personAddNumberTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(false, person1.addPhoneNumber("1545675436"));

    }

    @Test
    public void contactAddTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        contacts.createContact(person1);
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(false, contacts.createContact(person1));

    }

    @Test
    public void contactLookUpTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        contacts.createContact(person1);
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(true, contacts.lookupContact("Daniel"));
        assertEquals(false, contacts.lookupContact("Brian"));

    }

    @Test
    public void contactGetContactTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        contacts.createContact(person1);
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(null, contacts.getContact("Brian"));
        System.out.println(contacts.getContact("Daniel"));

    }

    @Test
    public void contactDeleteContactTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        contacts.createContact(person1);
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(true, contacts.deleteContact("Daniel"));
        assertEquals(false, contacts.deleteContact("Daniel"));

    }

    @Test
    public void contactSortTest() {
        person1.addPhoneNumber("3412343543");
        person1.addPhoneNumber("34123435543");
        person1.addPhoneNumber("3241253637");
        person1.addPhoneNumber("7653545435");
        person2.addPhoneNumber("3412343543");
        person2.addPhoneNumber("34123435543");
        person2.addPhoneNumber("3241253637");
        person2.addPhoneNumber("7653545435");
        contacts.createContact(person1);
        contacts.createContact(person2);
        assertEquals(true, person1.addPhoneNumber("1545675436"));
        assertEquals(2, contacts.fetchAllNames().length);

    }
}
