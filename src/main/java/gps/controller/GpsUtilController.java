package gps.controller;

import gps.exception.UUIDException;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import gps.service.GpsUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GpsUtilController {

    private Logger logger = LoggerFactory.getLogger(GpsUtilController.class);

    @Autowired
    GpsUtilService gpsUtilService;

    @GetMapping("/getUserLocation")
    public VisitedLocation getUserLocationServer(@RequestParam String userId) throws UUIDException {
        UUID userIdUUID = null;
        try {
            logger.debug("Start getUserLocationServer at /getUserLocation for userId : " + userId );
            userIdUUID = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            throw new UUIDException(userId);
        }
        return gpsUtilService.getUserLocationGpsUtil(userIdUUID);
    }

    @GetMapping("/getAllAttractions")
    public List<Attraction> getAllAttractionsServer() {
        logger.debug("Start getAllAttractionsServer at /getAllAttractions");
        List<Attraction> attractionList = gpsUtilService.getAttractionsGpsUtil();
        return attractionList;
    }
}