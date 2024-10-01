package org.launchcode.skills_tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

    // Displays the following upon loading the page at localhost:8080
    @GetMapping
    public String skillsTrackerMain() {
        return "<html>" +
                "<head>" +
                "<title>CH 10 - Controllers - Studio - Skills Tracker</title>" +
                "</head>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }



    @GetMapping("form")
    public String skillsTrackerForm() {
        return "<html>" +
                "<body>" +
                "<form action='skillsTracker' method='post'>" +

                "<label for='name'>Name:</label>" +
                "<input type='text' name='name'>" + "<br>" +

                //Prints out First Favorite Language Selection
                "<label for='firstFavLang'>My favorite language:</label>" +
                "<select name='firstLanguage' id='first-lang-select'>" +
                "<option value='java'>Java</option>" +
                "<option value='javascript'>JavaScript</option>" +
                "<option value='python'>Python</option>" +
                "</select>" + "<br>" +

                //Prints out Second Favorite Language Selection
                "<label for='secondFavLang'>My second favorite language:</label>" +
                "<select name='secondLanguage' id='second-lang-select'>" +
                "<option value='java'>Java</option>" +
                "<option value='javascript'>JavaScript</option>" +
                "<option value='python'>Python</option>" +
                "</select>" + "<br>" +

                //Prints out Third Favorite Language Selection
                "<label for='thirdFavLang'>My third favorite language:</label>" +
                "<select name='thirdLanguage' id='third-lang-select'>" +
                "<option value='java'>Java</option>" +
                "<option value='javascript'>JavaScript</option>" +
                "<option value='python'>Python</option>" +
                "</select>" + "<br>" + "<br>" +

                "<input type='submit' value='Submit'>" +

                "</form>" +
                "</body>" +
                "</html>";
    }


    @RequestMapping(value="skillsTracker", method = RequestMethod.POST)
    public String favoriteLanguageResult(@RequestParam String name, @RequestParam String firstLanguage, @RequestParam String secondLanguage, @RequestParam String thirdLanguage) {

        return "<html>" +
                "<body>" +
                "<h1>" + name + "</h1>" + "<br>" +

                "<ol>" +
                "<li>" + languageMessage(firstLanguage) + "</li>" +
                "<li>" + languageMessage(secondLanguage) + "</li>" +
                "<li>" + languageMessage(thirdLanguage) + "</li>" +
                "</ol>" +

                "</body>" +
                "</html>";

    }


    public static String languageMessage(String skillsLanguage) {
        String programLanguage = "";

        if (skillsLanguage.equals("java")) {
            programLanguage = "Java";

        } else if (skillsLanguage.equals("javascript")) {
            programLanguage = "JavaScript";

        } else if (skillsLanguage.equals("python")) {
            programLanguage = "Python";
        }
        return programLanguage;
    }

}
