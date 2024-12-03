package com.example.application.views;
import com.example.application.Authentication.Authenticator;
import com.vaadin.flow.component.Key;
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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@CssImport("./styles/DashbordCss.css")
@Route("dashbord")

public class DashbordView extends VerticalLayout implements BeforeEnterObserver {
    private Authenticator authentication = Authenticator.getInstance();
    private boolean isLoggedIn = authentication.isAuthenticated();
    public DashbordView() {

            setSizeFull();
            setSpacing(false);
            setMargin(false);
            setPadding(false);
            setAlignItems(Alignment.CENTER);

            //Logo
            HorizontalLayout logo = new HorizontalLayout();
            logo.setWidthFull();
            logo.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN); // Verteilt Logo und Buttons auf beide Seiten
            logo.setAlignItems(FlexComponent.Alignment.CENTER); // Vertikal zentrieren
            logo.getElement().getStyle().set("background-color", "#899499");

            Image logoImage = new Image("https://via.placeholder.com/150", "Logo");
            logoImage.setWidth("50px");

            // Button um Jobs zu sehen
            Button jobButton = new Button("Jobs");
            logo.add(logoImage, jobButton);
            jobButton.getElement().getStyle().set("color", "white");
            jobButton.addClickListener(e -> {
                redirect("jobs", jobButton);

            });

            //Button um Nachrichten zu sehen
            Button nachrichtButton = new Button("Benachrichtigung");
            nachrichtButton.getElement().getStyle().set("color", "white");
            nachrichtButton.addClickListener(e -> {
                nachrichtButton.getUI().ifPresent(ui -> ui.navigate("nachrichten"));
            });

            //Button um Nachrichten zu sehen
            Button profilButton = new Button("Profil");
            profilButton.getElement().getStyle().set("color", "white");
            profilButton.addClickListener(e -> nachrichtButton.getUI().ifPresent(ui -> ui.navigate("profil")));

            logo.add(logoImage, jobButton, nachrichtButton, profilButton);
            jobButton.getElement().getStyle().set("color", "white");

            //Filterleiste
            HorizontalLayout filterBar = new HorizontalLayout();
            filterBar.setWidth("70%");
            filterBar.getElement().getStyle().set("margin-top", "10vh");
            filterBar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
            filterBar.setAlignItems(FlexComponent.Alignment.CENTER);


            Button addStelleButton = new Button("Neues Stelenangebot hinzufügen");
            addStelleButton.addClickListener(e -> addStelleButton.getUI().ifPresent(ui -> ui.navigate("job-erstellung")));

            //Cluster der Beiden Button links für Kategorie und Standort
            HorizontalLayout filterCluster = new HorizontalLayout();
            filterCluster.setAlignItems(FlexComponent.Alignment.CENTER);

            Select<String> kategorieAuswahl = new Select<>();
            kategorieAuswahl.setPlaceholder("Kategorie");
            kategorieAuswahl.setItems("plaheolder1", "plaheolder2", "plaheolder3", "plaheolder4");

            Select<String> standortAuswahl = new Select<>();
            standortAuswahl.setPlaceholder("Standort");
            standortAuswahl.setItems("plaheolder1", "plaheolder2", "plaheolder3", "plaheolder4");

            filterCluster.add(kategorieAuswahl, standortAuswahl);
            filterBar.add(addStelleButton, filterCluster);

            add(logo, filterBar);

            Div empfohleneUnternehmen = new Div();
            empfohleneUnternehmen.addClassName("outputField");

            Div aktuelleStellenanzeigen = new Div();
            aktuelleStellenanzeigen.addClassName("outputField");


            add(empfohleneUnternehmen, aktuelleStellenanzeigen);



    }
    //Wenn der Benutzer nicht eingeloggt ist darf er hier nicht hin, also schicken wir in zurrück zum login Screen
    public void beforeEnter(BeforeEnterEvent event){
        if(!isLoggedIn) event.forwardTo("login");
    }

    //Redirect funktion. Noch nicht alle Buttons zeigen hier drauf. Das ist aufräum Arbeit die ich später machen muss
    //--ToDo: alle redirect buttons müssen hier drauf zeigen
    public void redirect(String uri, Button button){

            button.getUI().ifPresent(ui ->
                    ui.navigate("uri")
            );

        }





}
