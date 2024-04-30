package org.example.services;

import org.example.entities.Departure;
import org.example.entities.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;

@Service
public class SchedulerService implements ScheduleServiceMBean {
    private final String backUpsDir = "pract_22/src/main/backups";
    private final DepartureServiceImpl departureService;
    private final PostOfficeServiceImpl postOfficeService;

    @Autowired
    public SchedulerService(DepartureServiceImpl departureService, PostOfficeServiceImpl postOfficeService) {
        this.departureService = departureService;
        this.postOfficeService = postOfficeService;
    }

    @Scheduled(cron = "* */30 * * * *")
    public void backupFromDatabase() throws IOException {
        File file_dir = ResourceUtils.getFile(backUpsDir);
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) {
                    file.delete();
                }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        BufferedWriter departures = new BufferedWriter(new FileWriter(backUpsDir + "/departures_data.txt"));
        BufferedWriter postOffices = new BufferedWriter(new FileWriter(backUpsDir + "/post-offices_data.txt"));

        for (Departure item : departureService.readAll()) {
            departures.write(item.toString());
            departures.write('\n');
        }
        departures.close();

        for (PostOffice item : postOfficeService.readAll()) {
            postOffices.write(item.toString());
            postOffices.write('\n');
        }
        postOffices.close();

    }
}
