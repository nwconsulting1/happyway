/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author Lucas de Andrade
 */
@Entity
public class ClientePJ extends Cliente {
    
    private String CNPJ;
    private String obs;
    
    public ClientePJ(){}
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getObs() {
        return obs;
    }

    //Atributos
    public void setObs(String obs) {
        this.obs = obs;
    }
   
    
}