package com.dhandapani.microservicestutorialloansms.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix="loans") // Specify the main prefix you have inside the properties file
@Getter
@Setter
@ToString
public class LoansServiceConfig {

  private String msg;
  private String buildVersion;
  private Map<String, String> mailDetails;
  private List<String> activeBranches;
}
