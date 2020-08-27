package sv.gob.mh.saif2.clasificadores.api.v1.config;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.OracleTemplates;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.types.InputStreamType;
import com.querydsl.sql.types.JSR310LocalDateTimeType;
import com.querydsl.sql.types.JSR310LocalDateType;
import com.querydsl.sql.types.JSR310LocalTimeType;
import com.querydsl.sql.types.JSR310ZonedDateTimeType;
import com.querydsl.sql.types.Type;
import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class Resources {

    @Produces
    @Resource(lookup = "java:jboss/datasources/SAFICOREV2")
    DataSource dataSource;

    @Produces
    public Configuration querydslConfiguration() throws InstantiationException, IllegalAccessException {
        SQLTemplates templates = OracleTemplates.builder().printSchema().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.register(classType(InputStreamType.class));
        configuration.register(classType(JSR310LocalDateType.class));
        configuration.register(classType(JSR310LocalTimeType.class));
        configuration.register(classType(JSR310LocalDateTimeType.class));
        configuration.register(classType(JSR310ZonedDateTimeType.class));

        return configuration;
    }

    private static Type<?> classType(Class<?> classType) throws InstantiationException, IllegalAccessException {
        return (Type<?>) classType.newInstance();
    }

}
