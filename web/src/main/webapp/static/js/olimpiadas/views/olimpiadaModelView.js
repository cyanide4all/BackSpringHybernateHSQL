/**
 * Renderiza una fila de la tabla de resultados, se corresponde con un modelo
 */
var LibroModelView = Backbone.View.extend({
	/**
	 * Tag asociado a esta vista
	 */
	tagName : 'tr',
	/**
	 * Plantilla html asociada a la vista.
	 */
	template : null,
	
	/**
	 * Lista de eventos dom manejados por esta vista
	 */
	events : {
	},

	/**
	 * Inicializador de la clase. Establece los atributos model y template
	 * 
	 * @param options.
	 *            Es un hash con los siguientes elementos { model : value, template: value}
	 */
	initialize : function(options) {
		this.template = options.template;
	},

	/**
	 * Crea un nodo dom con la plantilla html y los datos de las olimpiadas (this.model).
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	}
});