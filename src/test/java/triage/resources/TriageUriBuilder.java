package triage.resources;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by ursinbrunner on 08/08/15.
 */
public class TriageUriBuilder {
    public static final String BASE_URL = "http://localhost:8080/triage-app/api";

    static URI buildUri(String... paths) {
        javax.ws.rs.core.UriBuilder builder = javax.ws.rs.core.UriBuilder.fromUri(BASE_URL);

        for (String path : paths) {
            builder.path(path);
        }
        return builder.build();
    }
}
