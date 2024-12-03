package com.example.application.Authentication;

public class Authenticator {
    //Klasse um zu schauen, ob man eingeloggt ist via Singleton pattern und zum anderen wird hier auch abgeglichen mit der Db ob dieser Benutzer so existiert
    private boolean isAuthenticated = false;
    private static Authenticator instance;

    public Authenticator() {}

    public static Authenticator getInstance() {
        if(instance == null) {
            instance =  new Authenticator();
        }
        return instance;
    }

    //Benutzer Einloggen
    public void Authenticate(String username, String password) {
        isAuthenticated = true;
        //Hier noch der Code wo mit der Datenbank abgeglichen wird ob das alles so passt
    }


    //Check ob der Benutzer gerade eingeloggt ist
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
