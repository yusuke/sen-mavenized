package testcase;

import java.io.IOException;

import net.java.sen.StringTagger;
import net.java.sen.Token;
import junit.framework.TestCase;

public class StringTaggerTest extends TestCase {
    public static String TESTSTR = "新聞とモーニング娘";
    static {
        System.setProperty("sen.home", ".");
    }
    public void testAnalyze() throws IllegalArgumentException, IOException {
        StringTagger tagger = StringTagger.getInstance();
        Token[] token = tagger.analyze(TESTSTR);
        assertEquals("新聞", token[0].getBasicString());
        assertEquals("名詞-一般", token[0].getPos());
        assertEquals("と", token[1].getBasicString());
        assertEquals("未知語", token[1].getPos());
        assertEquals("モーニング娘", token[2].getBasicString());
        assertEquals("名詞-固有名詞", token[2].getPos());
    }
}
