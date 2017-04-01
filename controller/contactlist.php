<?php

include '../connect.php';

	$result =$user->contact_list();
	print_r(json_encode($result));

	
?>