# Welcome to kafka-jdbc-connect-sink-demo

This demo showcase how to use Confluent Connect docker image with a JDBC Sink. To run this demo, first run `docker-compose up -d`, then connect to the Kafka containter and create the topic, run the kloader app to supply data in it, and finally create the connector using curl.

# Documentation

## Config reference for docker
https://docs.confluent.io/current/installation/docker/config-reference.html

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

## JXM Exporter

https://github.com/wurstmeister/kafka-docker/blob/master/test/scenarios/jmx/docker-compose.yml

## Kafka metrics

https://docs.confluent.io/platform/current/kafka/monitoring.html

## Connect metrics

https://docs.confluent.io/home/connect/monitoring.html#using-jmx-to-monitor-kconnect

# Run the stack

## Create the topic

kafka-topics --bootstrap-server kafka1:9092 --create --topic traces --replication-factor 3 --partitions 3

## Post the connector

curl -X POST -H "Content-Type: application/json" http://connect:8083/connectors --data @connector-config.json

# Misc

## JMX Exporter

https://docs.confluent.io/platform/current/installation/docker/operations/monitoring.html