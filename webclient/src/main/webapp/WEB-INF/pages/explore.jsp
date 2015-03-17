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
<title>EOP - API</title>
</head>

<body class="fullpage">

	<c:import url="_navbar.jsp"></c:import>

	<div class="container">	
		<div id="pageBody">
			
			<div class="geoCityBar">
				
				<div class="row">
					<div class="col-md-8"></div>
					<div class="col-md-4">
						<div class="citySelector">
							<div class="dropdown">
						        <a href="#" id="myTabDrop1" class="dropdown-toggle topLink" data-toggle="dropdown" aria-controls="myTabDrop1-contents" aria-expanded="false">Showing you all offers from <span id="geoCookieLabel">around the world</span> <span class="caret floatRight"></span></a>
						        <ul class="dropdown-menu citiesMenu" role="menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
						          <li id="setCityCookie">
						          	<p class="global">
						          		<a href="#" data-value="">Around the world</a>
						          	</p>
						          	<div class="row">
						          		<div class="col-md-4">
						          			<p><strong>United States</strong></p>
						          			<p>
						          				<a href="#" data-value="newyork">New York</a>
						          				<a href="#" data-value="lasvegas">Las Vegas</a>
						          				<a href="#" data-value="miami">Miami</a>
						          				<a href="#" data-value="chicago">Chicago</a>
						          				<a href="#" data-value="losangeles">Los Angeles</a>
						          				<a href="#" data-value="hawaii">Hawaii</a>
						          			</p>
						          		</div>
						          		<div class="col-md-4">
						          			<p><strong>France</strong></p>
						          			<p>
						          				<a href="#" data-value="paris">Paris</a>
						          			</p>
						          			
						          			<p><strong>Canada</strong></p>
						          			<p>
						          				<a href="#" data-value="toronto">Toronto</a>
						          			</p>
						          		</div>
						          		
						          		<div class="col-md-4">
						          			<p><strong>China</strong></p>
						          			<p>
						          				<a href="#" data-value="taipei">Taipei</a>
						          				<a href="#" data-value="hsinchu">Hsinchu</a>
						          			</p>
						          		</div>
						          	</div>
						          </li>
						          <!-- <li><a href="#dropdown2" tabindex="-1" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2">@mdo</a></li> -->
						        </ul>
						      </div>	
						
						</div>
					</div>
				</div>
			</div>
			
			
			<c:if test="${fn:length(experiences) gt 0}">
				<!-- SLIDE SHOW -->
				<div id="carousel-example-captions" class="carousel slide" data-ride="carousel">
			      <ol class="carousel-indicators">
			        <li data-target="#carousel-example-captions" data-slide-to="0" class="active"></li>
			        <li data-target="#carousel-example-captions" data-slide-to="1" class=""></li>
			        <li data-target="#carousel-example-captions" data-slide-to="2" class=""></li>
			        <li data-target="#carousel-example-captions" data-slide-to="3" class=""></li>
			        <li data-target="#carousel-example-captions" data-slide-to="4" class=""></li>
			      </ol>
			      <div class="carousel-inner" role="listbox">
			        <c:forEach var="experience" items="${experiences}">		
						<div class="item">
					      <img class="img-responsive" src="${experience.media.offerImageUrl}" alt="Generic placeholder image">
					      <div class="carousel-caption">
					        <a href="${pageContext.request.contextPath}/detail?offerId=${experience.offerId}">${experience.title}</a>
					      </div>
					    </div>
					</c:forEach>
			      </div>
			      <a class="left carousel-control" href="#carousel-example-captions" role="button" data-slide="prev">
			        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			        <span class="sr-only">Previous</span>
			      </a>
			      <a class="right carousel-control" href="#carousel-example-captions" role="button" data-slide="next">
			        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			        <span class="sr-only">Next</span>
			      </a>
			    </div>
				<br /><br />	
			</c:if>

	
	
		<c:if test="${not empty offers}">
		<div class="row">
			<c:forEach var="offer" items="${offers}">		
				<div class="col-md-4">
					<div class="tile">
						<img class="img-responsive" src="${offer.media.offerImageUrl}" alt="Generic placeholder image">
						<div class="tileContent">
							<h5><a href="${pageContext.request.contextPath}/detail?offerId=${offer.offerId}">${offer.title}</a></h5>
							<p class="offer-desc">${offer.subTitle}</p>
							
							<div class="row">
								<div class="col-xs-6">
									<c:if test="${offer.tagTier[0] == 'EXPERIENCE'}">
										<span class="tierIcon bgOrange" title="This is an experience"><i class="fa fa-bolt"></i></span>
									</c:if>
								</div>
								<div class="col-xs-6 alignRight">
									<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/detail?offerId=${offer.offerId}" role="button">View details »</a>
								</div>
							</div>
							
							
								
										
						</div>
					</div>
				</div>
            </c:forEach>
		</div>
		</c:if>
		
		</div>
	</div>	
	
	
	
	<c:import url="_footer.jsp"></c:import>
	<c:import url="_jsIncludes.jsp"></c:import>
	
	<script>
     $(document).ready(function(){    	 
         $("#platform").val("${param.platform}").attr('selected', 'selected');         
         $("#language").val("${param.language}").attr('selected', 'selected');
         
         $(".offer-desc").each(function(i){
        	    len=$(this).text().length;
        	    if(len>100)
        	    {
        	      $(this).text($(this).text().substr(0,100)+'...');
        	    }
        	  }); 
     });
     </script>
	<script>
		$(function() {
			$('#carousel-example-captions .item:first-child').addClass('active');
			$('#carousel-example-captions').carousel(0);
		});
	</script>
	
</body>

</html>
