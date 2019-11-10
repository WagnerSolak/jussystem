PrimeFaces.validator.Highlighter.types.onemenu = {
				highlight : function(a) {
					a.parent().siblings(".ui-selectonemenu-trigger").addClass(
							"ui-state-error").parent().addClass(
							"ui-state-error");
					PrimeFaces.validator.Highlighter.highlightLabel(a.parent().parent().find('div input'))
				},
				unhighlight : function(a) {
					a.parent().siblings(".ui-selectonemenu-trigger")
							.removeClass("ui-state-error").parent()
							.removeClass("ui-state-error");
					PrimeFaces.validator.Highlighter.unhighlightLabel(a
							.parent().parent().find('div input'))
				}
};