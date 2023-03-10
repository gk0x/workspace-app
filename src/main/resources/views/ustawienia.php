<?php
session_start();
require_once('config.php');

$user_id = $_SESSION['user_id'];
?>

<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>

<body>
    <nav class="menu">
      <ul>
        <li><a href="aktualnosci.html">Aktualności</a></li>
        <li><a href="projekty.html">Projekty</a></li>
        <li><a href="chat.html">Chat</a></li>
        <li><a href="profil.html">Profil</a></li>
        <li><a href="#" id="ustawienia-link">Ustawienia</a></li>
        <li class="right"><a href="logout.php">Wyloguj się</a></li>
      </ul>
    </nav>

<div class = "sections">
      <section id="informacje">
        <details>
          <summary>Informacje <span>&#x25BC;</span></summary>
          <form>
            <label for="imie">Imię:</label>
            <input type="text" id="imie" name="imie" value="Jan" readonly>
            <label for="nazwisko">Nazwisko:</label>
            <input type="text" id="nazwisko" name="nazwisko" value="Kowalski" readonly>
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="1234" readonly>
            <label for="rola">Rola:</label>
            <input type="text" id="rola" name="rola" value="Pracownik" readonly>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="jan.kowalski@example.com">
            <button type="submit">Zapisz</button>
          </form>
        </details>
      </section>
      
      <section id="zmien-haslo">
        <details>
          <summary>Zmień hasło <span>&#x25BC;</span></summary>
          <form>
            <label for="stare-haslo">Stare hasło:</label>
            <input type="password" id="stare-haslo" name="stare-haslo">
            <label for="nowe-haslo">Nowe hasło:</label>
            <input type="password" id="nowe-haslo" name="nowe-haslo">
            <label for="powtorz-haslo">Powtórz hasło:</label>
            <input type="password" id="powtorz-haslo" name="powtorz-haslo">
            <button type="submit">Zapisz</button>
          </form>
        </details>
      </section>
      