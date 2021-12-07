package consumerService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka


@SpringBootApplication
@EnableKafka
class ConsumerServiceApp

fun main(args: Array<String>) {
    runApplication<ConsumerServiceApp>(*args)
}



