package com.example.application.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("/register")

public class RegistrationView extends VerticalLayout {
    TextField nameTextInput = new TextField("Name");
    PasswordField passwordField = new PasswordField("Passwort");
    TextField descriptionInput = new TextField("Beschreibung");
    Select<String> select = new Select<>();

    private String unternhemen;
    private boolean isStudent = false;

    private String name;
    private String password;
    private String description;
    private int matrkl;
    private String location;

    public RegistrationView() {


        setMargin(false);
        setPadding(false);
        setSizeFull();
        setAlignItems(Alignment.CENTER);

        //Logo
        HorizontalLayout logo = new HorizontalLayout();
        logo.setWidthFull();
        logo.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN); // Verteilt Logo und Buttons auf beide Seiten
        logo.setAlignItems(FlexComponent.Alignment.CENTER); // Vertikal zentrieren
        logo.getElement().getStyle().set("background-color", "#899499");

        Image logoImage = new Image("https://via.placeholder.com/150", "Logo");
        logoImage.setWidth("50px");
        logo.add(logoImage);

        add(logo);

        //Eingabefeld für den Namen
        nameTextInput.setWidth("30%");
        nameTextInput.getStyle().set("--vaadin-input-field-border-width", "1px");
        nameTextInput.getStyle().set("--lumo-text-field-size", "10px");
        add(nameTextInput);

        //Eingabefeld für das Passwort
        passwordField.setWidth("30%");
        passwordField.getStyle().set("--vaadin-input-field-border-width", "1px");
        passwordField.getStyle().set("--lumo-text-field-size", "10px");

        add(passwordField);

        //Eingabefeld für die Beschreibung
        descriptionInput.setWidth("50%");
        descriptionInput.getStyle().set("--vaadin-input-field-border-width", "1px");
        descriptionInput.getStyle().set("--lumo-text-field-size", "15vh");

        add(descriptionInput);

        //Drop down button um Art des Accounts einzustellen
        select.setLabel("Art des Accounts");
        select.setItems("Student", "Unternehmen");
        select.setValue("Account");
        HorizontalLayout dropdown = new HorizontalLayout();
        dropdown.setWidthFull();
        dropdown.setJustifyContentMode(JustifyContentMode.CENTER);
        dropdown.setAlignItems(FlexComponent.Alignment.CENTER);

        //button zum registrieren
        Button registerButton = new Button("Register");

        select.addValueChangeListener(e ->
        {
            remove(dropdown);
            dropdown.removeAll();
            //Eingabefeld für den Namen
            TextField matrikelnummer = new TextField(e.getValue().equals("Student") ? "Matrikelnummer" : "Unternehmensname");
            matrikelnummer.setWidth("30%");
            matrikelnummer.getStyle().set("--vaadin-input-field-border-width", "1px");
            matrikelnummer.getStyle().set("--lumo-text-field-size", "10px");

            //standort text feld
            TextField standort = new TextField(e.getValue().equals("Student") ? "Hochschule" : "Unternehmenssitz");


            standort.setWidth("30%");
            standort.getStyle().set("--vaadin-input-field-border-width", "1px");
            standort.getStyle().set("--lumo-text-field-size", "10px");
            standort.setPrefixComponent(VaadinIcon.MAP_MARKER.create());
            dropdown.add(matrikelnummer, standort);
            location = standort.getValue();
            registerButton.addClickListener(event ->{
                isStudent = e.getValue().equals("Student");
                if(isStudent) {
                    matrkl = Integer.parseInt(matrikelnummer.getValue());
                }{
                    unternhemen =matrikelnummer.getValue();
                }
                saveData(registerButton);
            });
            

            remove(registerButton);
            add(dropdown);
            add(registerButton);

        });

        add(select);



    }
    public void saveData(Button registerButton) {
        name = nameTextInput.getValue();
        password = passwordField.getValue();
        description = descriptionInput.getValue();

        System.out.println(unternhemen + name + password + description);
        // Hier jetzt schnittstelle zum anderen code wo der Benutzer erstellt wird
        registerButton.getUI().ifPresent(ui -> ui.navigate("dashbord"));
    }

}

