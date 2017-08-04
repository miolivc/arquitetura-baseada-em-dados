/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared;

import java.util.HashMap;
import java.util.Map;

/**
 * Conhecer locais onde estao localizados os repositorios de dados.
 * 
 * @author miolivc
 */
public class RepositoryLocator {
    
    public static final String HELLO_FUNCTION = "hello";
    
    // Lista dos diretorios disponiveis 
    private Map<String, String> dirPaths = new HashMap<>();
    // Lista dos arquivos disponiveis
    private Map<String, String> filesPaths = new HashMap<>();
    
    /**
     * Retorna o nome da funcao para o nome do diretorio
     * @param name
     * @return 
     */
    public String function(String name) {
        //TODO mapear qual diretorio faz parte de cada funcao
        return dirPaths.get(name);
    }
    
    /**
     * Retorna nome do arquivo a partir da mensagem
     * @param name
     * @return 
     */
    public String messageType(String name) {
        return filesPaths.get(name);
    }
    
    /**
     * Registra um relacionamento entre um tipo de funcao e um diretorio
     * @param name
     * @param dirPath 
     */
    public void registryFunction(String name, String dirPath) {
        dirPaths.put(name, dirPath);
    }
    
    /**
     * Registra um relacionamento entre um tipo de mensagem e um arquivo
     * @param name
     * @param filePath 
     */
    public void registryMessageType(String name, String filePath) {
        filesPaths.put(name, filePath);
    }
    
}
