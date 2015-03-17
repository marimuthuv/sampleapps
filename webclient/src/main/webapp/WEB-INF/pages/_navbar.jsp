<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">     
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-6">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/images/eop_logo.png" class="img-responsive" /></a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li <c:if test="${tab=='home'}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/" class="topLink">Home</a></li>
        <li <c:if test="${tab=='travel'}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/explore/travel" class="topLink">Travel</a></li>
        <li <c:if test="${tab=='restaurant'}"> class="active" </c:if>><a href="${pageContext.request.contextPath}/explore/restaurant" class="topLink">Restaurant</a></li>
      </ul>
      <div class="col-sm-3 col-md-3 pull-right">
        <form class="navbar-form" role="search" method="get" action="${pageContext.request.contextPath}/search">
            <div class="input-group">
                <input type="text" class="form-control searchBox" placeholder="Search" name="query" value="${param.query}">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit"><i class="fa fa-search" style="padding: 3px 0;"></i></button>
                </div>
            </div>
        </form>
    	</div>
    </div>
    
  </div>
</nav>

    
    
