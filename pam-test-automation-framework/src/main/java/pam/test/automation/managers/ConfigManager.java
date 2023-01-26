package pam.test.automation.managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ConfigManager {

	INSTANCE;

	private static final Logger LOG = LoggerFactory.getLogger(ConfigManager.class);
	private static final String CONFIG_FOLDER = "configs";

	// get specific property
	public String getProperty(String key) {
		Properties properties = getAllPropertiesFromConfig();
		return properties.getProperty(key);
	}

	// read properties file content will return all properties
	private Properties getAllPropertiesFromConfig() {
		File configFile = getConfigFile();
		Properties properties = new Properties();

		try (FileInputStream fs = new FileInputStream(configFile)) {
			properties.load(fs);
		} catch (IOException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return properties;
	}


	// get properties files
	private File getConfigFile() {
		// The default environment is qa, so it will be used if no environment parameter is provided.
		String environment = System.getProperty("environment", "qa");
		String propertiesFileName = String.format("%s.properties", environment); //environment + ".properties";
		File configFile = new File(CONFIG_FOLDER, propertiesFileName);
		LOG.info("Load configuration from {}", configFile.getPath());

		return configFile;
	}
}
