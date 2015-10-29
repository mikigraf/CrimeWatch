<?php
if(isset($_GET['lat'])) $lng = (double)$_GET['lat'];
if(isset($_GET['lng'])) $lat = (double)$_GET['lng'];

$db = new mysqli('localhost', 'jh2015', 'aesheiC3aidie3ku', 'jh2015');

if (mysqli_connect_errno() == 0 && isset($lat) && isset($lng))
{
    $sql = 'SELECT *, (3959 * acos(cos(radians('.$lat.')) * cos(radians(lat)) * cos(radians(lng) - radians('.$lng.')) + sin(radians('.$lat.')) * sin(radians(lat)))) AS distance FROM crimes HAVING distance < 5 ORDER BY distance;';
    $ergebnis = $db->query($sql);

    $i = 0;
    $num_rows = $ergebnis->num_rows;

    echo '{"type": "FeatureCollection",
           "features": [';
    while ($zeile = $ergebnis->fetch_object())
    {
        echo '{
		  "type": "Feature",
		  "geometry": {
			"type": "Point",
                        "coordinates": ['.$zeile->lng.', '.$zeile->lat.']
                  },
                  "properties": {
			"type": "'.$zeile->type.'",
                        "city": "'.$zeile->city.'",
			"details": "'.$zeile->details.'"
		  }
		}';
       $i++;
       if($i != $num_rows) echo ',';
    }
    echo ']}';

    $ergebnis->close();
}
else
{
    echo 'Die Datenbank konnte nicht erreicht werden. Folgender Fehler trat auf: <strong>' .mysqli_connect_errno(). ' : ' .mysqli_connect_error(). '</strong>';
}
$db->close();
