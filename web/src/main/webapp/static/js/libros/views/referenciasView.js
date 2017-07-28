/**
 * Vista asociada a la página de referencias de esta aplicación web.
 */
var ReferenciasView = Backbone.View.extend({
	/**
	 * Elemento dom asociado a esta vista
	 */
	el : $('#contenido'),
	/**
	 * Plantilla html asociada a esta vista
	 */
	template : null,

	/**
	 * Incializa las instancias estableciendo la plantilla de este view.
	 * 
	 * @param options.
	 *            Es un hash con un único elemento {template: plantilla}
	 */
	initialize : function(options) {
		this.template = options.template;
	},

	/**
	 * Crea un nodo dom con la plantilla html y los datos del país establecido.
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		$(this.el).html(this.template);
		return this;
	},

	hide : function() {
		$(this.el).empty();
	}
});
