<?php
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
<style type="text/css">
	body {
        font-family: "Lato Light", Arial; 
        
       
      }
</style>
</head>
	
<body style="background:url(images/4.png);">
<div class="navbar-fixed" style="height: 50px;">
<nav style="height: 50px;line-height: 50px;background-color:rgba(187,28,33,0.95);z-index: 100;">
    <div class="nav-wrapper" >
      <a href="supplier.php" class="brand-logo" style="margin-left: 15px;font-family: 'Open Sans', sans-serif;font-size: 1.2rem;">Alchemist</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down" style="font-family: 'Open Sans', sans-serif;">
        <li><a href="profile.html"><img src="images/user.png" style="transform: scale(0.6);float: left;margin-top: 0px;left: -10px;"> Profile</a></li>
        <li><a href="contact.php"><img src="images/contact.png" style="transform: scale(0.95);float: left;margin-top: 10px;margin-left: -2px;">Contact List</a></li>
        <li><a id="lout"><img src="images/logout1.png" style="float: left;margin-left: -5px;margin-top: 12px;">Logout</a></li>
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