package br.com.passos.controle_saida_caminhao.service;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

}
