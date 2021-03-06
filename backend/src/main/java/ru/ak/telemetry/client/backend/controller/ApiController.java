package ru.ak.telemetry.client.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ak.telemetry.client.backend.entity.Cpu;
import ru.ak.telemetry.client.backend.entity.FileSystem;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;
import ru.ak.telemetry.client.backend.entity.Sensor;
import ru.ak.telemetry.client.backend.scanner.ScannerCpu;
import ru.ak.telemetry.client.backend.scanner.ScannerFileSystems;
import ru.ak.telemetry.client.backend.scanner.ScannerSensors;

import java.util.List;

/**
 * @author a.kakushin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ApiController {

    @Autowired
    ScannerSensors scannerSensors;

    @Autowired
    ScannerFileSystems scannerFileSystems;

    @Autowired
    ScannerCpu scannerCpu;

    @Autowired
    OperatingSystem operatingSystem;

    @GetMapping("/filesystems")
    public List<FileSystem> getFileSystems() {
        return scannerFileSystems.getList();
    }

    @GetMapping("/sensors")
    public List<Sensor> getSensors() {
        return scannerSensors.getList();
    }

    @GetMapping("/os")
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    @GetMapping("/cpu")
    public Cpu getCpu() {
        return scannerCpu.get();
    }
}
