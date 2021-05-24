package ru.ruscalworld.fabricexporter.metrics;

import ru.ruscalworld.fabricexporter.FabricExporter;

public class OnlinePlayers extends Metric {
    public OnlinePlayers() {
        super("players_online", "Amount of currently online players on the server");
    }

    @Override
    public void update(FabricExporter exporter) {
        this.getGauge().set(exporter.getServer().getCurrentPlayerCount());
    }
}
