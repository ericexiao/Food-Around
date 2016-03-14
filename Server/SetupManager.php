<?php
	require "SQLAdminManager.php";
	require "FileExtractor.php";

	class SetupManager {
		private final $SETUP_FINAL_CONSTANT = "list.txt";
		public function setup() {

		}

		private function {
			$file = fopen($SETUP_FINAL_CONSTANT, "r"); 

		}
		
		$totalFiles = 0; //tracks the number of files passed 
		$conversionCounter = 0; //tracks the number of files successfully converted

		if ($file) {
			$fileExtractor = new FileExtractor(); 
			$SQLManager = new SQLAdminManager(); 
			while ($line = fgets($file)) {
				$totalFiles++;
				$split = split("::", $line);
				$restaurantName= $split[0];
				$restaurantInfoFile = $split[1];
				$restaurantMenuFile = $split[2];		
				$menuTable = $split[3];

				$infoDataArray = $fileExtractor -> extractInfo($restaurantName, $restaurantInfoFile);
				$menuDataArray = $fileExtractor -> extractMenu($restaurantName, $restaurantMenuFile);
				
				//Take the data arrays from above and insert into db. True if query execution is successful, false otherwise. Handle results appropriately
				$result = $SQLManager -> insertRestaurant($restaurantName, $infoDataArray, $menuDataArray);
				if ($result[0] === true) {
					$conversionCounter++;
				} else {
					if ($result[1] === false) { //if the info failed to be inserted
						echo($restaurantName . " failed to convert properly (" . $restaurantInfoFile . ") <br>"));
						foreach()
					}
					if ($result[2] === false) {
						echo($restaurantName . " failed to convert properly (" . $restaurantMenuFile . ") <br>"));
					} 
				}
			}
			echo ($conversionCounter . " out of " . $totalFiles . " converted successfully");
		} else {
			echo "$filename could not be found, could not execute database setup.";
		}
		function
	}
?>