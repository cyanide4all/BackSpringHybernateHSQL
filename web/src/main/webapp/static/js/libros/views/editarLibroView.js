/**
 * Esta "clase" se encarga de representar la vista de un diálogo modal de edición de libros. Muestra el libro "libro" y
 * se encarga de capturar los eventos de edición para actualizarlo de forma.
 */
var EditarLibroView = Backbone.View.extend({

	/**
	 * Punto de enganche en el árbol dom
	 */
	el : $('#mensajes'),
	modal : '#editarLibro',

	/**
	 * Libro mostrado y (posiblemente) actualizado.
	 */
	libro : null,

	events : {
		"click #botonModificar" : "modificarModelo",
		"hidden.bs.modal #editarLibro" : "destroy"
	},

	/**
	 * Incializa las instancias estableciendo la plantilla de este view.
	 * 
	 * @param options.
	 *            Es un hash con un único elemento {editarLibroTemplate: plantilla}
	 */
	initialize : function(options) {
		this.template = options.editarLibroTemplate;
		this.libro = options.libro;
	},

	/**
	 * Crea un nodo dom con la plantilla html y los datos del país establecido.
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		this.$el.html(this.template(this.libro.toJSON()));
		$(this.modal).modal();
		return this;
	},

	hide : function() {
		this.$el.empty();
	},

	destroy : function() {
		this.stopListening();
		this.undelegateEvents();
		this.$el.removeData();
		$(this.modal).remove();
	},
	
	modificarModelo : function() {
		this.libro.set({"titulo": $('#tituloInput').val(), "autor" : $('#autorInput').val()})
		//this.libro.titulo = $('#tituloInput').val();
		//this.libro.autor = $('#autorInput').val();
		this.libro.save();
		$(this.modal).modal('toggle');
	}
});
