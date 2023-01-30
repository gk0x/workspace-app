<?php
if(isset($_POST['submit'])) {
  $name = $_POST['name'];
  $surname = $_POST['surname'];
  $email = $_POST['email'];
  $password = $_POST['password'];
  $password2 = $_POST['password2'];

  if(empty($name) || empty($surname) || empty($email) || empty($password) || empty($password2)) {
    echo "Proszę wypełnić wszystkie pola";
  } else {
    if($password != $password2) {
      echo "Hasła nie są identyczne";
    }
  }
}
?>
