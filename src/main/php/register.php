<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
if(isset($_POST['submit'])) {
  $name = $_POST['name'];
  $surname = $_POST['surname'];
  $email = $_POST['email'];
  $password = $_POST['password'];
  $password2 = $_POST['password2'];
  $role_id = $_POST['role_id'];

  if(empty($name) || empty($surname) || empty($email) || empty($password) || empty($password2) || empty($role_id)) {
    echo "Proszę wypełnić wszystkie pola";
  } else {
    if($password != $password2) {
      echo "Hasła nie są identyczne";
    } else {
      // Hashowanie hasła
      $password = password_hash($password, PASSWORD_DEFAULT);
      
      // Połączenie z bazą danych
      $connection = mysqli_connect('localhost', 'root', '', 'workspace');
      if(!$connection) {
        die("Błąd połączenia z bazą danych: " . mysqli_connect_error());
      }

      // Sprawdzenie, czy adres e-mail jest już zarejestrowany
      $query = "SELECT * FROM pracownicy WHERE email='$email'";
      $result = mysqli_query($connection, $query);
      if(mysqli_num_rows($result) > 0) {
        echo "Ten adres e-mail jest już zarejestrowany";
      } else {
        // Wprowadzenie danych do bazy danych
        $query = "INSERT INTO pracownicy (imie, nazwisko, rola_id, email, password) VALUES ('$name', '$surname', '$role_id', '$email', '$password')";
        if(mysqli_query($connection, $query)) {
          echo "Rejestracja powiodła się";
        } else {
          echo "Błąd: " . $query . "<br>" . mysqli_error($connection);
        }
      }

      // Zakończenie połączenia z bazą danych
      mysqli_close($connection);
    }
  }
}
