/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

/**
 * Representa o servico de comunicacao oferecido pelo middleware
 * @author miolivc
 */
public interface CommService {
    
    /**
     * Envia uma mensagem 
     * @param message 
     */
    void send(Message message);
    
    /**
     * Recebe uma mensagem 
     * @param dest
     * @return Message
     */
    Message recv(String dest);
    
}
