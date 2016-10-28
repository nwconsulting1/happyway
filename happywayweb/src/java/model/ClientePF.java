/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Lucas de Andrade
 */
@Entity
public class ClientePF extends Cliente {
    
    private String CPF;
    private String RG;
    private String sexo;
    private String obs;
    private String data_nascimento;
    
    //Construtor
    public ClientePF (){
        
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    //Atributos
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
   
    
    
}
