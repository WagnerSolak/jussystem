package com.jussystem.controller;

import java.io.Serializable;
import java.math.BigDecimal;
//import java.util.Arrays;
import java.util.Date;
import java.util.List;
//import java.util.stream.Collectors;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.model.CondicaoDePagamento;
//import com.jussystem.model.CondicaoPagamento;
import com.jussystem.model.ContasReceberPF;
import com.jussystem.model.StatusContasReceber;
import com.jussystem.repository.CondicaoDePagamentos;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroContasReceberPFService;



@Named
@ViewScoped
public class CadastroContasReceberPFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ContasReceberPF contasReceberPF;
	
	@Inject
	private CadastroContasReceberPFService contasReceberPFService;
	
	@Inject
	private CondicaoDePagamentos condicoesCondicaoDePagamentos;
	
	public CadastroContasReceberPFBean(){
		limpar();
	}
	
	public void inicializar(){
		if(contasReceberPF == null){
			limpar();
		}
	}
	
	public void limpar(){
		contasReceberPF = new ContasReceberPF();
	}
	
	
	
	public void salvar(){
		System.out.println("CR COD: "+ contasReceberPF.getId());
		System.out.println("CR DATA: "+contasReceberPF.getDataEmissao());
		
		contasReceberPF = contasReceberPFService.salvar(contasReceberPF);
		FacesUtil.addInfoMessage("Contas a Receber do Cliente: " + contasReceberPF.getClientePessoaFisica().getNomePessoa()+ ", salvo com sucesso!");
		limpar();
	}
	
	public List<CondicaoDePagamento> completarCondicaoDePagamento(String descricao){
		return this.condicoesCondicaoDePagamentos.porNomeCondicaoDePagamento(descricao);
	}

	
	/*public List<CondicaoPagamento> getCondicoesPagamento(){
		return Arrays.asList(CondicaoPagamento.values());
		
	}
	public List<CondicaoPagamento> completarCondicaoPagamento(String descricao){
		return getCondicoesPagamento().stream()
				.filter(c -> c.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
				.collect(Collectors.toList());
	}*/
	
	//Método para resolver NotFoundException quando cliente não selecionado!
	@NotBlank
	public String getNomeCliente(){
		return contasReceberPF.getClientePessoaFisica() == null ? null :
			contasReceberPF.getClientePessoaFisica().getNomePessoa();
	}
	
	
	// somente para nao ocorrer erro, alterado readOnly xhtml para true na fase
	// RENDER_RESPONSE, e assim o readOnly é validado, pois por natureza não o faz
	public void setNomeCliente(String nome){
	}
	
	public void clienteSelecionado(SelectEvent evento){
		contasReceberPF.setClientePessoaFisica((ClientePessoaFisica) evento.getObject());
	}

	
		private BigDecimal novoRecebimento;
		
		public void setNovoRecebimento(BigDecimal novoRecebimento) {
			this.novoRecebimento = novoRecebimento;
		}
		public BigDecimal getNovoRecebimento() {
			return novoRecebimento;
		}
	
		
		public void baixar(){
				if(novoRecebimento.compareTo(BigDecimal.ZERO) < 0){
					FacesUtil.addErrorMessage("Valor do Recebimento não pode ser negativo");
				}else{
					contasReceberPF.setValorRestante(contasReceberPF.getValorTotal().subtract(novoRecebimento));
					if(	contasReceberPF.getValorRestante().compareTo(BigDecimal.ZERO) <= 0){
						contasReceberPF.setStatus(StatusContasReceber.PAGO);
						contasReceberPF.setDataPagamento(new Date());
					}else{
						contasReceberPF.setStatus(StatusContasReceber.PAGOPARCIAL);
						contasReceberPF.setDataPagamento(new Date());
					}
					contasReceberPF = contasReceberPFService.salvar(contasReceberPF);
					FacesUtil.addInfoMessage("Contas a Receber: " + contasReceberPF.getClientePessoaFisica().getNomePessoa()+ ", baixado com sucesso!");
					limpar();
				}
			}
	
	
	public void setContasReceberPF(ContasReceberPF contasReceberPF) {
		this.contasReceberPF = contasReceberPF;
	}
	
	public ContasReceberPF getContasReceberPF() {
		return contasReceberPF;
	}
	
	
}
