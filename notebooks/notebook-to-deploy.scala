// Databricks notebook source
// MAGIC %md
// MAGIC #### Ajout d'un widget pour gérer l'environement

// COMMAND ----------

dbutils.widgets.dropdown("env", "dev", Array("dev", "prod"))
val env = dbutils.widgets.get("env")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Initialisation des variables selon l'environement

// COMMAND ----------

var adlsPrefix: String = null
var atomePath: String = null
if (env == "dev") {
  adlsPrefix = "adl://tdedatalakedev.azuredatalakestore.net"
  atomePath = "/datalake/rawdata/atome/stream/year=2019/month=7/day=10/hour=0/minute=0/*.parquet"
} else {
  adlsPrefix = "adl://tdedatalake.azuredatalakestore.net"
  atomePath = "/datalake/rawdata/atome/streaming/year=2020/month=1/day=1/hour=0/minute=0/*.parquet"
}

spark.conf.set("fs.adl.oauth2.access.token.provider.type", "ClientCredential")
spark.conf.set("fs.adl.oauth2.client.id", dbutils.secrets.get(scope = "azure", key = "atome_client_id"))
spark.conf.set("fs.adl.oauth2.credential", dbutils.secrets.get(scope = "azure", key = "atome_credential"))
spark.conf.set("fs.adl.oauth2.refresh.url", dbutils.secrets.get(scope = "azure", key = "refresh_url"))

// COMMAND ----------

println("Ce print a été ajouté dans la version v2.0.0")
spark.read.parquet(adlsPrefix + atomePath).count()