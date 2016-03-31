package in.org.verkstad.inception;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {
    XYSeries series;
    LinearLayout linechart,barchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barchart = (LinearLayout) findViewById(R.id.barchart);
        linechart = (LinearLayout) findViewById(R.id.linechart);
        display_barchart();
        display_linechart();



    }

    public void display_linechart(){
        series = new XYSeries("Temperature hourly");
        for(int hour=-20;hour<20;hour++){
            series.add(hour,2*hour*hour+15);
        }
        // Now we create the renderer
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setLineWidth(2);
        renderer.setColor(Color.RED);
        // Include low and max value
        renderer.setDisplayBoundingPoints(true);
        // we add point markers
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth(3);

        XYMultipleSeriesRenderer multipleSeriesRenderer = new XYMultipleSeriesRenderer();
        multipleSeriesRenderer.addSeriesRenderer(renderer);
        multipleSeriesRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
        multipleSeriesRenderer.setPanEnabled(false, false);
        multipleSeriesRenderer.setShowGrid(true); // we show the grid

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);

        GraphicalView graphicalView = ChartFactory.getLineChartView(MainActivity.this,dataset,multipleSeriesRenderer);
        linechart.addView(graphicalView);
    }

    public void display_barchart(){
        series = new XYSeries("Bar Graph");
        for(int hour=1;hour<3;hour++){
            series.add(hour,20);
        }
        for(int hour=4;hour<6;hour++){
            series.add(hour,15);
        }
        for(int hour=7;hour<9;hour++){
            series.add(hour,25);
        }
        for(int hour=10;hour<12;hour++){
            series.add(hour,10);
        }
        // Now we create the renderer
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setLineWidth(2);
        renderer.setColor(Color.RED);
        // Include low and max value
        renderer.setDisplayBoundingPoints(true);
        // we add point markers
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth(3);

        XYMultipleSeriesRenderer multipleSeriesRenderer = new XYMultipleSeriesRenderer();
        multipleSeriesRenderer.addSeriesRenderer(renderer);
        multipleSeriesRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
        multipleSeriesRenderer.setPanEnabled(false, false);
        multipleSeriesRenderer.setShowGrid(true); // we show the grid

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);
        GraphicalView barchartview = ChartFactory.getBarChartView(MainActivity.this, dataset, multipleSeriesRenderer, BarChart.Type.DEFAULT);
        barchart.addView(barchartview);


    }

    public void show_contacts(View view){
        Intent intent = new Intent(this,popupcontacts.class);
        startActivity(intent);

    }
}
