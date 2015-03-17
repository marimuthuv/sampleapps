<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/stylesheets/site.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/stylesheets/components.css" rel="stylesheet">
<title>EOP API - offer details</title>
</head>

<body class="fullpage">
	<c:import url="_navbar.jsp"></c:import>
	
	<div class="container">
		<div id="pageBody">
			<div class="row">
				<c:set var="originalPath" value="${offer.media.offerImageUrl}" />
				<c:set var="convertedImagePath"
					value="${fn:replace(originalPath, 'https://www.mastercardconnect.com/jct_mtfwcmauthor_content/wcm-mtf/', 'https://www.priceless.com/')}" />
	
				<input type="hidden" name="converted" value="${convertedImagePath}" />
				<input type="hidden" name="original" value="${originalPath}" />
				
				<div class="col-xs-9">
					<div class="offerDetailsWhite">
						<img id="imgPreview" src="${originalPath}" class="img-responsive" />
						<h3>${offer.title}</h3>
						<p>${offer.subTitle}</p>
						<p> Category : <span class="label label-default">${offer.category}</span></p>
						<p> Tags : <span class="label label-default">${offer.tags}</span></p>
						<p> ${offer.longDescription}</p>
						
						<div class="hr"></div>
						
						<p>
							<h5 class="fntBold">Terms & Conditions</h5>
							${offer.terms}
						</p>
						
						
					</div>
				</div>
				<div class="col-xs-3">
					<div class="merchantDetails">
						<img id="imgPreview" src="${offer.media.merchantImageUrl}" class="img-responsive" />
						<p>Merchant: <br /><strong>${offer.merchantName}</strong></p>
						<p>Price : <br /><strong>${offer.price}</strong></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:import url="_footer.jsp"></c:import>
	<c:import url="_jsIncludes.jsp"></c:import>
</body>
</html>