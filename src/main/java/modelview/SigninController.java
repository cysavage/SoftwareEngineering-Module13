package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SigninController {

    @FXML
    private Button button_signIn, button_signUp;

    @FXML
    private TextField textusername;
    
    @FXML
    private PasswordField textpassword;
    
    static UserRecord currentUser;

    @FXML
    void Button_signIn(ActionEvent event) throws IOException {
        try {
            String username = textusername.getText();
            String password = textpassword.getText();
            
            currentUser = FirebaseAuth.getInstance().getUser(username);
            App.setRoot("AccessFBView.fxml");
            
        } catch (FirebaseAuthException | IllegalArgumentException ex) {
            System.err.println("Username does not exist or incomplete information");
        }
    }

    @FXML
    void Button_signUp(ActionEvent event) throws IOException {
        App.setRoot("signup.fxml");
    }

}
