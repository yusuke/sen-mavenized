package testcase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import net.java.sen.StringTagger;
import net.java.sen.Token;
import net.java.sen.processor.CompositPostProcessor;
import junit.framework.TestCase;

public class CompositPostProcessorTest extends TestCase {
    public static String TESTSTR = "£±£²£³£´£³";
    static {
        System.setProperty("sen.home", ".");
    }
    public void testAnalyze() throws IllegalArgumentException, IOException {
        StringTagger tagger = StringTagger
                .getInstance("conf/sen-processor.xml");
        CompositPostProcessor p = new CompositPostProcessor();
        p.readRules(new BufferedReader(new StringReader("Ì¾»ì-¿ôµ­¹æ Ì¾»ì-¿ô Ì¾»ì-¿ô")));
        
        tagger.addPostProcessor(p);
        Token[] token = tagger.analyze(TESTSTR);
        assertEquals(token[0].getPos(),"Ì¾»ì-¿ôµ­¹æ");
    }
}