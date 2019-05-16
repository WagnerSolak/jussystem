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
				.antMatchers("/pedidos/**").hasRole("GERENCIAR_PEDIDOS")
				.antMatchers("/cidades/**").hasRole("GERENCIAR_CIDADES")
				.antMatchers("/documentos/**").hasRole("GERENCIAR_DOCUMENTOS")
				.antMatchers("/estados/**").hasRole("GERENCIAR_ESTADOS")
				.antMatchers("/formaPagamentos/**").hasRole("GERENCIAR_FORMAPAGAMENTOS")
				.antMatchers("/pessoas/**").hasRole("GERENCIAR_PESSOAS")
				.antMatchers("/produtos/**").hasRole("GERENCIAR_PRODUTOS")
				.antMatchers("/relatorios/**").hasRole("GERENCIAR_RELATORIOS")
				.antMatchers("/usuarios/**").hasRole("GERENCIAR_USUARIOS")
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
