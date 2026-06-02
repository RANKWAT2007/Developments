package ai;

public class AIService {

    public static String summarize(
            String text) {

        if (text.length() > 300) {

            return text.substring(0, 300)
                    + "...";
        }

        return text;
    }
}