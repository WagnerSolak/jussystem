package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.jussystem.model.validation.FisicaGroups;
import com.jussystem.model.validation.JuridicaGroups;
import com.jussystem.validation.OnlyLetters;

@Entity
public class TermoEntrevistaParaDemandaPF implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataDocumento;
	private ClientePessoaFisica clientePessoaFisica;
	
	private String reu;
	private String telefoneReu;
	private TipoPessoa tipo;
	private String documentoReceitaFederalReu;
	private Date admissao;
	private Date registro;
	private Date demissao;
	private Date ultimoDiaTrabalho;
	private String causaAfastamento;
	private String recebeuVerbaRecisoria;
	private BigDecimal valorVerbaRecisoria;
	private String  trouxeDocumento;
	private String multa477;
	private String danoMoral;
	private String danoMaterial;
	private String funcao;
	private String salarioContratado;
	private String comissionados;
	private String dosInstrumentosTrabalho;
	private String doReajusteSalarial;
	private String exameMedicoAdemissional;
	private String exameMedicoDemissional;
	private String exameMedicoPeriodico;
	private String exameMedicoLheExaminou;
	private String valeTransporte;
	private String seguroDeVida;
	private BigDecimal cestaBasica;
	private String premioAssiduidade;
	private String adicionalTempoServico;
	private String descontos;
	private String jTTurno;
	private String jTTrabalhavaDomingo;
	private String jTCartaoPonto;
	private String jTCartaoPontoAnotava;
	private String jTTipoCartaoPonto;
	private String jTAssinava;
	private String jTHoraExtra;
	private String intinere;
	private String faltaAoServico;
	private String justificaFaltaCometida;
	private String atestadoMedico;
	private String decimoTerceiroSalario;
	private String ferias;
	private String insalubridade;
	private String periculosidade;
	private String riscos;
	private String riscosDescricao;
	private String acidenteTrabalho;
	private String acidenteTrabalhoDescricao;
	private String doencaProfissional;
	private String gestante;
	private String estabilidade;
	private String cipeiro;
	private String epis;
	private String uniforme;
	private String salarioFamilia;
	private String fgts;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	
	@ManyToOne
	@JoinColumn(nullable = false, name = "clientePessoaFisica_id")
	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
	}
	
	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}

	@OnlyLetters
	@Column(nullable = false, length = 100)
	public String getReu() {
		return reu;
	}

	
	public void setReu(String reu) {
		this.reu = reu;
	}
	
	@CNPJ(groups = JuridicaGroups.class)
	@CPF(groups = FisicaGroups.class)
	@Column(length = 20)
	public String getDocumentoReceitaFederalReu() {
		return documentoReceitaFederalReu;
	}
	
	public void setDocumentoReceitaFederalReu(String documentoReceitaFederalReu) {
		this.documentoReceitaFederalReu = documentoReceitaFederalReu;
	}
	
	
	@Column(length = 20)
	public String getTelefoneReu() {
		return telefoneReu;
	}

	public void setTelefoneReu(String telefoneReu) {
		this.telefoneReu = telefoneReu;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDemissao() {
		return demissao;
	}

	public void setDemissao(Date demissao) {
		this.demissao = demissao;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getUltimoDiaTrabalho() {
		return ultimoDiaTrabalho;
	}

	public void setUltimoDiaTrabalho(Date ultimoDiaTrabalho) {
		this.ultimoDiaTrabalho = ultimoDiaTrabalho;
	}

	@Column(columnDefinition = "text")
	public String getCausaAfastamento() {
		return causaAfastamento;
	}

	public void setCausaAfastamento(String causaAfastamento) {
		this.causaAfastamento = causaAfastamento;
	}

	@Column(length = 1)
	public String getRecebeuVerbaRecisoria() {
	
		return recebeuVerbaRecisoria;
	}
	
	public void setRecebeuVerbaRecisoria(String recebeuVerbaRecisoria) {
		this.recebeuVerbaRecisoria = recebeuVerbaRecisoria;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getValorVerbaRecisoria() {
		if(valorVerbaRecisoria == null){
			return BigDecimal.ZERO;
		}
		return valorVerbaRecisoria;
	}

	public void setValorVerbaRecisoria(BigDecimal valorVerbaRecisoria) {
		this.valorVerbaRecisoria = valorVerbaRecisoria;
	}

	@Column(length = 1)
	public String getTrouxeDocumento() {
		return trouxeDocumento;
	}
	
	public void setTrouxeDocumento(String trouxeDocumento) {
		this.trouxeDocumento = trouxeDocumento;
	}

	@Column(length = 1)
	public String getMulta477() {
		return multa477;
	}

	public void setMulta477(String multa477) {
		this.multa477 = multa477;
	}

	@Column(columnDefinition = "text")
	public String getDanoMoral() {
		return danoMoral;
	}

	public void setDanoMoral(String danoMoral) {
		this.danoMoral = danoMoral;
	}

	@Column(columnDefinition = "text")
	public String getDanoMaterial() {
		return danoMaterial;
	}

	public void setDanoMaterial(String danoMaterial) {
		this.danoMaterial = danoMaterial;
	}

	@Column(columnDefinition = "text")
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Column(columnDefinition = "text")
	public String getSalarioContratado() {
		return salarioContratado;
	}

	public void setSalarioContratado(String salarioContratado) {
		this.salarioContratado = salarioContratado;
	}

	@Column(columnDefinition = "text")
	public String getComissionados() {
		return comissionados;
	}

	public void setComissionados(String comissionados) {
		this.comissionados = comissionados;
	}

	@Column(columnDefinition = "text")
	public String getDosInstrumentosTrabalho() {
		return dosInstrumentosTrabalho;
	}

	public void setDosInstrumentosTrabalho(String dosInstrumentosTrabalho) {
		this.dosInstrumentosTrabalho = dosInstrumentosTrabalho;
	}

	@Column(columnDefinition = "text")
	public String getDoReajusteSalarial() {
		return doReajusteSalarial;
	}

	public void setDoReajusteSalarial(String doReajusteSalarial) {
		this.doReajusteSalarial = doReajusteSalarial;
	}

	@Column(length = 1)
	public String getExameMedicoAdemissional() {
		return exameMedicoAdemissional;
	}

	public void setExameMedicoAdemissional(String exameMedicoAdemissional) {
		this.exameMedicoAdemissional = exameMedicoAdemissional;
	}

	@Column(length = 1)
	public String getExameMedicoDemissional() {
		return exameMedicoDemissional;
	}

	public void setExameMedicoDemissional(String exameMedicoDemissional) {
		this.exameMedicoDemissional = exameMedicoDemissional;
	}

	@Column(length = 1)
	public String getExameMedicoPeriodico() {
		return exameMedicoPeriodico;
	}

	public void setExameMedicoPeriodico(String exameMedicoPeriodico) {
		this.exameMedicoPeriodico = exameMedicoPeriodico;
	}

	@Column(length = 1)
	public String getExameMedicoLheExaminou() {
		return exameMedicoLheExaminou;
	}

	public void setExameMedicoLheExaminou(String exameMedicoLheExaminou) {
		this.exameMedicoLheExaminou = exameMedicoLheExaminou;
	}

	@Column(columnDefinition = "text")
	public String getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(String valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	@Column(columnDefinition = "text")
	public String getSeguroDeVida() {
		return seguroDeVida;
	}

	public void setSeguroDeVida(String seguroDeVida) {
		this.seguroDeVida = seguroDeVida;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getCestaBasica() {
		if(cestaBasica == null){
			return BigDecimal.ZERO;
		}
		return cestaBasica;
	}

	public void setCestaBasica(BigDecimal cestaBasica) {
		this.cestaBasica = cestaBasica;
	}

	@Column(length = 1)
	public String getPremioAssiduidade() {
		return premioAssiduidade;
	}

	public void setPremioAssiduidade(String premioAssiduidade) {
		this.premioAssiduidade = premioAssiduidade;
	}

	@Column(columnDefinition = "text")
	public String getAdicionalTempoServico() {
		return adicionalTempoServico;
	}

	public void setAdicionalTempoServico(String adicionalTempoServico) {
		this.adicionalTempoServico = adicionalTempoServico;
	}

	@Column(columnDefinition = "text")
	public String getDescontos() {
		return descontos;
	}

	public void setDescontos(String descontos) {
		this.descontos = descontos;
	}

	@Column(columnDefinition = "text")
	public String getjTTurno() {
		return jTTurno;
	}

	public void setjTTurno(String jTTurno) {
		this.jTTurno = jTTurno;
	}

	@Column(columnDefinition = "text")
	public String getjTTrabalhavaDomingo() {
		return jTTrabalhavaDomingo;
	}

	public void setjTTrabalhavaDomingo(String jTTrabalhavaDomingo) {
		this.jTTrabalhavaDomingo = jTTrabalhavaDomingo;
	}

	@Column(columnDefinition = "text")
	public String getjTCartaoPonto() {
		return jTCartaoPonto;
	}

	public void setjTCartaoPonto(String jTCartaoPonto) {
		this.jTCartaoPonto = jTCartaoPonto;
	}

	@Column(columnDefinition = "text")
	public String getjTCartaoPontoAnotava() {
		return jTCartaoPontoAnotava;
	}

	public void setjTCartaoPontoAnotava(String jTCartaoPontoAnotava) {
		this.jTCartaoPontoAnotava = jTCartaoPontoAnotava;
	}

	@Column(columnDefinition = "text")
	public String getjTTipoCartaoPonto() {
		return jTTipoCartaoPonto;
	}

	public void setjTTipoCartaoPonto(String jTTipoCartaoPonto) {
		this.jTTipoCartaoPonto = jTTipoCartaoPonto;
	}

	@Column(columnDefinition = "text")
	public String getjTAssinava() {
		return jTAssinava;
	}

	public void setjTAssinava(String jTAssinava) {
		this.jTAssinava = jTAssinava;
	}

	@Column(columnDefinition = "text")
	public String getjTHoraExtra() {
		return jTHoraExtra;
	}

	public void setjTHoraExtra(String jTHoraExtra) {
		this.jTHoraExtra = jTHoraExtra;
	}

	@Column(columnDefinition = "text")
	public String getIntinere() {
		return intinere;
	}

	public void setIntinere(String intinere) {
		this.intinere = intinere;
	}

	@Column(length = 1)
	public String getFaltaAoServico() {
		return faltaAoServico;
	}

	public void setFaltaAoServico(String faltaAoServico) {
		this.faltaAoServico = faltaAoServico;
	}

	@Column(length = 1)
	public String getJustificaFaltaCometida() {
		return justificaFaltaCometida;
	}

	public void setJustificaFaltaCometida(String justificaFaltaCometida) {
		this.justificaFaltaCometida = justificaFaltaCometida;
	}

	@Column(length = 1)
	public String getAtestadoMedico() {
		return atestadoMedico;
	}

	public void setAtestadoMedico(String atestadoMedico) {
		this.atestadoMedico = atestadoMedico;
	}

	@Column(columnDefinition = "text")
	public String getDecimoTerceiroSalario() {
		return decimoTerceiroSalario;
	}

	public void setDecimoTerceiroSalario(String decimoTerceiroSalario) {
		this.decimoTerceiroSalario = decimoTerceiroSalario;
	}

	@Column(columnDefinition = "text")
	public String getFerias() {
		return ferias;
	}

	public void setFerias(String ferias) {
		this.ferias = ferias;
	}

	@Column(length = 1)
	public String getInsalubridade() {
		return insalubridade;
	}

	public void setInsalubridade(String insalubridade) {
		this.insalubridade = insalubridade;
	}

	@Column(length = 1)
	public String getPericulosidade() {
		return periculosidade;
	}

	public void setPericulosidade(String periculosidade) {
		this.periculosidade = periculosidade;
	}

	@Column(length = 1)
	public String getRiscos() {
		return riscos;
	}

	public void setRiscos(String riscos) {
		this.riscos = riscos;
	}

	@Column(columnDefinition = "text")
	public String getRiscosDescricao() {
		return riscosDescricao;
	}

	public void setRiscosDescricao(String riscosDescricao) {
		this.riscosDescricao = riscosDescricao;
	}

	@Column(length = 1)
	public String getAcidenteTrabalho() {
		return acidenteTrabalho;
	}

	public void setAcidenteTrabalho(String acidenteTrabalho) {
		this.acidenteTrabalho = acidenteTrabalho;
	}

	@Column(columnDefinition = "text")
	public String getAcidenteTrabalhoDescricao() {
		return acidenteTrabalhoDescricao;
	}

	public void setAcidenteTrabalhoDescricao(String acidenteTrabalhoDescricao) {
		this.acidenteTrabalhoDescricao = acidenteTrabalhoDescricao;
	}

	@Column(columnDefinition = "text")
	public String getDoencaProfissional() {
		return doencaProfissional;
	}

	public void setDoencaProfissional(String doencaProfissional) {
		this.doencaProfissional = doencaProfissional;
	}

	@Column(columnDefinition = "text")
	public String getGestante() {
		return gestante;
	}

	public void setGestante(String gestante) {
		this.gestante = gestante;
	}

	@Column(length = 1)
	public String getEstabilidade() {
		return estabilidade;
	}

	public void setEstabilidade(String estabilidade) {
		this.estabilidade = estabilidade;
	}

	@Column(columnDefinition = "text")
	public String getCipeiro() {
		return cipeiro;
	}

	public void setCipeiro(String cipeiro) {
		this.cipeiro = cipeiro;
	}

	@Column(columnDefinition = "text")
	public String getEpis() {
		return epis;
	}

	public void setEpis(String epis) {
		this.epis = epis;
	}

	@Column(columnDefinition = "text")
	public String getUniforme() {
		return uniforme;
	}

	public void setUniforme(String uniforme) {
		this.uniforme = uniforme;
	}

	@Column(columnDefinition = "text")
	public String getSalarioFamilia() {
		return salarioFamilia;
	}

	public void setSalarioFamilia(String salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	@Column(columnDefinition = "text")
	public String getFgts() {
		return fgts;
	}

	public void setFgts(String fgts) {
		this.fgts = fgts;
	}

	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	public TipoPessoa getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TermoEntrevistaParaDemandaPF other = (TermoEntrevistaParaDemandaPF) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
