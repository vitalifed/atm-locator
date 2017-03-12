<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here is you can search a nearest ING ATM</title>
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery.dataTables.min.js"></script>

<script>
var table;
$(document).ready(function() {
    table = $('#atm').DataTable( {
        "ajax": "atm/ING/search"
    } );
    
} );

function _click(){
	table.ajax.url( 'atm/ING/search?city=' + $("#city").val()).load();
}

</script>

</head>
<body>
	<h2>Here is you can search a nearest ING ATM</h2>

    <input type="text" id="city" name="city"> <button onclick="_click()" >Search</button><br/><br/><br/>

	<table id="atm" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Street</th>
				<th>House number</th>
				<th>Post code</th>
				<th>City</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Street</th>
				<th>House number</th>
				<th>Post code</th>
				<th>City</th>
			</tr>
		</tfoot>
	</table>


</body>
</html>