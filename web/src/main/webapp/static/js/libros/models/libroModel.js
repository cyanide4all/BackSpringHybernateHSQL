/**
 * Modelo para libros individuales.
 */
var LibroModel = Backbone.Model.extend({
	/**
	 * definiendo urlRoot no será necesario asociar a un modelo a ninguna colección para poder sincronizarlo 
	 * con el servidor.
	 */
	urlRoot: CONTEXT_PATH + '/rest/libros',
	/**
	 * Indicamos a Backbone que utilice la propiedad idLibro como identificador del libro
	 */
	idAttribute: 'idLibro',
	/**
	 * Lista de atributos mínimos que tendrán todas las instancias de LibroModel.
	 */
	defaults: {
		idLibro: null,
		titulo : '',
		autor : ''
	}

});