/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

/**
 * Representa a menasagem identificada, endereçada e sequencializada
 *
 * @author miolivc
 */
public class Message {
    /**
     * Sequencia de mensagem para cada componente que requisita.
     */
    private int sequence;
    /**
     * Sequencia da mensagem que originou esta caso exista Se nao existe, usar -1
     */
    private int originalSequence = -1;
    /**
     * Identificaçao da mensagem no requisitor
     */
    private String identify;
    /**
     * Identificacao do componente que ira receber a mensagem 
     */
    private String to;
    /**
     * Identificacao de quem vai enviar a mensagem
     */
    private String from;
    
    private String msg;

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getOriginalSequence() {
        return originalSequence;
    }

    public void setOriginalSequence(int originalSequence) {
        this.originalSequence = originalSequence;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
