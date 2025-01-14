package br.ufac.si.academico.gerentes;

import java.util.*;

import javax.persistence.*;

import br.ufac.si.academico.entidades.Vendedor;

public class VendedorGerente {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public VendedorGerente() {
		emf = Persistence.createEntityManagerFactory("SalesUFAC");
		em = emf.createEntityManager();
	}
	
	public void adicionar(Vendedor vendedor) {
//		VendedorGerente us = new VendedorGerente();
		
		em.getTransaction().begin();
		em.persist(vendedor);
		em.getTransaction().commit();
	}
	
	public Vendedor recuperar(int id) {
		return em.find(Vendedor.class, id);
	}
	
	public void atualizar(Vendedor vendedor) {
		em.getTransaction().begin();
		em.merge(vendedor);
		em.getTransaction().commit();
	}
	
	public void remover(Vendedor vendedor) {
		em.getTransaction().begin();
		em.remove(vendedor);
		em.getTransaction().commit();
	}
	
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}
