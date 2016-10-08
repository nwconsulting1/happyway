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
public class ClientePF extends Cliente {
    
    //Atributos
    private String sexo;
    private String CPF;
    private String RG;
    private String obs;
    private String data_nascimento;
    
    //Construtor
    public ClientePF (int codigo, String nome, String data_cadastro, String estado, String cep, String email, String telefone, String cidade, String pais, String endereco, String sexo, String CPF, String RG, String obs, String data_nascimento){
        super(codigo, nome, data_cadastro, estado, cep, email, telefone, cidade, pais, endereco);
        this.sexo = sexo;
        this.CPF = CPF;
        this.RG = RG;
        this.obs = obs;
        this.data_nascimento = data_nascimento;
    }
    
    //Gets
    public String GetSexo(){
        return sexo;
    }
    
    public String GetCPF(){
        return CPF;
    }
    
    public String GetRG (){
        return RG;
    }
    
    public String GetOBS (){
        return obs;
    }
    
    public String GetDataNasc (){
        return data_nascimento;
    }
    
    //Sets
    public void SetSexo (String sexo){
        this.sexo = sexo;
    }
    
    public void SetCPF (String CPF) {
        this.CPF = CPF;
    }
    
    public void SetRG (String RG) {
        this.RG = RG;
    }
    
    public void SetOBS (String obs){
        this.obs = obs;
    }
    
    public void SetDataNasc (String data_nascimento){
        this.data_nascimento = data_nascimento;
    }
}
