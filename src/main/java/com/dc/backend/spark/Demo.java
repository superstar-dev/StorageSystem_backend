package com.dc.backend.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Demo {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf()
                .setAppName("Spark Demo")
                .setMaster("spark://127.0.0.1:7077");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.textFile("");
        System.out.println(data);
    }
}
