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

/**
 * GPS UTIL CONTROLLER USED AS A MICROSERVICE FOR THE MAIN APP TOUR-GUIDE
 */
@RestController
public class GpsUtilController {

    private Logger logger = LoggerFactory.getLogger(GpsUtilController.class);

    @Autowired
    GpsUtilService gpsUtilService;

    /**
     * HTML GET request that returns a visited location
     * @param userId the UUID of the userId in a form of a string
     * @return the Visited location model of a specific userId
     * @throws UUIDException
     */
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

    /**
     * HTML GET request that returns a list of attractions
     * @return a list of all attractions
     */
    @GetMapping("/getAllAttractions")
    public List<Attraction> getAllAttractionsServer() {
        logger.debug("Start getAllAttractionsServer at /getAllAttractions");
        List<Attraction> attractionList = gpsUtilService.getAttractionsGpsUtil();
        return attractionList;
    }
}
