package academy.kovalevskyi.algorithms.week2.day2;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class WikiScrapper {
  private String url;
  private Document doc;

  private WikiScrapper() {
  }

  public String getUrl() {
    return url;
  }

  public static WikiScrapper generateScrapper(String page) throws IOException {
    var wikiScrapper = new WikiScrapper();
    wikiScrapper.url = page;
    wikiScrapper.doc = Jsoup.connect(wikiScrapper.url).get();
    return wikiScrapper;
  }

  public Date lastEditedOnDate() throws ParseException {
    Element element = doc.select("footer").first();
    String find = "This page was last edited on ";
    if (!(element != null && element.text().contains(find))) {
      throw new ParseException("", 0);
    }
    String strDate = element.text().substring(find.length(), find.length() + 22);
    strDate = strDate.substring(0, 12) + strDate.substring(16);
    return new Date(strDate);
  }
}
