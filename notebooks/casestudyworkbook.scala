// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "9cb6757c-089f-4a2a-ad6f-194cd332593f",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "training-scope", key = "dlstoken"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/05faa093-281a-41fc-a6a4-6d3c0742bca4/oauth2/token")

dbutils.fs.mount(
  source = "abfss://data@rammadadatastore.dfs.core.windows.net/",
  mountPoint = "/mnt/data",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %fs
// MAGIC 
// MAGIC ls /mnt/data

// COMMAND ----------

