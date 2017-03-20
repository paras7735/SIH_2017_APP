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
else if($user->is_logged_in() && $_SESSION['position']==1){
	header('Location: supplier.php');
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
<a class="waves-effect waves-light btn" id="lout">Logout</a>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>