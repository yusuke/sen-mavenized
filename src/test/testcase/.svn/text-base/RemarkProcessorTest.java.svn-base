package testcase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import net.java.sen.StringTagger;
import net.java.sen.Token;
import net.java.sen.processor.RemarkPostProcessor;
import net.java.sen.processor.RemarkPreProcessor;
import junit.framework.TestCase;

public class RemarkProcessorTest extends TestCase {
    public static String TESTSTR = "before&lt;コメント&gt;after";

    static {
        System.setProperty("sen.home", ".");
    }
    public void testAnalyze() throws IllegalArgumentException, IOException {
        StringTagger tagger = StringTagger
                .getInstance("conf/sen-processor.xml");
        RemarkPostProcessor remarkPostPr = new RemarkPostProcessor();
        RemarkPreProcessor remarkPrePr = new RemarkPreProcessor();
        remarkPrePr.readRules(new BufferedReader(new StringReader("&lt; &gt; 記号-注釈")));
        tagger.addPostProcessor(remarkPostPr);
        tagger.addPreProcessor(remarkPrePr);
       
        Token[] token = tagger.analyze(TESTSTR);
        assertEquals(token[0].toString(),"before");
        
        assertEquals("&lt;コメント&gt;", token[1].toString());
        assertEquals(6, token[1].start());
        assertEquals(18, token[1].end());
        assertEquals("記号-注釈", token[1].getPos());
        
        assertEquals("after",token[2].toString());
        assertEquals(18,token[2].start());
        assertEquals(23,token[2].end());
        /*
        System.out.println("--------");
        for (int i = 0; i < token.length; i++) {
            System.out.println("="+token[i].toString()+":"+token[i].getPos()+token[i].start()+":"+token[i].end());
        }
	*/

    }
}
