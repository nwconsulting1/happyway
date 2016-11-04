/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Produto;
import model.Vendas;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class VendasBean {
    
    private Vendas venda = new Vendas();
    private List<Vendas> vendas;
    
    private long total;
    
    private List<Produto> produtos;
    
    public long getTotal() {
        
        EntityManager em = JPAUtil.getEntityManager();
        Query p = em.createQuery("select count(v) from Vendas v");
        this.total = (long)p.getSingleResult();
        
        return this.total;
        
    }
    
    
    public VendasBean(){
    }
    
    public Vendas getVenda(){
        return venda;
    }
    
    public void setVenda(Vendas venda){
        this.venda = venda;
    }
    
    public List<Vendas> getVendas() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query p = em.createQuery("select v from Vendas v");
            this.vendas = p.getResultList();
            //em.close();
        
        
        return this.vendas;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            
            Vendas v = new Vendas();
            
            if(venda.getCod_venda() != null){
            
            v = em.find(Vendas.class, venda.getCod_venda());
            
            }
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (v != null) {
                //Atualiza os dados da pessoa.
                venda = em.merge(venda);
            } else {
                //Salva os dados da pessoa.
                em.persist(venda);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.venda = new Vendas();
        return "vendas";
    }
    
    public String alterar(Vendas v) {
        this.venda = v;
        return "vendaswizard";
    }
    
    public void excluir(Vendas v) {

        Long cod = v.getCod_venda();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(v.getCod_venda());
            em.getTransaction().begin();
            v = em.merge(v);
            em.remove(v);
            em.getTransaction().commit();
            em.close();
        }

        this.venda = new Vendas();

    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public List<Produto> getProdutosVenda(){
        return this.venda.getProdutos();
    }
}
