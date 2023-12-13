package com.example.fonctionsmathmatiques.controller;

import com.example.fonctionsmathmatiques.model.Factorielle;

public class Controller {
    // implémenter le code pour l'instanciation du contrôleur en pattern Singleton
    private static Controller instance = null;
    private  Controller(){super();}

    public static final Controller getInstance() {
        if (Controller.instance == null){
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }
    private static Factorielle factorielle;

    // implémenter le code pour l'instanciation du modèle de contrôleur par la valeur fourni dans l’interface
    public void initFact(int data){
        factorielle = new Factorielle(data);
    }

    //implémenter le code qui permet de retourner le résultat à afficher.
    public int getResult(){
        return factorielle.getResult();
    }


}
