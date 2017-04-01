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
<style type="text/css">
  #quali{
    transform: scale(0.8);
    transition: transform 0.5s;
  }
  #quali:hover{
    transform: scale(0.9);
    cursor: pointer;
  }
  #quant{
    transform: scale(0.8);
    transition: transform 0.5s;
  }
  #quant:hover{
    transform: scale(0.9);
    cursor: pointer;
  }
</style>
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

<div class="row">
<div class="col s8 offset-s2" style="background-color: rgb(226,34,45);">

  <center><h1 style="color:white;font-family: 'Open Sans', sans-serif;">Potable Water Supply</h1></center>
  </div>
</div>
<div class="row">
  <div class="col s3 offset-s1" style="margin-left: 175px;">
    <!-- <img src="images/1.png" style="transform: scale(0.8);z-index: 50;"> -->
    <div style="background: url(images/5.png);width:410px ;height:410px; margin-left: 70px;">
    <a href="#modal2" class="modal-trigger"><img id="quali" src="images/2.png" style="z-index: 80;margin-left: 85px;margin-top: 35px;"></a>
    </div>
  </div>
  <div class="col s3 offset-s1">
    <!-- <img src="images/1.png" style="transform: scale(0.8);z-index: 50;"> -->
    <div style="background: url(images/5.png);width:410px ;height:410px;margin-left: 55px;">
    <a href="#modal3" class="modal-trigger"><img id="quant" src="images/3.png" style="z-index: 80;margin-left: 85px;margin-top: 35px;"></a>
    </div>
  </div>
</div> 
<div id="modal4" class="modal modal-fixed-footer">
          <div class="modal-content">
            <h4>FlowChart</h4>
            <img src="images/flowchart.png" style="transform: scale(0.3);">
          </div>
          <div class="modal-footer">
            <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat ">Close</a>
          </div>
  </div>
  <div id="modal2" class="modal modal-fixed-footer">
          <div class="modal-content">
            <h4>Quality Problem</h4>
            <table class="bordered">
              <thead>
                  <tr>
                      <th data-field="id">Parent ID</th>
                      <th data-field="name">Meter ID</th>
                      <th data-field="qual">Quality</th>
                  </tr>
              </thead>
              <tbody id="tableBody">
                  
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat ">Close</a>
          </div>
        </div>

        <div id="modal3" class="modal modal-fixed-footer">
          <div class="modal-content">
            <h4>Quantity Problem</h4>
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
          <div class="modal-footer">
            <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat ">Close</a>
          </div>
        </div>



<script type="text/javascript" src="js/supplier.js"></script>
</body>
</html>