<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ejercicio de aplicacion web - Qindel</title>

    <!-- Bootstrap -->
	<link rel="stylesheet" href="${contextPath}/static/css/bootstrap.css" />
	<link rel="stylesheet" href="${contextPath}/static/css/bootstrap-qindel.css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!-- Variables JSP de uso en scripts -->
	<script type="text/javascript">
		var CONTEXT_PATH = "${contextPath}";
	</script>
	
	<!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextPath}/static/img/qindel.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextPath}/static/img/qindel.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextPath}/static/img/qindel.png">
    <link rel="apple-touch-icon-precomposed" href="${contextPath}/static/img/qindel.png">
    <link rel="shortcut icon" href="${contextPath}/static/img/favicon.png">
  </head>

<body>
    <!-- Part 1: Wrap all page content here -->
    <div id="wrap">

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Ejercicio web</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul id="nav-item-container" class="nav navbar-nav">
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

      <!-- Begin page content -->
      <div class="container">
      	<div id="mensajes">
      	</div>
      	<div id="contenido">
      	</div>
	  </div>
      <div id="push"></div>
    </div>

    <div id="footer">
      <div class="container">
        <p class="muted credit">Basado en 
	        <a href="http://www.hibernate.org/">Hibernate</a>, <a href="http://spring.io/">Spring</a>, 
	        <a href="https://github.com/FasterXML/jackson">Jackson</a>, <a href="http://backbonejs.org/">Backbone</a> y 
	        <a href="http://getbootstrap.com/">Bootstrap</a>.
        </p>
      </div>
    </div>

<!-- Librerias -->
<script src="${contextPath}/static/lib/jquery-2.1.0.js"></script>
<script src="${contextPath}/static/lib/underscore-1.6.0.js"></script>
<script src="${contextPath}/static/lib/backbone-1.1.2.js"></script>
<script src="${contextPath}/static/lib/bootstrap-3.1.1.js"></script>
<!-- Carga de Scripts -->
<script src="${contextPath}/static/js/libros/views/indexView.js"></script>
<script src="${contextPath}/static/js/libros/views/referenciasView.js"></script>
<script src="${contextPath}/static/js/libros/models/libroModel.js"></script>
<script src="${contextPath}/static/js/libros/collections/libroCollection.js"></script>
<script src="${contextPath}/static/js/libros/views/libroModelView.js"></script>
<script src="${contextPath}/static/js/libros/views/libroCollectionView.js"></script>
<script src="${contextPath}/static/js/libros/views/eliminarLibroView.js"></script>
<script src="${contextPath}/static/js/libros/views/editarLibroView.js"></script>
<script src="${contextPath}/static/js/common/views/navBarView.js"></script>
<script src="${contextPath}/static/js/libros/router.js"></script>

</body>
</html>