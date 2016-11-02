/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Lucas de Andrade
 */

@Entity
public class Vendas implements Serializable{
    
    //Atributos
    @Id
    @GeneratedValue
    private int cod_venda;
    private int cod_cliente;
    private String usuario;
    private String estado;
    private String pais;
    private String cidade;
    private double valor;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "VENDA_PRODUTO", joinColumns = {
        @JoinColumn(name = "VENDA_ID", referencedColumnName = "cod_venda")}, inverseJoinColumns = {
        @JoinColumn(name = "PRODUTO_ID", referencedColumnName = "codigo")})
    private final List<Produto> produtos;
    
    @ManyToOne
    @JoinColumn(name = "CLIENTEPF_ID", referencedColumnName = "codigo")
    private ClientePF pf;

    public ClientePF getPf() {
        return pf;
    }

    public void setPf(ClientePF pf) {
        this.pf = pf;
    }
    
    /*@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo")
    private final ClientePF pf;
    
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo")
    private final ClientePJ pj;

    public ClientePF getPf() {
        return pf;
    }

    public ClientePJ getPj() {
        return pj;
    }*/

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void adicionaProduto(Produto p){
        this.produtos.add(p);
    }
    
    public void removeProduto(Produto p){
        this.produtos.remove(p);
    }

    public int getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public Vendas(){
        this.produtos = new ArrayList();
        /*this.pf = new ClientePF();
        this.pj = new ClientePJ();*/
    }

    
    
    
}
    
    