import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Whitelist;

import javax.swing.text.html.CSS;

public class JsoupTest {
    public static void main(String args[]) {
        //case 1, Parser relation is mixed
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Parser xmlParser = Parser.xmlParser();
        xmlParser.parse(html, "http://example.com");
        Parser htmlParser = Parser.htmlParser();
        htmlParser.parseXmlFragment(html, "http://example.com");

        //case 2
        String parseResult = Jsoup.clean(html, new Whitelist());
        //Jsoup.parse(.., filter);

        //case 3. every child of WhiteList is a shabby factory
        class MyWhiteList extends Whitelist {

        }
        Whitelist aWList = MyWhiteList.basic();
    }
}
