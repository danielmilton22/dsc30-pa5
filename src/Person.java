import java.util.*;

public class Person {

    String name;
    ArrayList<String> pnArray;

    public Person(String name, ArrayList<String> pnArray) {
        this.name = name;
        this.pnArray = pnArray;
    }

    public String getName() {
        return name;
    }

    public boolean addPhoneNumber(String pn) {
        if (pnArray.contains(pn)){
            return false;
        }
        pnArray.add(pn);
        return true;
    }

    public ArrayList<String> getPhoneNumbers() {
        Collections.sort(pnArray);
        return pnArray;
    }

    public boolean deletePhoneNumber(String pn) {
        if (pnArray.size() < 1) {
            throw new IllegalArgumentException();
        }
        if (pnArray.contains(pn)){
            pnArray.remove(pn);
            return true;
        }
        return false;
    }
}
