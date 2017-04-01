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
?>
<!DOCTYPE html>
<html>
<head>
	<title>Contact List</title>
	<script src="js/jquery.min.js"></script>
  <script src="js/materialize.min.js"></script>
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
</head>
	
<body style="background:url(images/4.png);">
<div class="navbar-fixed" style="height: 50px;">
<nav style="height: 50px;line-height: 50px;background-color:rgba(187,28,33,0.9);z-index: 100;">
    <div class="nav-wrapper" >
      <a href="supplier.php" class="brand-logo" style="margin-left: 15px;font-family: 'Open Sans', sans-serif;font-size: 25px;">Alchemist</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down" style="font-family: 'Open Sans', sans-serif;">
        <li><a href="#modal4" class="modal-trigger">Flow Chart-Nodes</a></li>
        <li><a href="sass.html">Profile</a></li>
        <li><a href="contact.php">Contact List</a></li>
        <li><a id="lout">Logout</a></li>
      </ul>
    </div>
  </nav>
  </div>
  <div class="container">
  	<div class="row">
  		<table style="background-color: rgba(255,255,255,0.6);" class="striped">
		<thead>
			<tr style="font-family: 'Open Sans', sans-serif;">
              <th data-field="id">Meter ID</th>
              <th data-field="name">Name</th>
              <th data-field="email">Email</th>
              <th data-field="add">Address</th>
              <th data-field="cont">Contact</th>
            </tr>
		</thead>
		<tbody id="tableBody" style="font-family: 'Open Sans', sans-serif;">
                  
        </tbody>
	</table>
  	</div>
  </div>




<script type="text/javascript" src="js/contact.js"></script>
</body>
</html>