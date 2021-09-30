package com.example.assignmentbyharsh.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignmentbyharsh.R
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.GridLabelRenderer
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class GraphFragment : Fragment() {
    private val yValues = arrayListOf(2, 1, 1, 2, 3, 2, 4)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_graph, container, false)
        val graph = view.findViewById<View>(R.id.graphView) as GraphView
        val series = LineGraphSeries(
            data()
        )
        series.isDrawDataPoints = true
        graph.viewport.setMinX(0.0)
        graph.viewport.setMaxY(0.0)
        graph.viewport.setMaxY(4.0)
        graph.viewport.setMaxX(9.0)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.isXAxisBoundsManual = true
        graph.addSeries(series)
        val gridLabel: GridLabelRenderer = graph.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "X Axis"
        gridLabel.verticalAxisTitle = "Y Axis"
        return view
    }

    private fun data(): Array<DataPoint?> {
        val values =
            arrayOfNulls<DataPoint>(yValues.size) //creating an object of type DataPoint[] of size 'n'
        for (i in 0 until yValues.size) {
            val v = DataPoint((i + 1).toDouble(), yValues[i].toDouble())
            values[i] = v
        }
        return values
    }
}