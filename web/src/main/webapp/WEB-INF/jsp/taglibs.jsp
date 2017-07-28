<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Variables de uso general -->
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="serverName" value="<%=request.getServerName()%>"/>
<c:set var="locale" value="<%=org.springframework.web.servlet.support.RequestContextUtils.getLocale(request)%>"/>
<c:set var="language" value="${locale.language}"/>
