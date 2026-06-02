package ats;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractor {

    static String[] skills = {

            "java",
            "mysql",
            "spring",
            "react",
            "python",
            "api",
            "html",
            "css",
            "jdbc",
            "swing",
            "git"
    };

    public static List<String>
    extractSkills(String text) {

        List<String> foundSkills =
                new ArrayList<>();

        text = text.toLowerCase();

        for (String skill : skills) {

            if (text.contains(skill)) {

                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }
}