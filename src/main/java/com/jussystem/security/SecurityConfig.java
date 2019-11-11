package com.jussystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AppUserDetailsService userDetailService() {
		return new AppUserDetailsService();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JsfLoginUrlAuthenticationEntryPoint jsfLoginEntry = new JsfLoginUrlAuthenticationEntryPoint();
		jsfLoginEntry.setLoginFormUrl("/Login.xhtml");
		jsfLoginEntry.setRedirectStrategy(new JsfRedirectStrategy());

		JsfAccessDeniedHandler jsfDeniedEntry = new JsfAccessDeniedHandler();
		jsfDeniedEntry.setLoginPath("/AcessoNegado.xhtml");
		jsfDeniedEntry.setContextRelative(true);

		http
			.csrf().disable()
			.headers().frameOptions().sameOrigin()
			.and()

				.authorizeRequests()
				.antMatchers("/Login.xhtml", "/Erro.xhtml", "/javax.faces.resource/**").permitAll()
				.antMatchers("/Home.xhtml", "/AcessoNegado.xhtml", "/dialogos/**").authenticated()
				.antMatchers("/cargos/**").hasRole("GERENCIAR_CARGOS")
				.antMatchers("/pedidos/**").hasRole("GERENCIAR_PEDIDOS")
				.antMatchers("/cidades/**").hasRole("GERENCIAR_CIDADES")
				.antMatchers("/dialogos/**").hasRole("GERENCIAR_DIALOGOS")
				.antMatchers("/documentos/**").hasRole("GERENCIAR_DOCUMENTOS")
				.antMatchers("/fornecedores/**").hasRole("GERENCIAR_FORNECEDORES")
				.antMatchers("/formaPagamentos/**").hasRole("GERENCIAR_FORMAPAGAMENTOS")
				.antMatchers("/pessoas/**").hasRole("GERENCIAR_PESSOAS")
				.antMatchers("/processos/**").hasRole("GERENCIAR_PROCESSOS")
				.antMatchers("/profissoes/**").hasRole("GERENCIAR_PROFISSOES")
				.antMatchers("/relatorios/**").hasRole("GERENCIAR_RELATORIOS")
				.antMatchers("/relatoriosAdvogado/**").hasRole("GERENCIAR_RELATORIOS_ADVOGADO")
				.antMatchers("/relatoriosUsuario/**").hasRole("GERENCIAR_RELATORIOS_USUARIO")
				.antMatchers("/saidas/**").hasRole("GERENCIAR_SAIDAS")
				.antMatchers("/produtos/**").hasRole("GERENCIAR_PRODUTOS")
				.antMatchers("/usuarios/**").hasRole("GERENCIAR_USUARIOS")
				.antMatchers("/inativacoes/**").hasRole("GERENCIAR_INATIVACOES")
				.antMatchers("/ajudas/**").hasRole("GERENCIAR_AJUDAS")
				.and()

				.formLogin()
				.loginPage("/Login.xhtml")
				.failureUrl("/Login.xhtml?invalid=true")
				.and()

				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.and()

				.exceptionHandling()
				.accessDeniedPage("/AcessoNegado.xhtml")
				.authenticationEntryPoint(jsfLoginEntry)
				.accessDeniedHandler(jsfDeniedEntry);

	}
}
