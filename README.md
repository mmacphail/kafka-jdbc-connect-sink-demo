# Custom connect

## Connector customisation example
https://github.com/confluentinc/cp-all-in-one/blob/6.0.0-post/Docker/Dockerfile

## Connect docker env parameters
https://github.com/confluentinc/cp-all-in-one/blob/6.0.0-post/cp-all-in-one-cloud/docker-compose.connect.local.yml

## Connector config properties
https://docs.confluent.io/kafka-connect-jdbc/current/sink-connector/sink_config_options.html

## Connect REST Api
https://docs.confluent.io/platform/current/connect/references/restapi.html

## Connect Worker Config
https://docs.confluent.io/platform/current/connect/references/allconfigs.html

## Converters deep dive
https://www.confluent.fr/blog/kafka-connect-deep-dive-converters-serialization-explained/#json-schemas

## Create the topic

kafka-topics --bootstrap-server kafka1:9092 --create --topic traces --replication-factor 3 --partitions 3

## Post the connector

curl -X POST -H "Content-Type: application/json" http://connect:8083/connectors --data @connector-config.json
