<?php
require_once 'connect.php';
if($user->is_not_logged_in()) {
	header('Location: login.php');
}
else if($user->is_logged_in() && $_SESSION['position']==1){
	header('Location: supplier.php');
}
else if($user->is_logged_in() && $_SESSION['position']==0){
	header('Location: user.php');
}

?>
<!DOCTYPE html>
<html>
<head>
	<title></title>
  <script src="https://www.gstatic.com/firebasejs/3.7.2/firebase.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
  
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
<center><h1>Admin</h1></center>
<div class="row">
    <form class="col s10" id="form1">
      <div class="row">
        <div class="input-field col s5">
          <input id="level" type="text" class="validate">
          <label for="level">Level</label>
        </div>
        <div class="input-field col s5">
          <input id="parent" type="text" class="validate">
          <label for="parent">Parent</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5">
          <input id="level_index" type="text" class="validate">
          <label for="level_index">Level Index</label>
        </div>
        <div class="input-field col s5">
          <input id="home" type="text" class="validate">
          <label for="home">Home(0 or 1)</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s5">
          <input id="quality" type="text" class="validate">
          <label for="quality">Quality</label>
        </div>
        <div class="input-field col s5">
          <input id="quantity" type="text" class="validate">
          <label for="quantity">Quantity</label>
        </div>
        <div class="input-field col s5">
          <input id="userId" type="text" class="validate">
          <label for="userId">User ID</label>
        </div>
      </div>
    </form>

</div>
<button class="btn" id="submitread">Update</button>
<button class="btn" id="newNode">Add Node</button>


<a class="waves-effect waves-light btn" id="lout">Logout</a>

<script type="text/javascript" src="js/index.js"></script>
</body>
</html>