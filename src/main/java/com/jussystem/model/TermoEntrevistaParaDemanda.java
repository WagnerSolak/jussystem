package com.jussystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class TermoEntrevistaParaDemanda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataDocumento;
	private Pessoa pessoa;
	
	private String reu;
	private String telefoneReu;
	private String telefoneAutor;
	private Date admissao;
	private Date registro;
	private Date demissao;
	private Date ultimoDiaTrabalho;
	private String causaAfastamento;
	private Boolean recebeuVerbaRecisoria;
	private BigDecimal valorVerbaRecisoria;
	private Boolean  trouxeDocumento;
	private Boolean multa477;
	private String danoMoral;
	private String danoMaterial;
	private String funcao;
	private String salarioContratado;
	private String comissionados;
	private String dosInstrumentosTrabalho;
	private String doReajusteSalarial;
	private Boolean exameMedicoAdemissional;
	private Boolean exameMedicoDemissional;
	private Boolean exameMedicoPeriodico;
	private Boolean exameMedicoLheExaminou;
	private String valeTransporte;
	private String seguroDeVida;
	private BigDecimal cestaBasica;
	private Boolean premioAssiduidade;
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
	private Boolean faltaAoServico;
	private Boolean justificaFaltaCometida;
	private Boolean atestadoMedico;
	private String decimoTerceiroSalario;
	private String ferias;
	private Boolean insalubridade;
	private Boolean periculosidade;
	private Boolean riscos;
	private String riscosDescricao;
	private Boolean acidenteTrabalho;
	private String acidenteTrabalhoDescricao;
	private String doencaProfissional;
	private String gestante;
	private Boolean estabilidade;
	private String cipeiro;
	private String epis;
	private String uniforme;
	private String salarioFamilia;
	private String fgts;
	private String indenizacao;
	

	

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

	@OneToOne
	@JoinColumn(nullable = false, name = "pessoa_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Column(nullable = false, length = 80)
	public String getReu() {
		return reu;
	}

	
	public void setReu(String reu) {
		this.reu = reu;
	}
	
	@Column(length = 20)
	public String getTelefoneAutor() {
		return telefoneAutor;
	}
	
	public void setTelefoneAutor(String telefoneAutor) {
		this.telefoneAutor = telefoneAutor;
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

	@Column(length = 255)
	public String getCausaAfastamento() {
		return causaAfastamento;
	}

	public void setCausaAfastamento(String causaAfastamento) {
		this.causaAfastamento = causaAfastamento;
	}

	@Type(type="yes_no")
	public Boolean getRecebeuVerbaRecisoria() {
		return recebeuVerbaRecisoria;
	}

	public void setRecebeuVerbaRecisoria(Boolean recebeuVerbaRecisoria) {
		this.recebeuVerbaRecisoria = recebeuVerbaRecisoria;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getValorVerbaRecisoria() {
		return valorVerbaRecisoria;
	}

	public void setValorVerbaRecisoria(BigDecimal valorVerbaRecisoria) {
		this.valorVerbaRecisoria = valorVerbaRecisoria;
	}

	@Type(type="yes_no")
	public Boolean getTrouxeDocumento() {
		return trouxeDocumento;
	}

	public void setTrouxeDocumento(Boolean trouxeDocumento) {
		this.trouxeDocumento = trouxeDocumento;
	}

	@Type(type="yes_no")
	public Boolean getMulta477() {
		return multa477;
	}

	public void setMulta477(Boolean multa477) {
		this.multa477 = multa477;
	}

	@Column(length = 255)
	public String getDanoMoral() {
		return danoMoral;
	}

	public void setDanoMoral(String danoMoral) {
		this.danoMoral = danoMoral;
	}

	@Column(length = 255)
	public String getDanoMaterial() {
		return danoMaterial;
	}

	public void setDanoMaterial(String danoMaterial) {
		this.danoMaterial = danoMaterial;
	}

	@Column(length = 255)
	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Column(length = 255)
	public String getSalarioContratado() {
		return salarioContratado;
	}

	public void setSalarioContratado(String salarioContratado) {
		this.salarioContratado = salarioContratado;
	}

	@Column(length = 255)
	public String getComissionados() {
		return comissionados;
	}

	public void setComissionados(String comissionados) {
		this.comissionados = comissionados;
	}

	@Column(length = 255)
	public String getDosInstrumentosTrabalho() {
		return dosInstrumentosTrabalho;
	}

	public void setDosInstrumentosTrabalho(String dosInstrumentosTrabalho) {
		this.dosInstrumentosTrabalho = dosInstrumentosTrabalho;
	}

	@Column(length = 255)
	public String getDoReajusteSalarial() {
		return doReajusteSalarial;
	}

	public void setDoReajusteSalarial(String doReajusteSalarial) {
		this.doReajusteSalarial = doReajusteSalarial;
	}

	@Type(type="yes_no")
	public Boolean getExameMedicoAdemissional() {
		return exameMedicoAdemissional;
	}

	public void setExameMedicoAdemissional(Boolean exameMedicoAdemissional) {
		this.exameMedicoAdemissional = exameMedicoAdemissional;
	}

	@Type(type="yes_no")
	public Boolean getExameMedicoDemissional() {
		return exameMedicoDemissional;
	}

	public void setExameMedicoDemissional(Boolean exameMedicoDemissional) {
		this.exameMedicoDemissional = exameMedicoDemissional;
	}

	@Type(type="yes_no")
	public Boolean getExameMedicoPeriodico() {
		return exameMedicoPeriodico;
	}

	public void setExameMedicoPeriodico(Boolean exameMedicoPeriodico) {
		this.exameMedicoPeriodico = exameMedicoPeriodico;
	}

	@Type(type="yes_no")
	public Boolean getExameMedicoLheExaminou() {
		return exameMedicoLheExaminou;
	}

	public void setExameMedicoLheExaminou(Boolean exameMedicoLheExaminou) {
		this.exameMedicoLheExaminou = exameMedicoLheExaminou;
	}

	@Column(length = 255)
	public String getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(String valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	@Column(length = 255)
	public String getSeguroDeVida() {
		return seguroDeVida;
	}

	public void setSeguroDeVida(String seguroDeVida) {
		this.seguroDeVida = seguroDeVida;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getCestaBasica() {
		return cestaBasica;
	}

	public void setCestaBasica(BigDecimal cestaBasica) {
		this.cestaBasica = cestaBasica;
	}

	@Type(type="yes_no")
	public Boolean getPremioAssiduidade() {
		return premioAssiduidade;
	}

	public void setPremioAssiduidade(Boolean premioAssiduidade) {
		this.premioAssiduidade = premioAssiduidade;
	}

	@Column(length = 255)
	public String getAdicionalTempoServico() {
		return adicionalTempoServico;
	}

	public void setAdicionalTempoServico(String adicionalTempoServico) {
		this.adicionalTempoServico = adicionalTempoServico;
	}

	@Column(length = 255)
	public String getDescontos() {
		return descontos;
	}

	public void setDescontos(String descontos) {
		this.descontos = descontos;
	}

	@Column(length = 255)
	public String getjTTurno() {
		return jTTurno;
	}

	public void setjTTurno(String jTTurno) {
		this.jTTurno = jTTurno;
	}

	@Column(length = 255)
	public String getjTTrabalhavaDomingo() {
		return jTTrabalhavaDomingo;
	}

	public void setjTTrabalhavaDomingo(String jTTrabalhavaDomingo) {
		this.jTTrabalhavaDomingo = jTTrabalhavaDomingo;
	}

	@Column(length = 255)
	public String getjTCartaoPonto() {
		return jTCartaoPonto;
	}

	public void setjTCartaoPonto(String jTCartaoPonto) {
		this.jTCartaoPonto = jTCartaoPonto;
	}

	@Column(length = 255)
	public String getjTCartaoPontoAnotava() {
		return jTCartaoPontoAnotava;
	}

	public void setjTCartaoPontoAnotava(String jTCartaoPontoAnotava) {
		this.jTCartaoPontoAnotava = jTCartaoPontoAnotava;
	}

	@Column(length = 255)
	public String getjTTipoCartaoPonto() {
		return jTTipoCartaoPonto;
	}

	public void setjTTipoCartaoPonto(String jTTipoCartaoPonto) {
		this.jTTipoCartaoPonto = jTTipoCartaoPonto;
	}

	@Column(length = 255)
	public String getjTAssinava() {
		return jTAssinava;
	}

	public void setjTAssinava(String jTAssinava) {
		this.jTAssinava = jTAssinava;
	}

	@Column(length = 255)
	public String getjTHoraExtra() {
		return jTHoraExtra;
	}

	public void setjTHoraExtra(String jTHoraExtra) {
		this.jTHoraExtra = jTHoraExtra;
	}

	@Column(length = 255)
	public String getIntinere() {
		return intinere;
	}

	public void setIntinere(String intinere) {
		this.intinere = intinere;
	}

	@Type(type="yes_no")
	public Boolean getFaltaAoServico() {
		return faltaAoServico;
	}

	public void setFaltaAoServico(Boolean faltaAoServico) {
		this.faltaAoServico = faltaAoServico;
	}

	@Type(type="yes_no")
	public Boolean getJustificaFaltaCometida() {
		return justificaFaltaCometida;
	}

	public void setJustificaFaltaCometida(Boolean justificaFaltaCometida) {
		this.justificaFaltaCometida = justificaFaltaCometida;
	}

	@Type(type="yes_no")
	public Boolean getAtestadoMedico() {
		return atestadoMedico;
	}

	public void setAtestadoMedico(Boolean atestadoMedico) {
		this.atestadoMedico = atestadoMedico;
	}

	@Column(length = 255)
	public String getDecimoTerceiroSalario() {
		return decimoTerceiroSalario;
	}

	public void setDecimoTerceiroSalario(String decimoTerceiroSalario) {
		this.decimoTerceiroSalario = decimoTerceiroSalario;
	}

	@Column(length = 255)
	public String getFerias() {
		return ferias;
	}

	public void setFerias(String ferias) {
		this.ferias = ferias;
	}

	@Type(type="yes_no")
	public Boolean getInsalubridade() {
		return insalubridade;
	}

	public void setInsalubridade(Boolean insalubridade) {
		this.insalubridade = insalubridade;
	}

	@Type(type="yes_no")
	public Boolean getPericulosidade() {
		return periculosidade;
	}

	public void setPericulosidade(Boolean periculosidade) {
		this.periculosidade = periculosidade;
	}

	@Type(type="yes_no")
	public Boolean getRiscos() {
		return riscos;
	}

	public void setRiscos(Boolean riscos) {
		this.riscos = riscos;
	}

	@Column(length = 255)
	public String getRiscosDescricao() {
		return riscosDescricao;
	}

	public void setRiscosDescricao(String riscosDescricao) {
		this.riscosDescricao = riscosDescricao;
	}

	@Type(type="yes_no")
	public Boolean getAcidenteTrabalho() {
		return acidenteTrabalho;
	}

	public void setAcidenteTrabalho(Boolean acidenteTrabalho) {
		this.acidenteTrabalho = acidenteTrabalho;
	}

	@Column(length = 255)
	public String getAcidenteTrabalhoDescricao() {
		return acidenteTrabalhoDescricao;
	}

	public void setAcidenteTrabalhoDescricao(String acidenteTrabalhoDescricao) {
		this.acidenteTrabalhoDescricao = acidenteTrabalhoDescricao;
	}

	@Column(length = 255)
	public String getDoencaProfissional() {
		return doencaProfissional;
	}

	public void setDoencaProfissional(String doencaProfissional) {
		this.doencaProfissional = doencaProfissional;
	}

	@Column(length = 255)
	public String getGestante() {
		return gestante;
	}

	public void setGestante(String gestante) {
		this.gestante = gestante;
	}

	@Type(type="yes_no")
	public Boolean getEstabilidade() {
		return estabilidade;
	}

	public void setEstabilidade(Boolean estabilidade) {
		this.estabilidade = estabilidade;
	}

	@Column(length = 255)
	public String getCipeiro() {
		return cipeiro;
	}

	public void setCipeiro(String cipeiro) {
		this.cipeiro = cipeiro;
	}

	@Column(length = 255)
	public String getEpis() {
		return epis;
	}

	public void setEpis(String epis) {
		this.epis = epis;
	}

	@Column(length = 255)
	public String getUniforme() {
		return uniforme;
	}

	public void setUniforme(String uniforme) {
		this.uniforme = uniforme;
	}

	@Column(length = 255)
	public String getSalarioFamilia() {
		return salarioFamilia;
	}

	public void setSalarioFamilia(String salarioFamilia) {
		this.salarioFamilia = salarioFamilia;
	}

	@Column(length = 255)
	public String getFgts() {
		return fgts;
	}

	public void setFgts(String fgts) {
		this.fgts = fgts;
	}

	@Column(length = 255)
	public String getIndenizacao() {
		return indenizacao;
	}

	public void setIndenizacao(String indenizacao) {
		this.indenizacao = indenizacao;
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
		TermoEntrevistaParaDemanda other = (TermoEntrevistaParaDemanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
