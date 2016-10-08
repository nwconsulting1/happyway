/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Scanner;
/**
 *
 * @author Lucas de Andrade
 */
public class Cliente {
    Scanner input = new Scanner(System.in);
    
    //Atributos
    private int codigo;
    private String nome;
    private String data_cadastro;
    private String estado;
    private String cep;
    private String email;
    private String telefone;
    private String cidade;
    private String pais;
    private String endereco;
    
    //Construtor
    public Cliente (int codigo, String nome, String data_cadastro, String estado, String cep, String email, String telefone, String cidade, String pais, String endereco){
        this.codigo = codigo;
        this.nome = nome;
        this.data_cadastro = data_cadastro;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.pais = pais;
        this.endereco = endereco;
    }
    
    //Gets
    public int GetCodigo (){
        return codigo;
    }
    
    public String GetNome (){
        return nome;
    }
    
    public String GetDataCadastro () {
        return data_cadastro;
    }
    
    public String GetEstado (){
        return estado;
    }
    
    public String GetCEP (){
        return cep;
    }
    
    public String GetEmail (){
        return email;
    }
    
    public String GetTelefone (){
        return telefone;
    }
    
    public String GetCidade (){
        return cidade;
    }
    
    public String GetPais (){
        return pais;
    }
    
    public String GetEndereco (){
        return endereco;
    }
    
    //Sets
    public void SetCodigo (int codigo){
        this.codigo = codigo;
    }
    
    public void SetNome (String nome){
        this.nome = nome;
    }
    
    public void SetDataCadastro (String data_cadastro){
        this.data_cadastro = data_cadastro;
    }
    
    public void SetEstado (String estado){
        this.estado = estado;
    }
    
    public void SetCEP (String cep){
        this.cep = cep;
    }
    
    public void SetEmail (String email){
        this.email = email;
    }
    
    public void SetTelefone (String telefone){
        this.telefone = telefone;
    }
    
    public void SetCidade (String cidade){
        this.cidade = cidade;
    }
    
    public void SetPais (String pais){
        this.pais = pais;
    }
    
    public void SetEndereco (String endereco){
        this.endereco = endereco;
    }
}
