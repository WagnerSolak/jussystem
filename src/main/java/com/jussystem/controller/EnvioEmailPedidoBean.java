package com.jussystem.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.jussystem.model.Pedido;
/*import com.jussystem.util.jsf.FacesUtil;*/
import com.jussystem.util.mail.Mailer;
/*import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;*/

@Named
@RequestScoped
public class EnvioEmailPedidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Mailer mailer;
	
	/*public void enviarPedido() throws IOException {
		MailMessage message = mailer.novaMensagem();
		String filePath = getClass().getClassLoader().getResource("/emails/pedido.template").getFile();
		
		message.to(this.pedido.getFornecedor().getEmailPessoa())
		.subject("Pedido de Compra " + this.pedido.getId())
		.bodyHtml(new VelocityTemplate(new File(filePath)))
		.put("numberTool", new NumberTool())
		.put("locale", new Locale("pt", "BR"))
		.send();
		
		FacesUtil.addInfoMessage("Pedido enviado por email com sucesso!");
	}*/
}
