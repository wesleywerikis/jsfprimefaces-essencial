package com.jsfprimefaces.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jsfprimefaces.erp.model.Empresa;
import com.jsfprimefaces.erp.repository.Empresas;
import com.jsfprimefaces.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}

	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
