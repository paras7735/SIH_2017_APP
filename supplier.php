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
  <title></title>
  <script src="js/jquery.min.js"></script>
  <script src="js/materialize.min.js"></script>
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
</head>
<body style="background-color: rgb(51,63,80);">
<div class="navbar-fixed" style="height: 50px;">
<nav style="height: 50px;line-height: 50px;background-color:rgba(187,28,33,0.9);z-index: 100;...">
    <div class="nav-wrapper" >
      <a href="#" class="brand-logo" style="margin-left: 15px;font-family: 'Open Sans', sans-serif;font-size: 25px;">Alchemist</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down" style="font-family: 'Open Sans', sans-serif;">
        <li><a href="sass.html">Profile</a></li>
        <li><a href="badges.html">Contact List</a></li>
        <li><a id="lout">Logout</a></li>
      </ul>
    </div>
  </nav>
  </div>

<div class="row">
<div class="col s8 offset-s2" style="background-color: rgb(226,34,45);">

  <center><h1 style="color:white;font-family: 'Open Sans', sans-serif;">Potable Water Supply</h1></center>
  </div>
</div>
<div class="row">
    <div class="col s8 offset-s2">
      <ul class="tabs">
        <li class="tab col s3"><a href="#test1">Quality</a></li>
        <li class="tab col s3"><a href="#test2">Quantity</a></li>
        
      </ul>
    </div>
    
    
  </div>

<div class="row">
<div id="test1" class="col s8 offset-s2" style="padding: 0;">
        <div class="taskHead cyan accent-4" ><h5>Quality Load</h5></div>
        <table class="bordered">
              <thead>
                  <tr>
                      <th data-field="id">Parent ID</th>
                      <th data-field="name">House ID</th>
                      <th data-field="qual">Quality</th>
                  </tr>
              </thead>
              <tbody id="tableBody">
                  
              </tbody>
            </table>
</div>
<div id="test2" class="col s8 offset-s2" style="padding: 0;">
        <div class="taskHead cyan accent-4" ><h5>Quantity Load</h5></div>
        <table class="bordered">
              <thead>
                  <tr>
                      <th data-field="id">Parent ID</th>
                      <th data-field="name">Difference</th>
                  </tr>
              </thead>
              <tbody id="tableBody2">
                  
              </tbody>
            </table>
</div>
</div>




<script type="text/javascript" src="js/supplier.js"></script>
</body>
</html>