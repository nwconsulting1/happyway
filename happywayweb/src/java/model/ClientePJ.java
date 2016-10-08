/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lucas de Andrade
 */
public class ClientePJ extends Cliente {
    
    //Atributos
    private String CNPJ;
    private String obs;
   
    //Construtor 
    public ClientePJ (int codigo, String nome, String data_cadastro, String estado, String cep, String email, String telefone, String cidade, String pais, String endereco, String CNPJ, String obs){
        super(codigo, nome, data_cadastro, estado, cep, email, telefone, cidade, pais, endereco);
        this.CNPJ = CNPJ;
        this.obs = obs;
      
    }
    
    //Gets
    public String GetCNPJ (){
        return CNPJ;
    }
    
    public String GetOBS (){
        return obs;
    }
    
    //Sets
    public void SetCNPJ (String CNPJ){
        this.CNPJ = CNPJ;
    }
    
    public void SetOBS (String obs){
        this.obs = obs;
    }
    
   
    
    
    
}
