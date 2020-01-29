// Databricks notebook source
// MAGIC %md
// MAGIC #### Create and store dev.properties files in dbfs

// COMMAND ----------

val content = """adlsPrefix=adl://tdedatalakedev.azuredatalakestore.net
atomePath=/datalake/rawdata/atome/streaming/year=2020/month=1/day=1/hour=0/minute=0/*.parquet"""

dbutils.fs.put(
    "/FileStore/databricks-test-deploy/dev.properties",
    content,
    true
)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Create and store prod.properties files in dbfs

// COMMAND ----------

val content = """adlsPrefix=adl://tdedatalake.azuredatalakestore.net
atomePath=/datalake/rawdata/atome/streaming/year=2020/month=1/day=1/hour=0/minute=0/*.parquet"""

dbutils.fs.put(
    "/FileStore/databricks-test-deploy/prod.properties",
    content,
    true
)