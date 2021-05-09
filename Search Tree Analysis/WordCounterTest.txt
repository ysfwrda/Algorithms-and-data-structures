import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordCounterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordCounterTest
{
    /**
     * Default constructor for test class WordCounterTest
     */
    public WordCounterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddWord()
    {
        WordCounter wordCoun1 = new WordCounter();
        wordCoun1.addWord("a");
        wordCoun1.addWord("a");
        wordCoun1.addWord("b");
        HashSet<String> value= new HashSet<String>();
        value.add("a");
        value.add("b");
        HashSet<String> set = wordCoun1.getWords();
        assertEquals(set, value);
    }

    @Test
    public void testCalculateInverted()
    {
        WordCounter wordCoun1 = new WordCounter();
        wordCoun1.addWord("a");
        wordCoun1.addWord("a");
        wordCoun1.addWord("a");
        wordCoun1.addWord("b");
        wordCoun1.addWord("c");
        java.util.HashSet<java.lang.String> aSet = new java.util.HashSet<String>();
        assertEquals(true, aSet.add("a"));
        java.util.HashSet<java.lang.String> bcSet = new java.util.HashSet<String>();
        assertEquals(true, bcSet.add("b"));
        assertEquals(true, bcSet.add("c"));
        java.util.HashMap map = new java.util.HashMap<Integer,java.util.HashSet<String>>();
        assertEquals(null, map.put(1, bcSet));
        assertEquals(null, map.put(3, aSet));
        java.util.HashMap<java.lang.Integer,java.util.HashSet<java.lang.String>> hashMap1 = wordCoun1.calculateInverted();
        assertEquals(map, hashMap1);
    }
}

