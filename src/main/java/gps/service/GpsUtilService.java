package gps.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GpsUtilService {

    private Logger logger = LoggerFactory.getLogger(GpsUtilService.class);
    private final GpsUtil gpsUtil = new GpsUtil();

    /**
     * Get the user location of a user based on his UUID
     * @param userId the UUID
     * @return a VisitedLocation model
     */
    public VisitedLocation getUserLocationGpsUtil(UUID userId) {
        logger.debug("getUserLocationGpsUtil");
        return gpsUtil.getUserLocation(userId);
    }

    /**
     * Get all the attractions in a form of a list of attractions
     * @return a list of attractions
     */
    public List<Attraction> getAttractionsGpsUtil() {
        logger.debug("getAttractionsGpsUtil");
        return gpsUtil.getAttractions();
    }
}
