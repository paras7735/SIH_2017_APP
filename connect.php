<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
session_start();
ob_start();
date_default_timezone_set('Asia/Kolkata');
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sihapp";
try
{
    $conn = new PDO("mysql:host={$servername};dbname={$dbname}",$username,$password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);   
}
catch(PDOException $e)
{
    echo $e->getMessage();
    die();
}
require_once "modals/user.php";

$user = new User($conn);
?>