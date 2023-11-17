import java.util.regex.Pattern;

public class Exercise11Logic {
    public String checkBrowser(String header) {
        var edgePattern = Pattern.compile("Edg\\/[0-9]+.{1,4}");
        var chromePattern = Pattern.compile("Chrome\\/[0-9]+.{1,4}");
        var operaPattern = Pattern.compile("OPR\\/[0-9]+.{1,4}");
        var edgeMatcher = edgePattern.matcher(header);
        var chromeMatcher = chromePattern.matcher(header);
        var operaMatcher = operaPattern.matcher(header);
        if (edgeMatcher.find()) {
            return "Hello Edge User";
        } else if (operaMatcher.find()) {
            return "Hello Opera User";
        } else if (chromeMatcher.find()) {
            return "Hello Chrome User";
        }
        return "Hello Unknown User";
    }
}
