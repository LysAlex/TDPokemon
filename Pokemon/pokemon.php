<?php
$mysqli = mysqli_connect("localhost", "root", "sio", "pokemon");
if (mysqli_connect_errno($mysqli)) {
    echo "Echec lors de la connexion à MySQL : " . mysqli_connect_error();
}
$rqut = mysqli_query($mysqli, "SELECT * FROM `pokemon` ");
$row = $rqut->fetch_assoc();
$tot = 0;
$rslt = $mysqli->query("SELECT * FROM `pokemon` ");
$rslt->data_seek(0);


while ($row = $rslt->fetch_assoc()) {
    $tabPokemon[$tot] = $row;
    $tot++;
   }
$rslt->free();
$mysqli->close();
$json = json_encode($tabPokemon);
$fic = 'pokemon.json';
$ficJson = fopen($fic, 'w+'); 
 if ($fic) {
  fwrite($ficJson,$json);
  fclose($ficJson);
  print(" Fichier &eacute;crit...");
 }

 exit();
 ?>