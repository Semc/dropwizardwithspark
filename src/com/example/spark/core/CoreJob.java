package com.example.spark.core;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.apache.spark.SparkConf;

public class CoreJob {
	
	public static void main(String[] args){
		
		String driverHost = null;
		try {
			driverHost = Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		int driverPort = 7777;
		
		SparkConf conf = new SparkConf()
		.setAppName("SparkAkkaExample")
		.setMaster("local[4]")
		.set("spark.driver.host", driverHost)
		.set("spark.driver.port", String.valueOf(driverPort));
		
		
	}
	
}
