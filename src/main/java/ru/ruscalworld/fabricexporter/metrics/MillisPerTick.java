package ru.ruscalworld.fabricexporter.metrics;

import me.lucko.spark.api.statistic.StatisticWindow;
import me.lucko.spark.api.statistic.misc.DoubleAverageInfo;
import me.lucko.spark.api.statistic.types.GenericStatistic;
import ru.ruscalworld.fabricexporter.FabricExporter;

public class MillisPerTick extends SparkMetric {
    public MillisPerTick() {
        super("mspt", "Milliseconds per tick (MSPT)");
    }

    @Override
    public void update(FabricExporter exporter) {
        GenericStatistic<DoubleAverageInfo, StatisticWindow.MillisPerTick> mspt = this.getSpark().mspt();
        if (mspt == null) this.getGauge().set(0);
        else this.getGauge().set(mspt.poll(StatisticWindow.MillisPerTick.MINUTES_1).mean());
    }
}
