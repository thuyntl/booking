package booking.questios;

import booking.EmailUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

public class VerificationMailAfterRegister implements Question<Boolean> {
    public static VerificationMailAfterRegister getVerificationMail() {
        return new VerificationMailAfterRegister();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Message> verifyMailResult = new ArrayList<Message>();
        EmailUtils emailUtils = new EmailUtils();
        try {
            Message[] messagesFromInbox = emailUtils.getVerificationMessage("INBOX", true, 1);
            if (messagesFromInbox.length != 0) {
                verifyMailResult.add(messagesFromInbox[0]);
            } else {
                Message[] messagesFromSpam = emailUtils.getVerificationMessage("SPAM", true, 1);
                if (messagesFromSpam.length != 0)
                    verifyMailResult.add(messagesFromSpam[0]);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        if(verifyMailResult.size() > 0)
            return true;
        else
            return false;
        //return verifyMailResult.toArray(new Message[]{});
    }
}
