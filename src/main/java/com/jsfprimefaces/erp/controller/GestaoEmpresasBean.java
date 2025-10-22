package com.jsfprimefaces.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jsfprimefaces.erp.model.Empresa;
import com.jsfprimefaces.erp.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa = new Empresa();

	public void salvar() {
		System.out.println("Razâo Social: " + empresa.getRazaoSocial() + " - Nome fantasia: "
				+ empresa.getNomeFantasia() + " - Tipo: " + empresa.getTipo());
	}
	
	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public TipoEmpresa[] getTipoEmpresas() {
		return TipoEmpresa.values();
	}

}
