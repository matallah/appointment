//package sbs.security;
//
//import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import sbs.model.Visitors;
//import sbs.service.VisitorsService;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
//@Component
//@Order(1)
//public class HitCounter implements Filter {
//
//    @Autowired
//    private VisitorsService visitorsService;
//    public static final String X_CLACKS_OVERHEAD = "X-Clacks-Overhead";
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res,
//                         FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader(X_CLACKS_OVERHEAD, "GNU Terry Pratchett");
//        chain.doFilter(req, res);
//        String remoteAddr = req.getRemoteAddr();
//        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        GetLocationExample obj = new GetLocationExample();
//        ServerLocation location = obj.getLocation("206.190.36.45");
//        //visitorsService.getVisitorsDao().deleteAll();
//        Visitors visitor = new Visitors();
//        visitor.setCreationUser(name);
//        visitor.setCreationDate(new Date());
//        visitor.setRemoteAddr(remoteAddr);
//        visitor.setSessionId(sessionId);
//        List<Visitors> allBySessionId = visitorsService.getVisitorsDao().findAllBySessionId(sessionId);
//        if (allBySessionId.isEmpty()) {
//            visitorsService.save(visitor);
//        }
//    }
//
//    public ServerLocation getLocation(String ipAddress) {
//
//        File file = new File(
//                "C:\\resources\\location\\GeoLiteCity.dat");
//        return getLocation(ipAddress, file);
//
//    }
//
//    public ServerLocation getLocation(String ipAddress, File file) {
//
//        ServerLocation serverLocation = null;
//
//        try {
//
//            serverLocation = new ServerLocation();
//
//            LookupService lookup = new LookupService(file,LookupService.GEOIP_MEMORY_CACHE);
//            Location locationServices = lookup.getLocation(ipAddress);
//            serverLocation.setCountryCode(locationServices.countryCode);
//            serverLocation.setCountryName(locationServices.countryName);
//            serverLocation.setRegion(locationServices.region);
//            serverLocation.setRegionName(regionName.regionNameByCode(
//                    locationServices.countryCode, locationServices.region));
//            serverLocation.setCity(locationServices.city);
//            serverLocation.setPostalCode(locationServices.postalCode);
//            serverLocation.setLatitude(String.valueOf(locationServices.latitude));
//            serverLocation.setLongitude(String.valueOf(locationServices.longitude));
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        return serverLocation;
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//    }
//}
