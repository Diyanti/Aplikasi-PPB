<?php
	include "koneksi.php";

	$username = $_POST['email'];
	$password = $_POST['password'];


	$sql = "SELECT * FROM login WHERE email='$username' AND password='$password'";
	$result = mysqli_query($con, $sql);

	$cek = mysqli_affected_rows($con);

	if ($cek == 1) {
		echo "success";
	}
	else{
		echo "failur";
	}
?>
