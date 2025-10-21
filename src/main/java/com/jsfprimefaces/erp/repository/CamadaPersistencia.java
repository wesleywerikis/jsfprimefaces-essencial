package com.jsfprimefaces.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsfprimefaces.erp.model.Empresa;
import com.jsfprimefaces.erp.model.RamoAtividade;
import com.jsfprimefaces.erp.model.TipoEmpresa;

public class CamadaPersistencia {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataBasePU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);

		List<RamoAtividade> listaDeRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);

		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("Supermercado Bom Preço");
		empresa.setCnpj("12.345.678/0001-01");
		empresa.setRazaoSocial("Bom Preço");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaDeRamoAtividades.get(0));

		empresas.guardar(empresa);

		em.getTransaction().commit();

		List<Empresa> listaDeEmpresas2 = empresas.pesquisar("");
		System.out.println(listaDeEmpresas2);

		em.close();
		emf.close();
	}

}
