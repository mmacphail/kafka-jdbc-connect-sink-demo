FROM confluentinc/cp-server-connect-base:6.0.0

ENV CONNECT_PLUGIN_PATH="/usr/share/java,/usr/share/confluent-hub-components"

COPY confluentinc-kafka-connect-jdbc-10.0.1.zip /tmp
RUN confluent-hub install --no-prompt /tmp/confluentinc-kafka-connect-jdbc-10.0.1.zip