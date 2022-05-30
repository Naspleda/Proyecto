
package com.portfolio.CEN;



import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class CENApplication {

	public static void main(String[] args) {
		SpringApplication.run(CENApplication.class, args);}

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer ()  {

            public void addCorsMapping(CorsRegistry reg){
                reg.addMapping("/**").allowedOrigins("https://apcen-fe953.web.app/");
            }
        };
    }
        
        	@Bean
                public CorsFilter corsFilter() {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setAllowedOrigins(Arrays.asList("https://apcen-fe953.web.app/"));
                    corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                                    "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                                    "Access-Control-Request-Method", "Access-Control-Request-Headers"));
                    corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                                    "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
                    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
                    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
                    return new CorsFilter(urlBasedCorsConfigurationSource);
	}
        
}
