<html>

<!-- jQuery 
Documentation: 
http://jquery.page2page.ru/
-->
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<script>
function ajaxStatus()
{
	$.getJSON('../view/status/${searchId}', function(data){
	var items = [];
	 
	  $.each(data, function(key, val){
	    items.push('<li id="' + key + '">' + val + '</li>');
	  });
	 
	 $('#status').empty();
	 
	  $('<ul/>', {
	    'class': 'status',
	    html: items.join('')
	  }).appendTo('#status');
	});
}


function ajaxResults()
{
	$.getJSON('../view/results/${searchId}', function(data){
	var items = [];
	 
	  $.each(data, function(key, val){
	    items.push('<li id="' + key + '">' + val['id'] +'; ' + val['server']  + '; ' + val['logDescription']+ '</li>');
	  });
	 
	 $('#results').empty();
	 
	  $('<ul/>', {
	    'class': 'results-list',
	    html: items.join('')
	  }).appendTo('#results');
	});
}

$(document).ready(function()
{
    var refreshId = setInterval( function() 
    	{
    		ajaxStatus();
		ajaxResults();
	}, 5000);
});

</script>
<body>
	<h1>Ajax log search view</h1>
	
	<h3>Search ID : ${searchId}</h3>
	
	
<a href="#" onclick="ajaxStatus();">Check status</a>
<a href="#" onclick="ajaxResults();">Make request</a>

<div id="status"></div>
	
<div id="results"></div>

</body>
</html>