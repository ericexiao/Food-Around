<?php
	//Wrapper file for booting up the SQL servers from text file 
	include("SQLAdminManager.php");

	$filename = "list.txt"; //file containing the list of the files to convert
	$file = fopen($filename, "r"); 

	$totalFiles = 0; //tracks the number of files passed 
	$conversionCounter = 0; //tracks the number of files successfully converted

	if ($file) {
		$fileReader = new SQLAdminManager();
		while ($line = fgets($file)) {
			$totalFiles++;
			$split = split("::", $line);
			$restaurantFile = $split[0];
			$restaurantTable = $split[1];
			if ($fileReader -> convertMenuFileToTable($restaurantFile, $restaurantTable)) { 
				$conversionCounter++;
			} else {
				echo($restaurantFile . " failed to convert. <br>");
			}
		}
		echo ($conversionCounter . " out of " . $totalFiles . " converted successfully");
	} else {
		echo "$filename could not be found, could not execute database setup.";
	}
?>