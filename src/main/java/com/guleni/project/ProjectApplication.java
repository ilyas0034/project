package com.guleni.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
    @Bean
    public ModelMapper getModelMapper()
     {
         return new ModelMapper();
     }
    /*  @Bean
   public Jackson2RepositoryPopulatorFactoryBean repositoryPopulatorFactoryBean()
     {
         Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
         factoryBean.setResources(new Resource[] { new ClassPathResource("project.json") });
         return factoryBean;
     }
*/

}
