package controllers;

import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import play.*;
import play.data.validation.Match;
import play.data.validation.Required;
import play.db.jpa.JPABase;
import play.modules.search.Query;
import play.modules.search.Search;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
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

    public static void search(@Match("[\\w]*")String searchPhrase, String track, String category) {
        if (StringUtils.isEmpty(searchPhrase) && StringUtils.isEmpty(track) && StringUtils.isEmpty(category)) {
            index();
        }
        final Query query = Search.search("title:"+searchPhrase, Talk.class);
        List<Talk> results;
        if (StringUtils.isNotEmpty(searchPhrase)) {
            results = query.fetch();
        } else {
            results = Talk.all().fetch();
        }
        List<Talk> talks;
        if (StringUtils.isNotEmpty(track) || StringUtils.isNotEmpty(category)) {
            talks = new ArrayList<Talk>(results.size());
            for (Talk talk : results) {
                if ((StringUtils.isEmpty(track) || talk.track.equals(track)) &&
                        (StringUtils.isEmpty(category) || talk.category.equals(category))) {
                    talks.add(talk);
                }
            }
        } else {
            talks = results;
        }

        render("Application/index.html", talks);
    }
}