<?php
// error_reporting(E_ALL);
// ini_set('display_errors', 1);
require_once 'connect.php';
if($user->is_not_logged_in()) {
	header('Location: login.php');
}
else if($user->is_logged_in() && $_SESSION['position']==2){
	header('Location: index.php');
}
else if($user->is_logged_in() && $_SESSION['position']==0){
	header('Location: user.php');
}
echo $_SESSION['uname'];
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script src="js/jquery.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
	<script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
</head>
<body>
<div class="col s12 m6 push-m1 l6 push-l1 z-depth-1 otherBox" style="padding: 0;">
				<div class="taskHead cyan accent-4" ><h5>Qualtity Load</h5></div>
				<table class="striped">
        			<thead>
          				<tr>
              				<th data-field="id">Parent ID</th>
              				<th data-field="name">House ID</th>
          				</tr>
        			</thead>
        			<tbody id="tableBody">
          				
        			</tbody>
      			</table>
			</div>
<a class="waves-effect waves-light btn" id="lout">Logout</a>
<script type="text/javascript" src="js/supplier.js"></script>
</body>
</html>