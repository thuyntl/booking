package booking;

import org.codehaus.groovy.runtime.wrappers.IntWrapper;
import org.jruby.RubyProcess;

import javax.mail.*;
import javax.mail.search.SubjectTerm;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EmailUtils {

    private Folder folder;

    public Message[] getVerificationMessage (String folderInteractWith, boolean unreadOnly, int maxToGet) throws MessagingException {

        /* Connects to email server with credentials provided to read from a given folder of the email application*/
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/test/resources/email.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Connect to mail server with email information getting from properties*/
        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");
        store.connect(System.getProperty("email.address"), System.getProperty("email.password"), System.getProperty("mail.smtp.host"));

        /* Open folder which mail application interact with */
        folder = store.getFolder(folderInteractWith);
        folder.open(Folder.READ_WRITE);

        /* Get verification message */
        Message[] messages = getMessagesBySubject(System.getProperty("email.verification.subject"), unreadOnly, maxToGet);
        return messages;
    }

    /** Get message by subject term
     * @param maxToGet maximum number of messages to get, starting from the latest. For example, enter 100 to get the last 100 messages received.
     */
    public Message[] getMessagesBySubject(String subject, boolean unreadOnly, int maxToGet) throws MessagingException {
        int endIndex = folder.getMessageCount();
        int startIndex = endIndex - maxToGet;
        Message[] messages = folder.search(new SubjectTerm(subject), folder.getMessages(startIndex, endIndex));
        if(unreadOnly) {
            List<Message> unreadMessages = new ArrayList<Message>();
            for(Message message : messages) {
                if (!message.isSet(Flags.Flag.SEEN)) {
                    unreadMessages.add(message);
                }
            }
            messages = unreadMessages.toArray(new Message[]{});
        }
        return messages;
    }

}
