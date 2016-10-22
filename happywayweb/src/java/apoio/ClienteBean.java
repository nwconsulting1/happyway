/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<>();
    
    public ClienteBean(){
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public List<Cliente> getClientes() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query c = em.createQuery("select c from Cliente c");
            this.clientes = c.getResultList();
            //em.close();
        
        
        return this.clientes;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, cliente.getCodigo());
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (c != null) {
                //Atualiza os dados da pessoa.
                cliente = em.merge(cliente);
            } else {
                //Salva os dados da pessoa.
                em.persist(cliente);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.cliente = new Cliente();
        return "cliente";
    }
    
    public String alterar(Cliente c) {
        this.cliente = c;
        return "clientes";
    }
    
    public void excluir(Cliente c) {

        Integer cod = c.getCodigo();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(c.getCodigo());
            em.getTransaction().begin();
            c = em.merge(c);
            em.remove(c);
            em.getTransaction().commit();
            em.close();
        }

        this.cliente = new Cliente();

    }
}
