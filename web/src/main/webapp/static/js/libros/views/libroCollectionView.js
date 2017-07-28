/**
 * Esta clase representa la vista (y controlador) asociados a la lista de países.
 */
var LibroCollectionView = Backbone.View.extend({
	/**
	 * Elemento dom asociado a esta vista
	 */
	el : $('#contenido'),
	/**
	 * Plantilla html asociada a esta vista
	 */
	template : null,
	/**
	 * Plantilla html asociada a la vista de un libro individual
	 */
	libroModelTemplate : null,
	/**
	 * Plantilla html asociada al diálogo de edición de un libro
	 */
	editarLibroTemplate : null,
	/**
	 * Plantilla html asociada al diálogo de eliminación de un libro
	 */
	eliminarLibroTemplate : null,
	/**
	 * Información de los libros
	 */
	libroCollection : null,

	/**
	 * Inicializador de la clase. Establece los atributos collection, template, libroModelTemplate, editarLibroTemplate
	 * y eliminarLibroTemplate
	 * 
	 * @param options.
	 *            Es un hash con los siguientes elementos { collection : value, template: value, libroModelTemplate:
	 *            value, editarLibroTemplate: value, eliminarLibroTemplate : value }
	 */
	initialize : function(options) {

		this.template = options.template;
		this.libroModelTemplate = options.libroModelTemplate;
		this.editarLibroTemplate = options.editarLibroTemplate;
		this.eliminarLibroTemplate = options.eliminarLibroTemplate;
		this.libroCollection = options.collection;
		this.listenTo(this.libroCollection, 'reset', this.render);
	},

	/**
	 * Crea un nodo dom con la plantilla html (this.template) y los datos de los países (this.collection).
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		this.recuperarLibros(this.renderCollection, this.error);
	},

	renderCollection : function() {
		$(this.el).html(this.template());
		_.each(this.collection.models, function(value) {
			$('#filas').append(new LibroModelView({
				model : value,
				template : this.libroModelTemplate,
				editarLibroTemplate : this.editarLibroTemplate,
				eliminarLibroTemplate : this.eliminarLibroTemplate
			}).render().el);
		}, this);

		return this;
	},
	error : function() {
		alert('Se ha producido un error al recuperar la lista de libros.');
	},

	recuperarLibros : function(success, error) {
		this.libroCollection.fetch({
			success : _.bind(success, this),
			error : _.bind(error, this)
		});
	},

	hide : function() {
		$(this.el).empty();
	}
});