package modelview;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private Button button_signIn, button_signUp;

    @FXML
    private TextField textemail, textname, 
             textusername;

    @FXML
    private PasswordField pass1, pass2;
    
    static UserRecord userRecord;

    @FXML
    void handleButton_signIn(ActionEvent event) throws IOException {
        App.setRoot("signin.fxml");
    }

    @FXML
    void handleButton_signUp(ActionEvent event) throws IOException {
        
        if (pass1.getText() == null ? pass2.getText() != null : !pass1.getText().equals(pass2.getText())) {
            System.err.println("Passswords do not match");
        } else {
            CreateRequest request = new CreateRequest()
                .setDisplayName(textname.getText())
                .setEmail(textemail.getText())
                .setUid(textusername.getText())
                .setPassword(pass1.getText());

            try {
                userRecord = App.fauth.createUser(request);
                System.out.println("Successfully created new user: " + userRecord.getUid());
            } catch (FirebaseAuthException ex) {
                System.err.println("Info already taken or information incomplete");
            }

            handleButton_signIn(event);
        }
        
    }

}
