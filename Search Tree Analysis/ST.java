import java.util.Iterator;
/**
 * Write a description of interface ST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ST<Key extends Comparable<Key>, Value>{
    void put(Key key, Value val);
    Value get(Key key);
    boolean contains(Key key);
    void remove(Key key);
    Iterator<Key> iterator();
}