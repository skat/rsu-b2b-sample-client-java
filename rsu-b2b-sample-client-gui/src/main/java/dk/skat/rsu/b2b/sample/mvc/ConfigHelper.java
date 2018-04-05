package dk.skat.rsu.b2b.sample.mvc;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

/**
 * ConfigHelper
 *
 * @author SKAT
 * @since 1.0
 */
public class ConfigHelper {

    /**
     * Load configuration in following priority:
     *
     * 1. $user.dir/app.conf
     * 2. jar!reference.conf (embedded)
     *
     * @return Configuration
     */
    public static Config getConfiguration() {
        String appConf = System.getProperty("user.dir") + File.separator + "app.conf";
        Config config = ConfigFactory.parseFile(new File(appConf)).withFallback(ConfigFactory.load());
        return config;
    }
}
