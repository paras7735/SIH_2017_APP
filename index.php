<?php
// error_reporting(E_ALL);
// ini_set('display_errors', 1);
require_once 'connect.php';
if($user->is_not_logged_in()) {
	header('Location: login.php');
}
echo $_SESSION['uname'];
?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<script src="js/jquery.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<style type="text/css" src="css/materialize.min.css"></style>
	<script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
</head>
<body>
<button id="lout">Logout</button>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>