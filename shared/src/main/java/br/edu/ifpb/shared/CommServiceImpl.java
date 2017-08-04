/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

/**
 *
 * @author miolivc
 */
public class CommServiceImpl implements CommService {
    private final RepositoryLocator locator;
    private final MessageManager manager;

    public CommServiceImpl(RepositoryLocator locator) {
        this.locator = locator;
        this.manager = new MessageManager(locator);
    }

    @Override
    public void send(Message message) {
        
    }

    @Override
    public Message recv(String dest) {
        return null;
    }
    
}
