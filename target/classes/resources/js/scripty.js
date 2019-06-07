function gerenciaTeclaEnter() {
		
		$(document).ready(function() {
			$('input').keypress(function(e) {
				var code = null;
				code = (e.keyCode ? e.keyCode : e.which);
				return (code === 13) ? false : true;

			});

			$('input[type=text]').keydown(function(e) {
				// Obter o pr󸩭o ice do elemento de entrada de texto
				var next_idx = $('input[type=text]').index(this) + 1;

				// Obter o n򭥲o de elemento de entrada de texto em um documento html
				var tot_idx = $('body').find('input[type=text]').length;

				// Entra na tecla no c󤩧o ASCII
				if (e.keyCode === 13) {
					if (tot_idx === next_idx)
						// Vᡰara o primeiro elemento de texto
						$('input[type=text]:eq(0)').focus();
					else
						// Vᡰara o elemento de entrada de texto seguinte
						$('input[type=text]:eq(' + next_idx + ')').focus();
				}
			});
		});
		
	}
