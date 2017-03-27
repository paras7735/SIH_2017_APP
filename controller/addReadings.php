<?php

include '../connect.php';
if( isset($_POST["level"]) && isset($_POST["parent"]) && isset($_POST["level_index"]) && isset($_POST["home"]) && isset($_POST["quality"]) && isset($_POST["quantity"])){
	$level=$_POST["level"];
	$level_index=$_POST["level_index"];
	$parent=$_POST["parent"];
	$home=$_POST["home"];
	$quality=$_POST["quality"];
	$quantity=$_POST["quantity"];
	$result =$user->new_readings($level,$parent,$level_index,$home,$quality,$quantity);
	print($result);
	}
	else {echo "string";}
	
?>