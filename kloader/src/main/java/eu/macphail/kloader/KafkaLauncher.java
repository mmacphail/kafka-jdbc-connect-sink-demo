package eu.macphail.kloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

@Service
public class KafkaLauncher {

    private static final Logger log = LoggerFactory.getLogger(KafkaLauncher.class);

    @Autowired
    KafkaTemplate<String, String> template;

    AtomicLong counter = new AtomicLong(1);

    @PostConstruct
    public void init() {
        IntStream.range(0, 1_000_000)
                .mapToObj(this::sendTrace)
                .forEach(f -> f.addCallback(success -> {
                }, failure -> {
                    log.error(failure.getMessage());
                    failure.printStackTrace();
                }));
        log.info("Ended sending messages");
    }

    private ListenableFuture<SendResult<String, String>> sendTrace(int i) {
        long id = counter.incrementAndGet();
        String jsonString = "{\n" +
                "  \"schema\": {\n" +
                "    \"type\": \"struct\",\n" +
                "    \"fields\": [\n" +
                "      {\n" +
                "        \"type\": \"int64\",\n" +
                "        \"optional\": false,\n" +
                "        \"field\": \"registertime\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"string\",\n" +
                "        \"optional\": false,\n" +
                "        \"field\": \"userid\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"string\",\n" +
                "        \"optional\": false,\n" +
                "        \"field\": \"regionid\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": \"string\",\n" +
                "        \"optional\": false,\n" +
                "        \"field\": \"gender\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"optional\": false,\n" +
                "    \"name\": \"ksql.users\"\n" +
                "  },\n" +
                "  \"payload\": {\n" +
                "    \"registertime\": 1493819497170,\n" +
                "    \"userid\": \"%s\",\n" +
                "    \"regionid\": \"Region_5\",\n" +
                "    \"gender\": \"MALE\"\n" +
                "  }\n" +
                "}";
        String payload = String.format(jsonString, Long.toString(id));
        return template.send("traces", Long.toString(id), payload);
    }

}
