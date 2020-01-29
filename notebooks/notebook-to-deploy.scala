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

val filename = "/dbfs/FileStore/environment/" + env + ".properties"
val properties: Properties = new Properties()
val source = Source.fromFile(filename)
properties.load(source.bufferedReader())
   
val myVar = properties.getProperty("myVar")
println(myVar)

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC #### Push du Notebook sur Bitbucket

// COMMAND ----------

// MAGIC %sh
// MAGIC 
// MAGIC # Remember to remove the https:// prefix
// MAGIC #GIT_REPOSITORY=git.direct-energie.com/scm/dat/databricks-test-deploy.git
// MAGIC #GIT_BRANCH=dev
// MAGIC #This path should already exists
// MAGIC #GIT_PATH_TO_DEPLOY_NOTEBOOK=notebooks/notebook-to-deploy.scala 
// MAGIC #GIT_COMMIT_MESSAGE="First push try"
// MAGIC 
// MAGIC #GIT_URL="https://integrator:NzcwNTg5NTU3ODU3OgML8Kp24CGeERLqjLeHmjxXN2av@$GIT_REPOSITORY"
// MAGIC 
// MAGIC #git clone $GIT_URL

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC #### Tag de la version sur Bitbucket

// COMMAND ----------

//TODO

// COMMAND ----------

// MAGIC %sh
// MAGIC 
// MAGIC ping git.direct-energie.com

// COMMAND ----------

