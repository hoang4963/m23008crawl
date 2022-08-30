import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNew {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            try {
                Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                content = content.replaceAll("\\n+", "");
                Pattern p = Pattern.compile("<h3 class=\"article-title\">(.*?)<a href=\"(.*?)\">(.*?)</a>(.*?)</h3>");
                Matcher m = p.matcher(content);
                while (m.find()) {
                    System.out.println(m.group(3));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
