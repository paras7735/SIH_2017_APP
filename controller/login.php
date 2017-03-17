<?php

include '../connect.php';
if( isset($_POST["uname"]) && isset($_POST["pass"])){
	$uname=$_POST["uname"];
	$pass=$_POST["pass"];
	$result =$user->sign_in($uname,$pass);
	print_r($result);
	}
	else {echo "string";}
	
?>