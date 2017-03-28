<?php

include '../connect.php';
if( isset($_POST["level"]) && isset($_POST["parent"]) && isset($_POST["level_index"]) && isset($_POST["home"]) && isset($_POST["quality"]) && isset($_POST["quantity"]) && isset($_POST["userId"])){
	$level=$_POST["level"];
	$level_index=$_POST["level_index"];
	$parent=$_POST["parent"];
	$home=$_POST["home"];
	$quality=$_POST["quality"];
	$quantity=$_POST["quantity"];
	$userId=$_POST["userId"];
	$result =$user->enter_readings($level,$parent,$level_index,$home,$quality,$quantity,$userId);
	print($result);
	}
	else {echo "string";}
	
?>