// Data model for a responsive data pipeline monitor

data class Pipeline(
    val id: Int,
    val name: String,
    val status: PipelineStatus,
    val throughput: Double, // in bytes per second
    val latency: Double, // in milliseconds
    val errorRate: Double // as a percentage
)

enum class PipelineStatus {
    RUNNING, PAUSED, FAILED
}

data class PipelineMetric(
    val timestamp: Long,
    val pipelineId: Int,
    val metricType: MetricType,
    val value: Double
)

enum class MetricType {
    THROUGHPUT, LATENCY, ERROR_RATE
}

data class PipelineAlert(
    val pipelineId: Int,
    val timestamp: Long,
    val message: String,
    val severity: AlertSeverity
)

enum class AlertSeverity {
    INFO, WARNING, ERROR
}

// Example usage:
fun main() {
    val pipeline = Pipeline(
        id = 1,
        name = "My Pipeline",
        status = PipelineStatus.RUNNING,
        throughput = 1000.0,
        latency = 50.0,
        errorRate = 0.1
    )

    val metric = PipelineMetric(
        timestamp = 1643723400,
        pipelineId = 1,
        metricType = MetricType.THROUGHPUT,
        value = 1500.0
    )

    val alert = PipelineAlert(
        pipelineId = 1,
        timestamp = 1643723410,
        message = "Throughput exceeded threshold",
        severity = AlertSeverity.WARNING
    )
}