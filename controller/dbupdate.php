<?php

include '../connect.php';

	$res2=$user->getwholetable();
	
	print_r(json_encode($res2)) ;
	

	
?>