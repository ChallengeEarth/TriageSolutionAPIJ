package triage.config;

import io.swagger.jaxrs.config.BeanConfig;
import org.reflections.Reflections;
import triage.models.Language;
import triage.resources.LanguageResource;
import triage.resources.PatientResource;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class TriageApplication extends javax.ws.rs.core.Application {

    public TriageApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/triage-app/api");
        beanConfig.setResourcePackage("triage.resources");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        //Seems to be necessary to add the resources this way since we use swagger.
        //instead of adding everyone manually, use this little helper
        resources.addAll(ClassFinder.find("triage.resources"));


        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
