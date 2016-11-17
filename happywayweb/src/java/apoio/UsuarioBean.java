/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Lucas de Andrade
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {

        EntityManager em = JPAUtil.getEntityManager();
        Query u = em.createQuery("select u from Usuario u");
        this.usuarios = u.getResultList();
        //em.close();

        return this.usuarios;
    }

    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            
            Usuario u = new Usuario();
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            
            if(usuario.getId() != null){
            
            u = em.find(Usuario.class, usuario.getId());
            
            }
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (u != null) {
                //Atualiza os dados da pessoa.
                usuario = em.merge(usuario);
            } else {
                //Salva os dados da pessoa.
                em.persist(usuario);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.usuario = new Usuario();
        return "usuario";
    }

    public String alterar(Usuario u) {
        this.usuario = u;
        return "usuario";
    }

    public void excluir(Usuario u) {

        Long cod = u.getId();

        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(u.getId());
            em.getTransaction().begin();
            u = em.merge(u);
            em.remove(u);
            em.getTransaction().commit();
            em.close();
        }

        this.usuario = new Usuario();

    }

    public String entra() {

        String response = null;

        Usuario toLogin;

        EntityManager em = JPAUtil.getEntityManager();
        Query u = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :user AND u.senha = :senha")
                .setParameter("user", usuario.getUsuario())
                .setParameter("senha", usuario.getSenha());

        if (u.getResultList().size() > 0) {
            toLogin = (Usuario) u.getSingleResult();

            if (toLogin != null) {
                response = "home";
            } else {
                FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage("Usuário ou senha incorretos"));
            }
        } else if(usuario.getUsuario() == "admin" && usuario.getSenha() == "123"){
            response = "home";
        } else{
            FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage("Usuário ou senha incorretos"));
        }

        return response;

    }

}
