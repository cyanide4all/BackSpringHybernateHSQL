/**
 * Clase par el manejo de listas de libros
 */
var LibroCollection = Backbone.Collection.extend({
	/**
	 * url en el servidor para manejar las peticiones rest/json generadas por backbone
	 */
	url : CONTEXT_PATH + '/rest/libros',
	/**
	 * Modelo asociado a esta Collection
	 */
    model: LibroModel
});