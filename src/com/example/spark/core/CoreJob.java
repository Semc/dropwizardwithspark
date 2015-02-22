package com.example.spark.core;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

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
		
		JavaStreamingContext jstream = new JavaStreamingContext(conf, Seconds.apply(1));
		JavaInputDStream<String> input = jstream.actorStream(props, name);
		
	}
	
}
