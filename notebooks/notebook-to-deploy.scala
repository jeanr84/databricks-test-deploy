// Databricks notebook source
// MAGIC %md
// MAGIC #### Add widgets to get the environement

// COMMAND ----------

dbutils.widgets.dropdown("env", "dev", Array("dev", "prod"))
val env = dbutils.widgets.get("env")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Get environement variables from files stored in dbfs

// COMMAND ----------

import java.util.Properties
import scala.io.Source

val filename = "/dbfs/FileStore/databricks-test-deploy/" + env + ".properties"
val properties: Properties = new Properties()
val source = Source.fromFile(filename)
properties.load(source.bufferedReader())
   
val adlsPrefix = properties.getProperty("adlsPrefix")
val atomePath = properties.getProperty("atomePath")
println(adlsPrefix)
println(atomePath)

// COMMAND ----------

spark.parquet(adlPrefix + atomePath).count()