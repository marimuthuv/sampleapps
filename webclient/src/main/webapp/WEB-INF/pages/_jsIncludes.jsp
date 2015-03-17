<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-57327410-1', 'auto');
  ga('send', 'pageview');

</script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>


<script type="text/javascript">
	$(document).ready(function()	{
		
		var geoCookieLabel = document.cookie.replace(/(?:(?:^|.*;\s*)explorecityLabel\s*\=\s*([^;]*).*$)|^.*$/, "$1");
		
		if(geoCookieLabel == '' || geoCookieLabel == 'global')	{
			$('#geoCookieLabel').html('around the world');		
		}
		else	{
			$('#geoCookieLabel').html(geoCookieLabel);	
		}
		
		
		
		$('#setCityCookie a').on('click', function(e)	{
			e.preventDefault();
			var cVal = $(this).attr('data-value'),
				cLabel=$(this).text();
			document.cookie = "explorecity=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
			document.cookie = "explorecityLabel=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
			
			setCookie("explorecity",cVal);
			setCookie("explorecityLabel",cLabel);
			
			location.reload();
		});
		
		
		
		function setCookie(cookieName, cookieValue) {
		    var d = new Date();
		    var expiryDays = 1;
		    d.setTime(d.getTime() + (expiryDays*24*60*60*1000));
		    var expires = "expires="+d.toUTCString();
		    document.cookie = cookieName + "=" + cookieValue + "; " + expires + "; path=/";
		} 
	});
</script>
