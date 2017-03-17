<?php
// error_reporting(E_ALL);
// ini_set('display_errors', 1);
require_once 'connect.php';
if($user->is_logged_in()) {
	header('Location: index.php');
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<script src="js/jquery.min.js"></script>

	<link rel="stylesheet" href="css/materialize.min.css">
		<script src="js/materialize.min.js"></script>
	<script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
</head>
<body> 
<div class="container">
<div class="row">
    <form class="col s12">
    	<div class="row">
        <div class="input-field col s12">
          <input id="uname" type="text" class="validate" required>
          <label for="uname">Username</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="pass" type="password" class="validate" required>
          <label for="pass">Password</label>
        </div>
      </div>
      
      
    
    </form>
    <button class="btn" id="submit">Submit</button>
  </div>
  </div>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>