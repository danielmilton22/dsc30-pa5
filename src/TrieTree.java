import java.util.*;

public class TrieTree {
    private static final int R = 128;
    private Node root;

    private static class Node {
        boolean endOfWord;
        Node brachChildren[];
        Person person;

        private Node() {
            endOfWord = false;
            brachChildren = new Node[R];
        }

    }

    public TrieTree() {
        root = new Node();
    }

    public boolean insert(Person p) {
        Node nodeHolder = root;
        for (char c: p.name.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                nodeHolder.brachChildren[(int) c] = new Node();
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        if (nodeHolder.endOfWord == true){
            return false;
        } else {
            nodeHolder.endOfWord = true;
            nodeHolder.person = p;
            return true;
        }
    }

    public boolean search(String s) {
        Node nodeHolder = root;
        for (char c: s.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                return false;
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        return true;
    }

    public Person get(String s) {
        Node nodeHolder = root;
        for (char c: s.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                return nodeHolder.person;
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        return nodeHolder.person;
    }

    public void remove(String s) {
        Node nodeHolder = root;
        for (char c: s.toCharArray()) {
            if (nodeHolder.brachChildren[(int) c] == null) {
                nodeHolder.brachChildren[(int) c] = new Node();
            }
            nodeHolder = nodeHolder.brachChildren[(int) c];
        }
        nodeHolder.endOfWord = true;
    }
}
