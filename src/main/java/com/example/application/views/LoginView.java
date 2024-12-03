package com.example.application.views;


import com.example.application.Authentication.Authenticator;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@Route("login")
public class LoginView extends VerticalLayout {
    Authenticator authenticator = Authenticator.getInstance();

    public LoginView() {
        setSizeFull();
        setSpacing(false);
        setPadding(false);
        setAlignItems(Alignment.CENTER);

        // Logo hinzufügen
        HorizontalLayout logo = new HorizontalLayout();
        logo.setWidthFull();
        logo.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN); // Verteilt Logo und Buttons auf beide Seiten
        logo.setAlignItems(FlexComponent.Alignment.CENTER); // Vertikal zentrieren
        logo.getElement().getStyle().set("background-color", "#899499");

        Image logoImage = new Image("https://via.placeholder.com/150", "Logo");
        logoImage.setWidth("50px");
        logo.add(logoImage);
        add(logo);

        // Vaading login formular
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();

        i18nForm.setUsername("Name");
        i18nForm.setPassword("Passwort");
        i18nForm.setSubmit("Anmelden");
        i18nForm.setForgotPassword("Passwort vergessen?");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();

        i18nErrorMessage.setMessage(
                "Daten stimmen nicht überein");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);

        add(loginForm);
        //Event Listener der sich die Daten vom Login zieht
        loginForm.addLoginListener(event -> handleLoginEvent(event));

    }
    public void handleLoginEvent(AbstractLogin.LoginEvent loginEvent) {
        String username = loginEvent.getUsername();
        String password = loginEvent.getPassword();
        System.out.println(username);
        //ToDo: Hier mit der Datenbank abgleichen ob es stimmt
        authenticator.Authenticate(username, password);

    }
}
