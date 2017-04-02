<?php
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
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
  <style type="text/css">
  body {
    background-image: url(images/4.png);
  }
  </style>
</head>
<body> 

<script type="text/javascript" src="js/index.js"></script>

  <div class="anyForm loginform">
    <div class="container white z-depth-5">
      <div class="row">
        <h2 class="center" style="padding: 20px">Login Portal</h2>
        <form class="col s10 offset-s1">
          <div class="row">
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">account_circle</i>
              <input id="uname" type="text" class="validate" required>
              <label for="userName">User Name</label>
            </div>
            <div class="input-field col s8 offset-s2">
              <i class="material-icons prefix">vpn_key</i>
                    <input id="pass" type="password" class="validate" required>
                    <label for="password">Password</label>
            </div>
            </form>
            <div class="center">
              <button class="waves-effect waves-light btn darken-2 logIn" id="submit" style="background-color:#3892A3; ">Log in<i class="material-icons right">send</i></button>
            </div>
          </div>
        
      </div>
    </div>
  </div>
  
</body>
</html>