package com.example.application.views;


import com.example.application.Authentication.Authenticator;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@CssImport("./styles/DashbordCss.css")
@Route("job-erstellung")
public class JobErstellung extends VerticalLayout implements BeforeEnterObserver {
    private Authenticator authentication = Authenticator.getInstance();
    private boolean isLoggedIn = authentication.isAuthenticated();
    public JobErstellung() {

        setSizeFull();
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        //Logo
        HorizontalLayout logo = new HorizontalLayout();
        logo.setWidthFull();
        logo.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN); // Verteilt Logo und Buttons auf beide Seiten
        logo.setAlignItems(FlexComponent.Alignment.CENTER); // Vertikal zentrieren
        logo.getElement().getStyle().set("background-color", "#899499");

        Image logoImage = new Image("https://via.placeholder.com/150", "Logo");
        logoImage.setWidth("50px");
        logo.add(logoImage);

        //Textinput für den Jobnamen
        TextArea jobName = new TextArea();
        jobName.setPlaceholder("Job Name");
        jobName.getElement().getStyle().set("margin-top","3%");
        jobName.setMaxHeight("400px");
        jobName.setAutoselect(true);

        // Füge ein Inline-Styles hinzu, um zu verhindern, dass eine Scrollbar erscheint
        jobName.getElement().getStyle().set("resize", "none");
        jobName.getElement().getStyle().set("overflow", "hidden");

        // Hier fügen wir ein wenig JavaScript hinzu, um die Höhe dynamisch anzupassen
        jobName.getElement().executeJs(
                "this.addEventListener('input', function() {" +
                        "    this.style.height = 'auto';" + // Setzt die Höhe auf "auto", um die Höhe neu zu berechnen
                        "    this.style.height = (this.scrollHeight) + 'px';" + // Setzt die Höhe basierend auf der scrollHöhe
                        "});"
        );

        TextArea jobDescription = new TextArea();
        jobDescription.setPlaceholder("Jobbeschreibung");
        jobDescription.setWidth("50%");
        jobDescription.setHeight("100px");
        jobDescription.setMaxHeight("400px");
        jobDescription.setAutoselect(true);

        // Füge ein Inline-Styles hinzu, um zu verhindern, dass eine Scrollbar erscheint
        jobDescription.getElement().getStyle().set("resize", "none");
        jobDescription.getElement().getStyle().set("overflow", "hidden");

        // Hier fügen wir ein wenig JavaScript hinzu, um die Höhe dynamisch anzupassen
        jobDescription.getElement().executeJs(
                "this.addEventListener('input', function() {" +
                        "    this.style.height = 'auto';" + // Setzt die Höhe auf "auto", um die Höhe neu zu berechnen
                        "    this.style.height = (this.scrollHeight) + 'px';" + // Setzt die Höhe basierend auf der scrollHöhe
                        "});"
        );

        add(logo, jobName, jobDescription);

        Button createButton = new Button("Erstelle Job");

        add(createButton);

    }
    //Wenn der Benutzer nicht eingeloggt ist darf er hier nicht hin, also schicken wir in zurrück zum login Screen
    public void beforeEnter(BeforeEnterEvent event){
        if(!isLoggedIn) event.forwardTo("login");
    }
}
