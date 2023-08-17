package com.example.api_rocketleague_project.Exception;

public class RessourceNotFoundException extends CustomException{
    public RessourceNotFoundException(String ressourceName,Long ressourceId) {
        super("Erreur durant la suppresion de "+ressourceName+" possedant l'id -> "+ressourceId);
    }

    public RessourceNotFoundException(String message) {
        super(message);
    }
}
