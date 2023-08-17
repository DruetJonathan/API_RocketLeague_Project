package com.example.api_rocketleague_project.Exception;

public class DeletionFailedException extends CustomException{

    public DeletionFailedException(String ressourceName, Long ressourceId) {
        super("Erreur durant la suppresion de "+ressourceName+" possedant l'id -> "+ressourceId);
    }
}
