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
public class Vendas {
    
    //Atributos
    private int cod_venda;
    private int cod_cliente;
    private String user;
    private int cod_produto;
    private String estado;
    private String pais;
    private String cidade;
    private double valor;
    
    //Constutor
    public Vendas(int cod_venda, int cod_cliente, String user, int cod_produto, String estado, String pais, String cidade, double valor){
        this.cod_venda = cod_venda;
        this.cod_cliente = cod_cliente;
        this.user = user;
        this.cod_produto = cod_produto;
        this.estado = estado;
        this.pais = pais;
        this.cidade = cidade;
        this.valor = valor;
    }
    
    //Gets
    public int GetCodVenda (){
        return cod_venda;
    }
    
    public int GetCodCliente (){
        return cod_cliente;
    }
    
    public String GetUser (){
        return user;
    }
    
    public int GetCodProduto (){
        return cod_produto;
    }
    
    public String GetEstado (){
        return estado;
    }
    
    public String GetPais (){
        return pais;
    }
    
    public String GetCidade (){
        return cidade;
    }
    
    public double GetValor (){
        return valor;
    }
    
    //Sets
    public void SetCodVenda (int cod_venda){
        this.cod_venda = cod_venda;
    }
    
    public void SetCodCliente (int cod_cliente){
        this.cod_cliente = cod_cliente;
    }
    
    public void SetUser (String user){
        this.user = user;
    }
    
    public void SetCodProduto (int cod_produto){
        this.cod_produto = cod_produto;
    }
    
    public void SetEstado (String estado){
        this.estado = estado;
    }
    
    public void SetPais (String pais){
        this.pais = pais;
    }
    
    public void SetCidade (String cidade){
        this.cidade = cidade;
    }
    
    public void SetValor (double valor){
        this.valor = valor;
    }
}
