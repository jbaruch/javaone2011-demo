package controllers;

import play.*;
import play.data.validation.Required;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        final List<Object> talks = Talk.all().fetch();
        render(talks);
    }

    public static void feedback(@Required Long talkId) {
        final Talk talk = Talk.findById(talkId);
        render(talk);
    }

    public static void postFeedback(
            Long talkId,
            String author,
            Rating content,
            Rating skills,
            Rating demos,
            Rating explanation,
            Rating depth,
            Rating overall,
            String comments
    ) {
        Talk talk = Talk.findById(talkId);
        Feedback feedback = new Feedback(author, content, skills, demos, explanation, depth, overall, comments, null);
        talk.addFeedback(feedback);
        talk.save();

        System.out.println(feedback);

        index();
    }
}