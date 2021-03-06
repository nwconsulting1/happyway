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
import model.Campanha;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class CampanhaBean {
    
    private Campanha campanha = new Campanha();
    private List<Campanha> campanhas = new ArrayList<>();
    private long total;
    
    public long getTotal() {
    
        EntityManager em = JPAUtil.getEntityManager();
        Query p = em.createQuery("select count(c) from Campanha c", Campanha.class);
        this.total = (long)p.getSingleResult();
        
        return this.total;
            
    }
    
    
    public CampanhaBean(){
    }
    
    public Campanha getCampanha(){
        return campanha;
    }
    
    public void setCampanha(Campanha campanha){
        this.campanha = campanha;
    }
    
    public List<Campanha> getCampanhas() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query c = em.createQuery("select c from Campanha c", Campanha.class);
            this.campanhas = c.getResultList();
            //em.close();
        
        
        return this.campanhas;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            
            Campanha c = new Campanha();
            
            if(campanha.getId() != null){
            
            c = em.find(Campanha.class, campanha.getId());
            
            }
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (c != null) {
                //Atualiza os dados da pessoa.
                campanha = em.merge(campanha);
            } else {
                //Salva os dados da pessoa.
                em.persist(campanha);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.campanha = new Campanha();
        return "campanha";
    }
    
    public String alterar(Campanha c) {
        this.campanha = c;
        return "campanha";
    }
    
    public void excluir(Campanha c) {

        Long cod = c.getId();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(c.getId());
            em.getTransaction().begin();
            c = em.merge(c);
            em.remove(c);
            em.getTransaction().commit();
            em.close();
        }

        this.campanha = new Campanha();

    }
}
