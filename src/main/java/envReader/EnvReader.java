package envReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvReader
{

    public static Properties properties;

    public static Properties getProperties() throws IOException
    {
        File properties_File = new File("src/main/resources/env.properties");

        FileInputStream fis = new FileInputStream(properties_File);

        properties = new Properties();

        properties.load(fis);

        fis.close();

        return properties;
    }

    public static String getProperty(String keyName) throws IOException
    {
        return getProperties().getProperty(keyName);
    }
}
