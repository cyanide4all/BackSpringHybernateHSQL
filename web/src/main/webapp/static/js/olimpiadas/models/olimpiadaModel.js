/**
 * Modelo para olimpiadas individuales.
 */
var OlimpiadaModel = Backbone.Model.extend({
	/**
	 * definiendo urlRoot no será necesario asociar a un modelo a ninguna colección para poder sincronizarlo 
	 * con el servidor.
	 */
	urlRoot: CONTEXT_PATH + '/rest/paises',
	/**
	 * Indicamos a Backbone que utilice la propiedad idolimpiada como identificador del olimpiada
	 */
	idAttribute: 'id_pais',
	/**
	 * Lista de atributos mínimos que tendrán todas las instancias de olimpiadaModel.
	 */
	defaults: {
		id_pais: null,
		nombre_pais : '',
		codigo_pais : '',
		valor_pais : null
	}

});