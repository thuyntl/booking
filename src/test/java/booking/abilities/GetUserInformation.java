package booking.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetUserInformation implements Ability {
    public String email;
    public String password;

    public GetUserInformation(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static GetUserInformation getUserInfo() {
        FileReader reader = null;
        Properties properties = null;
        try {
            reader = new FileReader("src/test/resources/UserInfor.properties");
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GetUserInformation(properties.getProperty("Email"), properties.getProperty("Password"));
    }

    public static GetUserInformation as(Actor actor) {
        return actor.abilityTo(GetUserInformation.class);
    }
}
