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
public class Produto {
    
    //Atributos
    private int codigo;
    private String nome;
    private int quantidade;
    private String descricao;
    private String faixa_etaria;
    private double valor;
    private String categoria;
    
    //Construtor
    public Produto (int codigo, String nome, int quantidade, String descricao, String faixa_etaria, double valor, String categoria){
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.faixa_etaria = faixa_etaria;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    //Gets
    public int GetCodigo (){
        return codigo;
    }
    
    public String GetNome (){
        return nome;
    }
    
    public int GetQtd (){
        return quantidade;
    }
    
    public String GetDesc(){
        return descricao;
    }
    
    public String GetFaixaEtaria (){
        return faixa_etaria;
    }
    
    public double GetValor (){
        return valor;
    }
    
    public String GetCategoria (){
        return categoria;
    }
    
    //Sets
    public void SetCodigo (int codigo){
        this.codigo = codigo;
    }
    
    public void SetNome (String nome){
        this.nome = nome;
    }
    
    public void SetQtd (int quantidade){
        this.quantidade = quantidade;
    } 
    
    public void SetDesc (String descricao){
        this.descricao = descricao;
    }
    
    public void SetFaixaEtaria (String faixa_etaria){
        this.faixa_etaria = faixa_etaria;
    }
    
    public void SetValor (double valor){
        this.valor = valor;
    }
    
    public void SetCategoria (String categoria){
        this.categoria = categoria;
    }
}
