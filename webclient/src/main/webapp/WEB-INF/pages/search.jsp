<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/stylesheets/site.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/stylesheets/components.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>EOP - API</title>
</head>

<body class="fullpage">
	
	<c:import url="_navbar.jsp"></c:import>

	<div class="container">
		<div id="pageBody">
			<div class="pageTitleBar">
				<h2>Search offers</h2>
			</div>

			<c:import url="_search.jsp"></c:import>

			<br />

			<c:if test="${not empty search}">
	
				<table id="searchResultsGrid"
					class="dataGrid whiteBg dataTable no-footer">
					<thead>
						<th>Offer</th>
						<th>Language</th>
						<th>Merchant</th>
						<th>&nbsp;</th>
					</thead>
					<tbody>
						<c:forEach var="offer" items="${offers}">
							<tr>
								<td>
									<h5>
										<a href="${pageContext.request.contextPath}/detail?offerId=${offer.offerId}">${offer.title}</a>
									</h5>
									<p>${offer.subTitle}</p>
								</td>
								<td><span class="label label-default">${offer.language}</span></td>
								<td>${offer.merchantName}</td>
								<td class="alignRight"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>	
	</div>
	
	<c:import url="_footer.jsp"></c:import>
	
	<c:import url="_jsIncludes.jsp"></c:import>

	<script>
     $(document).ready(function(){    	 
    	 $("#city").val("${param.city}").attr('selected', 'selected');
         $("#tagTier").val("${param.tagTier}").attr('selected', 'selected');
         $("#platform").val("${param.platform}").attr('selected', 'selected');         
         $("#language").val("${param.language}").attr('selected', 'selected');
         $("#category").val("${param.category}").attr('selected', 'selected');
     });
     </script>

</body>

</html>
