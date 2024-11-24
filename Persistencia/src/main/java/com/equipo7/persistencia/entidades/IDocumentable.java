package com.equipo7.persistencia.entidades;

import org.bson.Document;

/**
 * Permite serializar la clase a un objeto Document de BSON
 * @author Saul Neri
 */
public interface IDocumentable {

    /**
     * Crea una representacion de los datos de una clase en un objeto Document de BSON
     * @return Documento BSON
     */
    public Document toDocument();
}
