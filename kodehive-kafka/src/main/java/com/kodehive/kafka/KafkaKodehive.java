package com.kodehive.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaKodehive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties prop = new Properties();

		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

		for (int i = 0; i < 10; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic-java-1",
					"Masuk Data ke " + i);
			producer.send(record);
		}

		producer.close();

	}

}
