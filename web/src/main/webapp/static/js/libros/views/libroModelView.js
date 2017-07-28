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
	 * Plantilla html asociada al diálogo de edición de un libro
	 */
	editarLibroTemplate : null,
	/**
	 * Vista asociada al diálogo de edición de un libro
	 */
	editarLibroView : null,
	/**
	 * Plantilla html asociada al diálogo de eliminación de un libro
	 */
	eliminarLibroTemplate : null,
	/**
	 * Vista asociada al diálogo de borrado de un libro
	 */
	eliminarLibroView : null,

	/**
	 * Lista de eventos dom manejados por esta vista
	 */
	events : {
		'click .editar' : 'editar',
		'click .eliminar' : 'eliminar'
	},

	/**
	 * Inicializador de la clase. Establece los atributos model, template, editarLibroView y eliminarLibroView
	 * 
	 * @param options.
	 *            Es un hash con los siguientes elementos { model : value, template: value, editarLibroView: value,
	 *            eliminarLibroView : value }
	 */
	initialize : function(options) {
		this.template = options.template;
		this.editarLibroTemplate = options.editarLibroTemplate;
		this.eliminarLibroTemplate = options.eliminarLibroTemplate;
	},

	/**
	 * Crea un nodo dom con la plantilla html y los datos del país (this.model).
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		$(this.el).html(this.template(this.model.toJSON()));
		return this;
	},

	/**
	 * Muestra un diálogo modal de edición de libros.
	 * 
	 * @param event.
	 *            El evento que ha provocado la ejecución de este método.
	 */
	editar : function(event) {
		event.preventDefault();
		if (this.editarLibroView) {
			this.editarLibroView.destroy();
		}
		this.editarLibroView = new EditarLibroView({
			editarLibroTemplate : this.editarLibroTemplate,
			libro : this.model
		});
		this.editarLibroView.render();
	},

	/**
	 * Muestra un diálogo modal de eliminación de libros.
	 * 
	 * @param event.
	 *            El evento que ha provocado la ejecución de este método.
	 */
	eliminar : function(event) {
		event.preventDefault();
		if (this.eliminarLibroView) {
			this.eliminarLibroView.destroy();
		}
		this.eliminarLibroView = new EliminarLibroView({
			eliminarLibroTemplate : this.eliminarLibroTemplate,
			libro : this.model
		});
		this.eliminarLibroView.render();
	}
});