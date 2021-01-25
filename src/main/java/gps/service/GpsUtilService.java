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


    public VisitedLocation getUserLocationGpsUtil(UUID userId) {
        logger.debug("getUserLocationGpsUtil");
        return gpsUtil.getUserLocation(userId);
    }

    public List<Attraction> getAttractionsGpsUtil() {
        logger.debug("getAttractionsGpsUtil");
        return gpsUtil.getAttractions();
    }
}