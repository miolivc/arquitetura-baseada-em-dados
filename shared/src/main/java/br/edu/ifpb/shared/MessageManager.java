/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Responsavel por ler e escrever mensagens no repositorio
 * Alem disso deve ter a possibilidade de excluir as 
 * mensagens que foram entregues.
 * 
 * Relacionar as mensagens de requisiçao e de resposta.
 * 
 * Obs> criar um arquivo .lock antes de ler/escrever no arquivo das mensagens
 * 
 * @author miolivc
 */
public class MessageManager {
    
    private final RepositoryLocator locator;

    public MessageManager(RepositoryLocator locator) {
        this.locator = locator;
    }
    
    private String read(File file) throws FileNotFoundException, IOException {
        FileInputStream input = new FileInputStream(file);
        byte[] b = new byte[1024];
        input.read(b);
        input.close();
        String message = new String(b);
        return message.trim();
    }
    
    private void write(File file, String message) throws FileNotFoundException, IOException {
        FileOutputStream output = new FileOutputStream(file, true);
        String formatted = message.substring(0, 1024) + "\r\n";
        output.write(formatted.getBytes());
        output.close();
    }
    
    private void remove(File file, String message) throws FileNotFoundException, IOException {
        //criando canal de escrita em memoria
        FileInputStream input = new FileInputStream(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        // recuperar o buffer pra leitura line a line
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader bufferedReader = new BufferedReader(reader);
        // faz a leitura de cada linha
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //desprezar caso a linha correspode a passada
            if(line.equals(message)) {
                continue;
            }
            // escreve linha na memoria
            String remsg = line + "\r\n";
            output.write(remsg.getBytes());
        }
        reader.close();
        input.close();
        //abrir o canal de escrita no arquivo
        FileOutputStream fOut = new FileOutputStream(file);
        //escrever no arquivo o que estava em memoria
        output.writeTo(fOut);
        output.close();
    }
    
    private String convert(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message.getIdentify()).append("|");
        sb.append(message.getSequence()).append("|");
        sb.append(message.getOriginalSequence()).append("|");
        sb.append(message.getTo()).append("|");;
        sb.append(message.getFrom()).append("|");
        sb.append(message.getMsg());
        return sb.toString();
    }
    
    private Message convert(String messageText) {
        String[] fields = messageText.split("\\|");
        Message message = new Message();
        message.setIdentify(fields[0]);
        message.setSequence(Integer.parseInt(fields[1]));
        message.setOriginalSequence(Integer.parseInt(fields[2]));
        message.setTo(fields[3]);
        message.setFrom(fields[4]);
        message.setMsg(fields[5]);
        return message;
    }
    
    
    public Message read(String functionName, String messageTypeName) 
            throws FileNotFoundException, IOException {
        String dir = locator.function(functionName);
        String fil = locator.messageType(messageTypeName);
        File file = new File(dir, fil);
        String msgText = read(file);
        return convert(msgText);
    }
    
    public void write(String functionName, String messageTypeName, Message message) 
            throws IOException {
        String dir = locator.function(functionName);
        String fil = locator.messageType(messageTypeName);
        File file = new File(dir, fil);
        String messageText = convert(message);
        write(file, messageText);
    }
}
    
//    public static void main(String[] args) throws IOException {
//        File file = new File("teste.txt");
//        MessageManager m = new MessageManager();
//        m.write(file, "Hello0");
//        m.write(file, "Hello1");
//        m.write(file, "Hello2");
//        m.write(file, "Hello3");
//        m.write(file, "Hello4");
//        m.write(file, "Hello5");
//        m.write(file, "Hello6");
//        System.out.println(m.read(file));
//        m.remove(file, "Hello2");
//        m.remove(file, "Hello3");
//        m.remove(file, "Hello0");
//        m.remove(file, "Hello6");
//        System.out.println(m.read(file));
//        
//    }
