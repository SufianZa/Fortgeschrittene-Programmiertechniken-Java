package View;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;


/**
 * Created by Sufian Vaio on 17.01.2017.
 */
public class ViewLogin extends Stage {
    public static final String CANCEL_BUTTON ="cancelButton";
    public static final String LOGIN_BUTTON = "loginButton";

    private TextField usernameField;
    private PasswordField passwordField;
    private ButtonType loginButtonType;

    Button loginBt;
    Button cancelBt;

    Optional<Pair<String, String>> result;

    public ViewLogin() {
        this.setTitle("Login Dialog");

        cancelBt  = new Button("Abbrechen");
        cancelBt.setId(CANCEL_BUTTON);

        loginBt = new Button("Login");
        loginBt.setId(LOGIN_BUTTON);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginBt, 0, 2);
        grid.add(cancelBt, 1, 2);

        Scene scene = new Scene(grid);
        this.setScene(scene);
        this.show();

        Platform.runLater(() -> {
        });
    }

    public String getName() {
        return usernameField.getText();
    }

    public String getPass() {
        return passwordField.getText();
    }

    public void addEventHandler(EventHandler<ActionEvent> eventHandler) {
        loginBt.addEventHandler(ActionEvent.ACTION, eventHandler);
        cancelBt.addEventHandler(ActionEvent.ACTION, eventHandler);
    }
}
