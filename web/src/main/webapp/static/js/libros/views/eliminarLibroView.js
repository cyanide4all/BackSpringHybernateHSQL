/**
 * Esta "clase" se encarga de representar la vista de un diálogo modal de eliminación de libros. Muestra un libro
 * "libro" y se encarga de capturar los eventos de borrado y eliminarlo de forma efectiva.
 */
var EliminarLibroView = Backbone.View.extend({

	/**
	 * Punto de enganche en el árbol dom
	 */
	el : $('#mensajes'),
	modal : '#eliminarLibro',

	/**
	 * Libro mostrado y (posiblemente) borrado.
	 */
	libro : null,

	events : {
		"click .borrar"	: "deleteLibro",
		"hidden.bs.modal #eliminarLibro" : "destroy"
	},

	/**
	 * Incializa las instancias estableciendo la plantilla de este view.
	 * 
	 * @param options.
	 *            Es un hash con un único elemento {eliminarLibroTemplate: plantilla}
	 */
	initialize : function(options) {
		this.template = options.eliminarLibroTemplate;
		this.libro = options.libro;
	},
	
	/**
	 * Crea un nodo dom con la plantilla html y los datos del país establecido.
	 * 
	 * @return Devuelve la instancia sobre la que se ejecuta la función.
	 */
	render : function() {
		this.$el.html(this.template(this.libro.toJSON()));
		$(this.modal).modal('show');
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
	
	deleteLibro: function(){
		this.libro.destroy();
		//this.destroy();
		$(this.modal).modal('toggle');
	}
});
