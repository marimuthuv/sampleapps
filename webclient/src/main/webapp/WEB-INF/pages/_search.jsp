<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="get" action="${pageContext.request.contextPath}/search" class="pageForm">

		<div class="row">
			<div class="form-group col-md-8">
				<input type="text" class="form-control input-lg" name="query" placeholder="What you are looking for..."
					value="${param.query}" />
			</div>


			<div class="form-group col-md-3">				
				<button class="btn btn-primary btn-lg pull-right">
					<i class="fa fa-search"></i> Search
				</button>				
			</div>
						
		</div>
		<div class="row">
			<div class="form-group col-md-2">
				<select name="city" id="city" class="form-control">					
					<option value="" selected="selected">Select City</option>
					<option value="Newyork">New York</option>
					<option value="lasvegas">Las Vegas</option>
					<option value="Losangeles">Los Angeles</option>
					<option value="Chicago">Chicago</option>
					<option value="Miami">Miami</option>
					<option value="Hawaii">Hawaii</option>
					<option value="Paris">Paris</option>
					<option value="Toronto">Toronto</option>
					<option value="Taipei">Taipei</option>
					<option value="Hsinchu">Hsinchu</option>					
				</select>				
			</div>
			
			<%-- <div class="form-group col-md-3">
				<input type="text" class="form-control" name="category" placeholder="Enter the category" value="${param.category}" />
			</div> --%>			
			<div class="form-group col-md-2">
				<select name="category" id="category" class="form-control">					
					<option value="" selected="selected">Select Category</option>
					<option value="RESTAURANT">Restaurant</option>
					<option value="TRAVEL">Travel</option>
					<option value="AUTO">Auto</option>
					<option value="ACTIVITIES">Activity</option>
				</select>				
			</div>
			

			<div class="form-group col-md-2">
				<select name="language" id="language" class="form-control">					
					<option value="" selected="selected">Select Locale</option>
					<option value="en_US">US - English</option>
					<option value="zn_CN">China - Chinese </option>
				</select>				
			</div>
			
			<%-- <div class="form-group col-md-3">
				<input type="text" class="form-control" name="merchant" placeholder="Are you looking merchant offer, enter name here.." value="${param.merchant}" />
			</div>			
			 --%>
			<div class="form-group col-md-2">
				<select name="tagTier" id="tagTier" class="form-control">
					<option value="" selected="selected">Select offer tier</option>				
					<option value="EXPERIENCE">Experience</option>
					<option value="OFFER">Offer</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select name="platform" id="platform" class="form-control">
					<option value="" selected="selected">Select program</option>				
					<option value="priceless">Priceless</option>
					<option value="hsbc">HSBC</option>
					<option value="privileges">Privileges</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select name="card" id="card" class="form-control">
					<option value="" selected="selected">Select a card</option>				
					<option value="priceless">HSBC card 1</option>
					<option value="hsbc">HSBC card 2</option>
					
				</select>
			</div>

		</div>

	</form>