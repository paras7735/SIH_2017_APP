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
  <title></title>
  <script src="js/jquery.min.js"></script>
  <script src="js/materialize.min.js"></script>
  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  <link type="text/css" rel="stylesheet" href="css/index.css"  media="screen,projection"/>
  <script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">

<style type="text/css">

body {
        font-family: "Lato Light", Arial; 
        height: 100%;
       
      }
  #quali_bubble{
    opacity: 0;
    transition: opacity 0.8s;
  }
  #quant_bubble{
    opacity: 0;
    transition: opacity 0.8s;
  }
  #node6{
    opacity: 0;
    transition: opacity 0.8s;
  }
  #quali{
    transform: scale(0.6);
    transition: transform 0.5s;
  }
  #quali:hover{
    transform: scale(0.7);
    cursor: pointer;
  }
  #quant{
    transform: scale(0.6);
    transition: transform 0.5s;
  }
  #quant:hover{
    transform: scale(0.7);
    cursor: pointer;
  }
  .row .col{
    padding: 0;
  }
td{
    word-wrap: break-word;
    width: 20px;
  }

</style>
</head>
<body style="background:url(images/back.png);">

<div class="navbar-fixed" style="height: 50px;">
<nav style="height: 50px;line-height: 50px;background-color:rgba(187,28,33,0.95);z-index: 100;">
    <div class="nav-wrapper" >
      <a href="supplier.php" class="brand-logo" style="margin-left: 15px;font-family: 'Open Sans', sans-serif;font-size: 1.2rem;">Alchemist</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down" style="font-family: 'Open Sans', sans-serif;">
        <li><a href="profile.html"><img src="images/user.png" style="transform: scale(1);float: left;margin-top: 11px;left: -10px;"> Profile</a></li>
        <li><a href="contact.php"><img src="images/contact.png" style="transform: scale(0.95);float: left;margin-top: 10px;margin-left: -2px;">Contact List</a></li>
        <li><a id="lout"><img src="images/logout1.png" style="float: left;margin-left: -5px;margin-top: 12px;">Logout</a></li>
      </ul>
    </div>
  </nav>
  </div>
<div class="row" style="padding: 0;">
<div class="col s8">
<ul id="slide-out" class="side-nav" style="background-color: rgba(255,255,255,0.95); ">
    <li><center><h1 style="font-size: 30px;color: #324A5E;">Nodal Network</h1></center></li>
    <li><img src="images/flowchart.png" style="margin-left: 50px;"></li>
  </ul>
<div>
<a href="#" data-activates="slide-out" class="button-collapse">
<div id="click-toggle-circle">
<div id ="click-toggle-arrow">
</div>
</div>
</a>
<p style="position:fixed;margin-top: 290px;margin-left: 15px;color: #206168;font-weight: bolder;" id="node6">Nodal Network</p>
</div>
<div class="row">

<div class="col s12 " style="background-color: rgb(226,34,45);padding: 0;">

  <center><h1 style="color:white;font-size: 3.2rem;padding: 15px;">Potable Water Supply</h1></center>
  </div>
  
</div>

<div class="row">
  <div class="col s6">
    <div style="background: url(images/8.png);width:300px ;height:300px; margin-left: 120px;">
    <a href="#modal2" class="modal-trigger"><img id="quali" src="images/2.png" style="z-index: 80;margin-left: 32px;margin-top: -10px;"></a>
    <center><p style="font-size: 15px;margin-top: -50px;color: white;" id="quali_bubble">Quality Problems</p></center>
    </div>
  </div>
  <div class="col s4">
    <div style="background: url(images/8.png);width:300px ;height:300px;margin-left: 40px;">
    <a href="#modal3" class="modal-trigger"><img id="quant" src="images/3.png" style="z-index: 80;margin-left: 32px;margin-top: -10px;"></a>
    <center><p style="font-size: 15px;margin-top: -50px;color: white;" id="quant_bubble">Quantity Problems</p></center>
    </div>
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
            <table class="bordered responsive-table">
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


</div>
<div class="col s4" style="background-color: rgba(255,255,255,0.85);height: 614px;padding: -10px;position:relative;margin:0;margin-top: -100px;overflow-y: scroll;">
<br><br><br><br>
  <table class="responsive-table striped" style="float: bottom;position: absolute;">
    <thead >
      <tr><center><h1>Complaints</h1></center></tr>
      <tr>
        <th data-field="id">Contact</th>
        <th data-field="name">Email</th>
        <th data-field="name">Complaint</th>
        <th data-field="name">Type</th>
      </tr>    
    </thead>
    <tbody id="tableBody7">
      
    </tbody>
  </table>
    
</div>
</div>
<div class="row" style="color: white;"><div class="sol s12">
  <center><span style="transform: scale(1.2);">&#169;Copyright Team Alchemist, IIT Kharagpur | Smart India Hackathon'17</span></center>
</div></div>

<script type="text/javascript" src="js/supplier.js"></script>
</body>
</html>