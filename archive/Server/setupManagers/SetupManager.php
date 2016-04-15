<?php
	require "SQLAdminManager.php";
	require "FileExtractor.php";

	public class SetupManager {
		private $filename; //constant holding the file needed for setup
		private $SQLManager;

		public $totalFiles = 0; //int, tracks the number of files passed 
		public $conversionCounter = 0; //int, tracks the number of files successfully converted

		//final constants for file control
		private final $SEED_SETUP_PROTOCOL = 0;
		private final $SEED_FILE_FINAL_CONSTANT = "list.txt"; //manifesto file for FoodAround db

		//basic construct, for single manifest setups
		public function __construct() {

		}

		//construct for manifest lists for origin setups
		public function __construct($protocol) {
			if ($protocal === $SEED_SETUP_PROTOCOL) {
				$filename = $SEED_FILE_FINAL_CONSTANT;
			}
		}

		//wrapper function for initial seed setup. Probably can use for bulk add-ons to the server as well  
		public function completeSetup() {
			$restaurantName, $restaurantInfoFile, $restaurantMenuFile;
			$infoDataArray, $menuDataArray;

			if ($filename !== null) {
				$file = fopen($filename, "r"); 
				
				if ($file) {
					while ($line = fgets($file)) {
						if ($this -> extractRestaurant($restaurantName, $restaurantInfoFile, $restaurantMenuFile, $line)) {
							if ($this -> populateDataArrays()) {
								$insertResult = $this -> createRestaurant($restaurantName, $infoDataArray, $menuDataArray);
								if ($result[1] === false) { //if the info failed to be inserted
									echo($restaurantName . " failed to convert properly (" . $restaurantInfoFile . ") <br>"));
									dumpArray($infoDataArray);
								}
								if ($result[2] === false) {
									echo($restaurantName . " failed to convert properly (" . $restaurantMenuFile . ") <br>"));
									dumpArray($menuDataArray);
								} 
				}
			}
				echo ($conversionCounter . " out of " . $totalFiles . " converted successfully");
			} else {
				echo "$filename could not be found, could not execute database setup. Check the seed filename.";
			}
		}

		//Setting up a single restaurant's manifest file. 
		public function singleSetup($restaurantName, $infoFilename, $menuFilename) {

		}

		//takes a line from the manifest file and seperates the file schema
		private function extractRestaurant($name, $infoFile, $menuFile, $line){
			$totalFiles++;
			$split = split("::", $line);
			$restaurantName= $split[0];
			$restaurantInfoFile = $split[1];
			$restaurantMenuFile = $split[2];
		}
		
		//populates the arrays in parameters with info from the restaurant manifestos to be used for SQL insertion
		private function populateDataArrays($infoDataArray, $menuDataArray) {
			$fileExtractor = new FileExtractor();
			$infoDataArray = $fileExtractor -> extractInfo($restaurantName, $restaurantInfoFile);
			$menuDataArray = $fileExtractor -> extractMenu($restaurantName, $restaurantMenuFile);
		}

		//calls the SQLManager 
		private function insertRestaurantData($restaurantName, $infoDataArray, $menuDataArray) {
			$SQLManager = new SQLAdminManager();
			return $SQLManager -> insertRestaurant($restaurantName, $infoDataArray, $menuDataArray);
		}
		
		//Array dump for error sifting
		private function dumpArray($array) {
			echo ("<pre>");
			print_r($array);
			echo ("/pre>");
		}
	}
?>