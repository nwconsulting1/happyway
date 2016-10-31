/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Produto;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class ProdutoBean {
    
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private long total;


    public long getTotal() {
        
        EntityManager em = JPAUtil.getEntityManager();
        Query p = em.createQuery("select count(p) from Produto p");
        this.total = (long)p.getSingleResult();
        
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public ProdutoBean(){
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public List<Produto> getProdutos() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query p = em.createQuery("select p from Produto p");
            this.produtos = p.getResultList();
            //em.close();
        
        
        return this.produtos;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, produto.getCodigo());
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (p != null) {
                //Atualiza os dados da pessoa.
                produto = em.merge(produto);
            } else {
                //Salva os dados da pessoa.
                em.persist(produto);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.produto = new Produto();
        return "produtos";
    }
    
    public String alterar(Produto p) {
        this.produto = p;
        return "produtos";
    }
    
    public void excluir(Produto p) {

        Integer cod = p.getCodigo();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(p.getCodigo() + ", " + p.getNome());
            em.getTransaction().begin();
            p = em.merge(p);
            em.remove(p);
            em.getTransaction().commit();
            em.close();
        }

        this.produto = new Produto();

    }
}
