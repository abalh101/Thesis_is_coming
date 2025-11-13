package com.example.thesis_is_coming.domainModel;

import java.time.LocalDate;

//Entity -> hat eine eigene ID
public record Datei (
        Integer DateiID,
        String systemDateiName,
        String OptionaleBeschreibung,
        LocalDate uploadDatum,
        DateiTyp dateiTyp
) {

    // Diese Datei "gehört" einem Aggregat (Betreuer oder Thema).
    // Die Zuordnung erfolgt im Aggregat selbst.

};
