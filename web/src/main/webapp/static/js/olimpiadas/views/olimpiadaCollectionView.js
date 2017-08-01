/**
 * Esta clase representa la vista (y controlador) asociados a la lista de olimpiadas.
 */
var OlimpiadaCollectionView = Backbone.View.extend({
	/**
	 * Elemento dom asociado a esta vista
	 */
	el : $('#contenido'),
	/**
	 * Plantilla html asociada a esta vista
	 */
	template : null,
	/**
	 * Plantilla html asociada a la vista de una olimpiada individual
	 */
	olimpiadaModelTemplate : null,
	/**
	 * Información de las olimpiadas
	 */
	olimpiadaCollection : null,

	/**
	 * Inicializador de la clase. Establece los atributos collection, template y olimpiadaModelTemplate
	 * 
	 * @param options.
	 *            Es un hash con los siguientes elementos { collection : value, template: value, olimpiadaModelTemplate: value }
	 */
	initialize : function(options) {

		this.template = options.template;
		this.olimpiadaModelTemplate = options.olimpiadaModelTemplate;
		this.olimpiadaCollection = options.collection;
		this.listenTo(this.olimpiadaCollection, 'reset', this.render);
	},

	/**
	 * Crea un nodo dom con la plantilla html (this.template) y los datos de las olimpiadas (this.collection).
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		this.recuperarOlimpiadas(this.renderCollection, this.error);
	},

	renderCollection : function() {
		$(this.el).html(this.template());
		_.each(this.collection.models, function(value) {
			$('#filas').append(new OlimpiadaModelView({
				model : value,
				template : this.olimpiadaModelTemplate,
			}).render().el);
		}, this);

		return this;
	},
	error : function() {
		alert('Se ha producido un error al recuperar la lista de olimpiadas.');
	},

	recuperarOlimpiadas : function(success, error) {
		this.olimpiadaCollection.fetch({
			success : _.bind(success, this),
			error : _.bind(error, this)
		});
	},

	hide : function() {
		$(this.el).empty();
	}
});