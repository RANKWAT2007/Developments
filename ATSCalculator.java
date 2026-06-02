package ats;

import java.util.List;

public class ATSCalculator {

    public static int calculateScore(
            List<String> skills) {

        int score =
                skills.size() * 10;

        if (score > 100) {

            score = 100;
        }

        return score;
    }
}