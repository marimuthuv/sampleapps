$(document).ready(function()	{
	
	/*** HIGHLIGHTING THE CORRECT TAB ***/
	var activeTab = $('#activePageTab').val();
	$('#pageMenu a, #pageNav a').removeClass('active');
	$(activeTab).addClass('active');
	
	/*** NO ACTION FOR LINKS & BUTTONS ***/
	$('.noAction').click(function(e)	{
		e.preventDefault();
	});
	
	$('.btn-group').button();
	
	/*** STATIC LINKS THAT DO NOT OPEN THEIR HREFS ***/
	$('a.staticLink').on('click', function(e)	{
		e.preventDefault();
	});
	
	/*** FUNCTIONALITY FOR TOGGLE BUTTONS ***/
	$('.toggleBtn').on('click', function()	{
		$(this).toggleClass('active');
	});
	
	
	/*** HANDLING THE BUTTON HIGHLIGHT ON PAGE LOAD FOR RADIOS AND CHECKBOXES ***/
	$('input:checked').each(function()	{
		var btn = $(this).parent('label.btn'),
			targetBlock = $(btn.attr('data-target'));
		
		btn.addClass('active');
		
		if($(this).is(':checked') && btn.attr('data-toggle') == 'collapse')	{
			targetBlock.addClass('in');
		}
		
	});
	
	/*** TOOLTIPS ***/
	$('label[data-toggle=tooltip]').tooltip({
		trigger: 'focus'
	})
	
	
	/*** STYLED SELECTS ***/
	$(".chosen-select").chosen({
		disable_search_threshold: 10
	});
	

	/*** HINT TEXT FUNCTIONALITY ***/
	$('#hintTextWrapper').width($('#hintTextContainer').width());
	$('input[data-hint], textarea[data-hint]').on('focus', function()	{
		var hintTextCont = $(this).attr('data-hint');
		$(hintTextCont).show();
	});
	
	$('input[data-hint], textarea[data-hint]').on('blur', function()	{
		var hintTextCont = $(this).attr('data-hint');
		$(hintTextCont).hide();
	});
	
	$('.chosen-search input').on('focus', function()	{
		var selectBox = $(this).parents('.form-group').find('select'),
			hintTextCont = selectBox.attr('data-hint');
		
		$('.hintText').hide();
		$(hintTextCont).show();
	});

	$('.chosen-search input').on('blur', function()	{
		var selectBox = $(this).parents('.form-group').find('select'),
			hintTextCont = selectBox.attr('data-hint');
		$(hintTextCont).hide();
	});
	
	
	/*** THE INTERMEDIATE SAVE FUNCTIONALITY ***/
	$('.interimSave').on('click', function(e)	{
		e.preventDefault();
	});
	
	
	/*** HIDING COLLAPSIBLE STUFF ***/
	$('.collapse.collapsible.in').each(function()	{
		$(this).removeClass('in');
	});
	
	/*** CONDITIONAL BUTTONS ***/
	$('.btnConditional').on('click',function()	{
		var target = $($(this).attr('data-target')),
			visible = $(this).attr('data-visibletype'),
			hidden =  $(this).attr('data-hidden');
		
		$(hidden).hide();
		
		if(visible == 'show')	{
			target.show();
		}
		else	{
			target.hide();
		}
	});
	
	$('.btnConditional').each(function()	{
		conditionalBtn($(this));
	});
	
	
	function conditionalBtn(btn)	{
		var target = $(btn.attr('data-target')),
			visible = btn.attr('data-visibletype');
		
		if(btn.hasClass('active') && visible == 'show')	{
			target.show();
		}
		else if(btn.hasClass('active') && visible == 'hide')	{
			target.hide();
		}
	}
	
	
	/*** TOGGLE BUTTONS **/
	$('.btnToggle').on('click', function()	{
		$(this).toggleClass('isActive');
		toggleBtn($(this));
	});
	
	$('.btnToggle').each(function()	{
		if($(this).hasClass('active'))	{
			$(this).addClass('isActive');
		}
		toggleBtn($(this));
	});
	
	
	function toggleBtn(btn)	{
		
		var visible = $(btn.attr('data-show')),
			hidden = $(btn.attr('data-hide'));
	
		visible.find('.toggleRequired').removeClass('ignore');
		hidden.find('.toggleRequired').removeClass('ignore');
		
		if(btn.hasClass('isActive'))	{
			visible.show();
			hidden.hide();
			
			visible.find('.toggleRequired').addClass('required');
			
			hidden.find('.toggleRequired').removeClass('required error').addClass('ignore');
			hidden.find('label.error').remove();
		}
		else	{
			visible.hide();
			hidden.show();
			
			hidden.find('.toggleRequired').addClass('required');
			
			visible.find('.toggleRequired').removeClass('required error').addClass('ignore');
			visible.find('label.error').remove();
		}
	}
	
	$('.maxOffersBtn').on('click', function()	{
		if($(this).hasClass('isActive'))	{
			$('#maxInventory').removeClass('greaterThan')
		}
		else	{
			$('#maxInventory').addClass('greaterThan')
		}
	});
	
	/*** VALIDATING FORMS ***/
	
	// Validation Defaults: 
	// validate all fields including ones hidden by chosen:
	$.validator.setDefaults({ 
	    ignore: []
	    // any other default options and/or rules
	});	
	
	
	// Validation Methods: 
	 $.validator.addMethod("cRequired", $.validator.methods.required,
	   "This field is required.");
	 $.validator.addMethod("sNumber", $.validator.methods.number,
	   "Please enter a number.");
	 $.validator.addMethod("sDigits", $.validator.methods.number,
	   "Please enter only digits.");	 
	 $.validator.addMethod("cMinlength", $.validator.methods.minlength,	 
	   $.format("This field must have at least {0} characters"));
	 $.validator.addMethod("cMaxlength", $.validator.methods.maxlength,	
	   $.format("The maximum characters for this field is {0} characters"));
	 $.validator.addMethod("alphaNumericSpace", function(value, element) {
	        return this.optional(element) || /^[a-z0-9\-\s]+$/i.test(value);
	    }, "Please enter only alphabets, digits or spaces");

	 $.validator.addMethod("alphaNumeric", function(value, element) {
	        return this.optional(element) ||  /^[a-z0-9]+$/i.test(value);
	   }, "Please enter only alphabets or digits");
	 
	 $.validator.addMethod("greaterThan",
		function (value, element, param) {
		 var $element = $(element) , $min;
		   if (typeof(param) === "string") {
		       $min = $(param);
		   } else {
		   	  $min = $("#" + $element.data("min"));
		   }
		   
	      if (this.settings.onfocusout) {
		     $min.off(".validate-greaterThan").on("blur.validate-greaterThan", function () {
		       $element.valid();
		     });
		   }
		   return parseInt(value) > parseInt($min.val());
		   
		 }, "The value is incorrect");

	 jQuery.validator.setDefaults({
		 errorPlacement: function(error, element) {
			 if(element.attr('type') == 'checkbox' || element.attr('type') == 'radio') {
				 element.parents('.btn-group').after(error);
			 }
			 else if(element.attr('type') == 'text' || element.is('textarea'))	{
				 element.after(error);
			 }
			 else if(element.is('select') && element.is(':hidden'))	{
				 element.parents('form-group').append('error');
			 }
		 }
	 });
	 
	 
	 $.validator.addClassRules({greaterThan: {greaterThan: true}});
	 $.validator.addClassRules("required", { cRequired: true});
	 $.validator.addClassRules("email", { email: true});
	 $.validator.addClassRules("numbersOnly", { sNumber: true, cRequired: true});
	 $.validator.addClassRules("digits", { sDigits: true});
	 $.validator.addClassRules("digitsRequired", { sDigits: true, cRequired: true});
	 $.validator.addClassRules("optMax10", { cMaxlength: 10 });
	 $.validator.addClassRules("max65", { cRequired: true, cMaxlength: 65 });
	 $.validator.addClassRules("max150", { cRequired: true, cMaxlength: 150 });
	 $.validator.addClassRules("max70", { cRequired: true, cMaxlength: 70 });
	 $.validator.addClassRules("max3000", { cRequired: true, cMaxlength: 3000 });
	 $.validator.addClassRules("max65", { cRequired: true, cMaxlength: 65 });
	 $.validator.addClassRules("url", { url: true });
	 $.validator.addClassRules("alphaNumericSpace", { alphaNumericSpace: true });
	 
	$('#targetingForm').validate({ // initialize the plugin
		ignore: 'hidden',
        rules: {
            passionCategory: {
                required: true,
                //maxlength: 2
            },
            geoLocation: {
              required: true,
              minlength: 1
            }          
        },
        messages: {
            passionCategory: {
                required: "You must check at least 1 box",
                //maxlength: "Check no more than {0} boxes"
            }
        },
        errorPlacement: function(error, element) {
        	  if(element.attr("name") == "geoLocation") {
        		  $('.error-message').html( "<p>Valid Geo Location required. <br>Please click the button above to add valid geo location.</p>");
        	  } else {
        	    error.insertAfter(element);
        	  }
        	}
    });
	
	$('#bundleOfferDetailForm').validate({
		rules: {
			bundleOfferIds: {
	          required: true,
	          minlength: 1
	        },
			'offer.passionCategory': {
	          required: true,
	          minlength: 1
	        }
	    },
	    messages: {
	    	bundleOfferIds: 'Please select at least 1 offer for this bundle',
	    	'offer.passionCategory': 'Please select at least 1 passion category'
	    },
	    errorPlacement: function(error, element) {
	    	if(element.attr('name') == 'bundleOfferIds')	{
	    		error.appendTo('#slectedOffersForBundle')
	    	}
	    	else if(element.hasClass('form-control'))	{
	    		element.parents('.btn-group').after(error);
	    	}
	    }
	});
		

	/*** MERCHANT AUTOCOMPLETE ***/
	$('#merchantName').autocomplete({
	      source: function( request, response ) {
	        $.ajax({
	          url: $('#merchantName').attr('data-url'),
	          dataType: 'json',
	          data: {
	            name: request.term
	          },
	          success: function( data ) {
	            response( $.map( data, function( item ) {
	              return {
	                label: item.name,
	                value: item.name,
	                id:item.id,
	                addressId:item.addrId
	              };
	            }));
	          }
	        });
	      },
	     // minLength: 2,
	      select: function( event, ui ) {
	    	  $(this).val(ui.item.label);
	    	  $('#merchantId').val(ui.item.id);
	    	  $('#merchantAddressId').val(ui.item.addressId);
	    	  
	    	  $('#createOfferModalForm #merchantName').removeClass('error');
	    	  $('#merchantNameErrorMsg').remove();
	      },
	      open: function() {
	        $(this).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
	      },
	      close: function() {
	        $(this).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
	      }
	    });
	
	/*** DELETE MERCHANT MODAL ***/
	$('.deleteMerchantLink').on('click', function()	{
		var mName = $(this).attr('data-name'),
			deleteUrl = $(this).attr('data-deleteurl');
		
		$('#deleteMerchantName').html(mName);
		$('#deleteMerchantBtn').attr('href', deleteUrl);
	});
	
	$('#deleteMerchantBtn').on('click', function(e)	{
		e.preventDefault();
		
		var deleteUrl = $(this).attr('href');
		
		$.ajax({
	      type: 'GET',
          contentType: 'application/json; charset=utf-8',
          dataType: 'json',
		  url: deleteUrl
		}).done(function(response) {
			if(response.status == 'true')	{
				location.reload();
			}
		});
	});
	
	/*** DELET FI MODAL ***/
	$('.deleteFILink').on('click', function()	{
		var mName = $(this).attr('data-name'),
			deleteUrl = $(this).attr('data-deleteurl');
		
		$('#deleteFIName').html(mName);
		$('#deleteFIBtn').attr('href', deleteUrl);
	});	
	
	$('#deleteFIBtn').on('click', function(e)	{
		e.preventDefault();
		
		var deleteUrl = $(this).attr('href');
		
		$.ajax({
	      type: 'GET',
          contentType: 'application/json; charset=utf-8',
          dataType: 'json',
		  url: deleteUrl
		}).done(function(response) {
			if(response.status == 'true')	{
				location.reload();
			}
		});
	});	
	
	/*** DEACTIVATE OFFER MODAL ***/
	$('.deactivateOfferLink').on('click', function()	{
		var spec = $(this).attr('data-offer'),
			deleteUrl = $(this).attr('data-url');
		
		$('#deactivateOfferSpec').html(spec);
		$('#deactivateOfferBtn').attr('href', deleteUrl);
	});
	
	$('#deactivateOfferBtn').on('click', function(e)	{
		e.preventDefault();
		
		var deleteUrl = $(this).attr('href');
		
		$.ajax({
	      type: 'GET',
          contentType: 'application/json; charset=utf-8',
          dataType: 'json',
		  url: deleteUrl
		}).done(function(response) {
			if(response.status == 'true')	{
				location.reload();
			}
		});
	});
	
	
	/*** DEACTIVATE BUNDLE OFFER MODAL ***/
	$('.deactivateBundleOfferLink').on('click', function()	{
		var spec = $(this).attr('data-offer'),
			deleteUrl = $(this).attr('data-url'),
			childOffers = $(this).attr('data-childOffers');
		
		$('#deactivateBundleOfferSpec').html(spec);
		$('#deactivateBundleOfferBtn').attr('href', deleteUrl);
		$('#childOffers').val(childOffers);
	});
	
	$('#deactivateBundleOfferBtn').on('click', function(e)	{
		e.preventDefault();
		
		var deleteUrl = $(this).attr('href');
		
		
		if($('#childOffers').is(':checked'))	{
			deleteUrl = deleteUrl + '&childOffers=' +  $('#childOffers').val();
		}
		
		$.ajax({
	      type: 'GET',
          contentType: 'application/json; charset=utf-8',
          dataType: 'json',
		  url: deleteUrl
		}).done(function(response) {
			if(response.status == 'true')	{
				location.reload();
			}
		});
	});
	
	
	/*** CREATING DATATABLE FOR DASHBOARD ***/
	$('#categoryList, #searchResultsGrid').dataTable({
		'sDom': '<"top"i>rt<"bottom"flp><"clear">',
		'oLanguage': {
			'sSearch': 'Type to filter'
		},
		'bLengthChange': false,
		'bInfo': false,
		'sPaginationType': 'full_numbers',
		'iDisplayLength': 10,
		// use call back to reapply chosenjs after dataTable redraw
		'fnDrawCallback': function( oSettings ) {
			$(".chosen-select").chosen({
				disable_search_threshold: 10,
				width: "300px"
			});
		 }
	});
	$('#logoUploadTable, #hiresUploadTable').dataTable({
		'sDom': '<"top"i>rt<"bottom"flp><"clear">',
		'oLanguage': {
			'sSearch': 'Type to filter'
		},
		'bLengthChange': false,
		'bInfo': false,
		'sPaginationType': 'full_numbers',
		'iDisplayLength': 4
	});
	
	
	/*** FILTERING THE TABLE FROM EXTERNAL INPUTS ***/
	var offerTable = $('#offersList').dataTable({
		'sDom': '<"top"i>rt<"bottom"flp><"clear">',
		'oLanguage': {
			'sSearch': 'Type to filter'
		},
		'bLengthChange': false,
		'bInfo': false,
		'sPaginationType': 'full_numbers',
		'iDisplayLength': 10,
		// use call back to reapply chosenjs after dataTable redraw
		'fnDrawCallback': function( oSettings ) {
			$(".chosen-select").chosen({
				disable_search_threshold: 10,
				width: "300px"
			});
		 }
	});
	
	
	
	
	$(".filterBlurb label").on('click', function () {
		var status = $(this).attr('data-val');
		console.log(status);
		offerTable.fnFilter(status,2);
	});
	
	/** * READING PARAMS FROM A URL ** */
	$.urlParam = function(name){
	    var iSrc = location.href;
		
		name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
	    var regexS = "[\\?&]" + name + "=([^&#]*)";
	    var regex = new RegExp(regexS);
	    var results = regex.exec(iSrc);
	    
	    if (results == null) {
	        return '';
	    }
	    else {
	        return decodeURIComponent(results[1].replace(/\+/g, " "));
	    }
	};
	
	
	/*** MIRRORING FIELDS ***/
	$('.mirror').on('change', function()	{
		var value = $(this).val(),
			mirrorTo = $(this).attr('data-mirrorto');
		
		$(mirrorTo).val(value);
		
	});
	
	/*** VALIDATE THE AUTOCOMPLETE VALIDATE FIELDS ***/
	$('.autoCompleteValidate').on('change', function()	{
		var connectedField = $(this).attr('data-connectedField');
		
		$(this).removeClass('errorField');
		$(this).next('label.autoError').remove();
		
		if($(this).val() != '' && $(connectedField).val() == '')	{
			$(this).addClass('errorField');
			$(this).after('<label class="error autoError" style="display: inline-block;">Please select the value from the list.</label>')
		}
		else	{
			$(this).removeClass('errorField');
			$(this).next('label.error').remove();
		}
	});
	
	/*** REMOVE ERRORS WHEN SELECTION IS MADE ***/
	$('.chosen-select').on('change', function(evt, params) {
		if($(this).find('option:selected').length)	{
			$(this).parents('.form-group').find('.error').remove();
			$(this).removeClass('error');
		}
	});
	
});
