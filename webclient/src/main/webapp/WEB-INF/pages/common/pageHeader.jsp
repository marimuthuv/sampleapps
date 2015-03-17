<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fns" uri="http://www.truaxis.com/jsp/jstl/functions"%>

<c:set var="hasSearchOfferPermission" value="${fns:hasPermission('SEARCH_OFFER')}" />

<!-- THE PAGE HEADER -->
<a href="${pageContext.request.contextPath}" class="navbar-brand"><img src="/eop-client-admin/resources/images/eopLogo.png" class="img-responsive" /></a>

<div class="pull-right headerLinks">
	 <c:if test="${hasSearchOfferPermission}">
	  <a href="${pageContext.request.contextPath}/search" class="btn btn-default" title="Search"><i class="fa fa-search"></i> Search existing offers</a>
	  </c:if>
	  <a href="<c:url value='/j_spring_security_logout' />" class="btn btn-light" title="Log out"><i class="fa fa-sign-out"></i> Logout</a>
</div>

