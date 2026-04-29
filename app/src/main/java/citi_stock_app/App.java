package citi_stock_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {
    private Queue<String> stockQueue = new LinkedList<>();
    private XYChart.Series<String, Number> series = new XYChart.Series<>();
    private Random random = new Random();
    private double simulatedPrice = 38000.00;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void start(Stage stage) {
        stage.setTitle("Citi Real-time Stock Dashboard");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Price ($)");
        yAxis.setForceZeroInRange(false);

        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("DJIA Live Monitor");
        series.setName("Dow Jones Industrial Average");
        lineChart.getData().add(series);

        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();

        startDataStream();
    }

    private void startDataStream() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            simulatedPrice += (random.nextDouble() - 0.5) * 10;
            String time = timeFormat.format(new Date());
            
            stockQueue.add(time + " : $" + String.format("%.2f", simulatedPrice));

            Platform.runLater(() -> {
                series.getData().add(new XYChart.Data<>(time, simulatedPrice));
                if (series.getData().size() > 15) series.getData().remove(0);
                System.out.println("Update: " + time + " | Price: $" + String.format("%.2f", simulatedPrice));
            });
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        launch(args);
    }
}