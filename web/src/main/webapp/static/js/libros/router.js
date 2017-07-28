/**
 * Router que se encarga de manejar las peticiones a la página de inicio, de libros y de referencias.
 */
var AppRouter = Backbone.Router.extend({
	/**
	 * Rutas manejadas en la aplicación
	 */
	routes : {
		"" : "index",
		"libros" : "libros",
		"referencias" : "referencias"
	},
	/**
	 * Vista encargada de mostrar la lista de países
	 */
	paisCollectionView : null,
	/**
	 * Vista encargada de mostrar la página de inicio
	 */
	indexView : null,
	/**
	 * Vista encargada de mostrar la la página de referencias
	 */
	referenciasView : null,

	currentView : null,

	initialize : function() {
		var indexTemplate = this.loadTemplate('indexTemplate');
		this.indexView = new IndexView({
			template : indexTemplate
		});

		var libroCollection = new LibroCollection();
		var libroCollectionTemplate = _.template(this.loadTemplate('libroCollection'));
		var libroModelTemplate = _.template(this.loadTemplate('libroModel'));
		var editarLibroTemplate = _.template(this.loadTemplate('editarLibro'));
		var eliminarLibroTemplate = _.template(this.loadTemplate('eliminarLibro'));
		this.libroCollectionView = new LibroCollectionView({
			collection : libroCollection,
			template : libroCollectionTemplate,
			libroModelTemplate : libroModelTemplate,
			editarLibroTemplate : editarLibroTemplate,
			eliminarLibroTemplate : eliminarLibroTemplate
		});

		var referenciasTemplate = this.loadTemplate('referencias');
		this.referenciasView = new ReferenciasView({
			template : referenciasTemplate
		});
	},

	/**
	 * Muestra la página de inicio
	 */
	index : function() {
		this.changeView(this.indexView);
	},

	/**
	 * Muestra la página de referencias.
	 */
	referencias : function() {
		this.changeView(this.referenciasView);
	},

	/**
	 * Recupera la lista de libros y la muestra en una tabla.
	 */
	libros : function() {
		this.changeView(this.libroCollectionView);
	},

	changeView : function(newView) {
		if (newView && this.currentView && newView != this.currentView) {
			this.currentView.hide();
			this.currentView = newView;
			this.currentView.render();
		} else if (newView) {
			this.currentView = newView;
			this.currentView.render();
		}
	},

	/**
	 * Carga una plantilla html indicándole el nombre del archivo sin extensión. La función buscará la plantilla en el
	 * directorio web/static/js/libros/templates y utilizará como extensión del archivo ".tmpl"
	 */
	loadTemplate : function(name) {
		var baseUrl = CONTEXT_PATH + '/static/js/libros/templates';
		var url = baseUrl + '/' + name + '.tmpl';

		var template = '';
		$.ajax({
			url : url,
			method : 'GET',
			async : false,
			dataType : 'html',
			success : function(data) {
				template = data;
			}
		});
		return template;
	}
});

// Creamos el router
var app = new AppRouter();
// Creamos la barra de navegación
new NavBar({
	el : document.getElementById('nav-item-container')
});
// Iniciamos el gestor de histórico
Backbone.history.start();
