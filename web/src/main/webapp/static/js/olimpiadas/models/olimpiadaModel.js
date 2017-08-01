/**
 * Modelo para representar la consulta de ciudades completas
 */
var OlimpiadaModel = Backbone.Model.extend({
	/**
	 * definiendo urlRoot no será necesario asociar a un modelo a ninguna colección para poder sincronizarlo 
	 * con el servidor.
	 */
	urlRoot: CONTEXT_PATH + '/rest/olimpiadas',
	/**
	 * Indicamos a Backbone que utilice la propiedad como identificador unico
	 */
	idAttribute: 'id_pais', //Año tambien puede ser un id valido
	/**
	 * Atributos de olimpiada
	 */
	defaults: {
		id_pais: null,
		pais : '',
		id_ciudad : null,
		ciudad : '',valor : null,
		descripcion : '',
		Numero_veces_sede : null		
	}

});