package summary;

public class SummaryGenerator {

    public static String
    generateSummary(String text) {

        if (text.length() > 400) {

            return text.substring(0, 400)
                    + "...";
        }

        return text;
    }
}