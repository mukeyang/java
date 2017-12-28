package df;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by CS on 2017/12/18.
 */
public class testChart {

    public static void main(String[] args) throws IOException {

    }

    @Test
    public void testPieChart() throws IOException {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("5s", 20);
        dataset.setValue("6s", 50);
        dataset.setValue("7s", 10);
        dataset.setValue("8s", 40);
        JFreeChart chart = ChartFactory.createPieChart3D("Mobile", dataset, true, true, false);
        File des = new File("pieChart3d.jpeg");
        ChartUtilities.saveChartAsJPEG(des, chart, 640, 480);
    }

    @Test
    public void testBarChart() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1.0, "fiat", "speed");
        dataset.setValue(2.0, "fiat", "speed1");
        dataset.setValue(3.0, "fiat", "speed2");
        dataset.setValue(1.0, "fiat1", "speed");
        dataset.setValue(2.0, "fiat1", "speed1");
        dataset.setValue(3.0, "fiat1", "speed2");
        dataset.setValue(1.0, "fiat2", "speed");
        dataset.setValue(2.0, "fiat2", "speed1");
        dataset.setValue(3.0, "fiat2", "speed2");
        JFreeChart barChart = ChartFactory.createBarChart("test", "catagory", "score", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartUtilities.saveChartAsJPEG(new File("barchart.jpeg"),barChart,640,480);
    }

    @Test
    public void testLineChart() throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(15,"schools","1");
        dataset.setValue(30,"schools","2");
        dataset.setValue(50,"schools","3");
        dataset.setValue(10,"schools","4");
        dataset.setValue(5, "schools", "5");
        dataset.setValue(25,"schools1","1");
        dataset.setValue(20,"schools1","2");
        dataset.setValue(40,"schools1","3");
        dataset.setValue(20,"schools1","4");
        dataset.setValue(51, "schools1", "5");
        JFreeChart chart = ChartFactory.createLineChart("Loss", "iterator", "rmse", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();


        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) plot
                .getRenderer();
        lineandshaperenderer.setBaseShapesVisible(true);
        lineandshaperenderer.setBaseLinesVisible(true);
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseFillPaint(Color.white);
//        lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3.0F));
//        lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
//        lineandshaperenderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0,
//                10.0, 10.0));
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);
        ChartUtilities.saveChartAsJPEG(new File("line42.jpeg"), chart, 640, 480);
    }

    @Test
    public void testLi() {
        Path log = Paths.get("Log");
        System.out.println(log.toAbsolutePath());
    }
}
