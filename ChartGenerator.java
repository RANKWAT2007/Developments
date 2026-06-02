package utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;

public class ChartGenerator {

    public static void generateChart() {

        DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        // Sample stock prices
        dataset.setValue(3500,
                "Price",
                "Day 1");

        dataset.setValue(3550,
                "Price",
                "Day 2");

        dataset.setValue(3480,
                "Price",
                "Day 3");

        dataset.setValue(3600,
                "Price",
                "Day 4");

        dataset.setValue(3700,
                "Price",
                "Day 5");

        // Create chart
        JFreeChart chart
                = ChartFactory.createLineChart(
                        "TCS Stock Price",
                        "Days",
                        "Price",
                        dataset);

        // Display chart
        ChartFrame frame
                = new ChartFrame(
                        "Stock Chart",
                        chart);

        frame.setSize(800, 600);

        frame.setVisible(true);
    }
}
