package booking.questios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultForBooking implements Question<Integer> {
    public static SearchResultForBooking totalRoom() {
        return new SearchResultForBooking();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        Target resultTotal = Target.the("result count")
                .locatedBy("//div[@data-block-id=\"heading\"]//h1");
        String totalValue = Text.of(resultTotal).viewedBy(actor).resolve();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(totalValue);
        int totalRoom = 0;
        if (matcher.find()) {
            totalRoom = Integer.parseInt(matcher.group(0));
        }
        return totalRoom;
    }
}
