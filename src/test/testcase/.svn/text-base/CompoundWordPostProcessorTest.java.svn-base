package testcase;

import java.io.IOException;

import com.sun.image.codec.jpeg.TruncatedFileException;

import net.java.sen.StringTagger;
import net.java.sen.Token;
import net.java.sen.processor.CompoundWordPostProcessor;
import net.java.sen.processor.PostProcessor;
import junit.framework.TestCase;

public class CompoundWordPostProcessorTest extends TestCase {
    public static String TESTSTR = "新聞記者";
    static {
        System.setProperty("sen.home", ".");
    }
    public void testAnalyze() throws IllegalArgumentException, IOException {
        StringTagger tagger = StringTagger
                .getInstance("conf/sen-processor.xml");
        PostProcessor p = (PostProcessor) new CompoundWordPostProcessor(
                "dic/compound.sen");
        System.out.println(TESTSTR);
        tagger.addPostProcessor(p);
        Token[] token = tagger.analyze(TESTSTR);
	assertEquals("p=名詞-固有表現-職業", token[0].getAddInfo());
	assertEquals("新聞", token[0].toString());
	assertEquals("p=名詞-固有表現-職業", token[1].getAddInfo());
	assertEquals("記者", token[1].toString());
    }
}
