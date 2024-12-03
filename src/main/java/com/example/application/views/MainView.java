package com.example.application.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H1;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        setMargin(false);
        setPadding(false);
        setSizeFull();  // Layout füllt den gesamten Bildschirm

        // Erstelle den Header (Logo + Buttons)
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setWidthFull(); // Header soll die gesamte Breite einnehmen
        headerLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN); // Verteilt Logo und Buttons auf beide Seiten
        headerLayout.setAlignItems(FlexComponent.Alignment.CENTER); // Vertikal zentrieren
        headerLayout.getElement().getStyle().set("background-color", "#899499");

        // Logo links
        Image logo = new Image("https://via.placeholder.com/150", "Logo"); // Beispiel-Link zum Logo
        logo.setWidth("50px"); // Logo-Größe festlegen

        // Buttons für die Anmeldung rechts
        HorizontalLayout anmeldung = new HorizontalLayout();
        anmeldung.setSpacing(true);
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        loginButton.getElement().getStyle().set("color", "white");
        registerButton.getElement().getStyle().set("color", "white");
        anmeldung.add(loginButton, registerButton);
        anmeldung.setAlignItems(FlexComponent.Alignment.CENTER); // Buttons vertikal zentrieren

        loginButton.addClickListener(e -> loginButton.getUI().ifPresent(ui -> ui.navigate("login"))
        );
        registerButton.addClickListener(e -> registerButton.getUI().ifPresent(ui -> ui.navigate("register"))
        );
        // Füge Logo und Buttons zum Header hinzu
        headerLayout.add(logo, anmeldung);

        // Füge den Header zum Layout hinzu
        add(headerLayout);

        // Zentrale Landing Page
        VerticalLayout landing = new VerticalLayout();
        landing.setSpacing(true);
        landing.setAlignItems(FlexComponent.Alignment.CENTER); // Text zentrieren

        // Hauptüberschrift
        H1 h1 = new H1("AwesomeSoftware");

        // Textfeld in der Mitte
        Div landingDiv = new Div();
        landingDiv.getElement().setProperty("innerHTML", "Willkommen Bei AwesomeSoftware das ist die Landing Page mit <br> extrem coolem Text");
        landingDiv.getElement().getStyle().set("font-size", "20px");
        landingDiv.getElement().getStyle().set("border", "groove");
        landingDiv.getElement().getStyle().set("border-radius", "5px");
        landingDiv.getElement().getStyle().set("padding", "10px");

        // Füge die Komponenten zur Landing Page hinzu
        landing.add(h1);
        landing.add(landingDiv);

        // Füge die Landing Page zum Layout hinzu
        add(landing);


    }
}
