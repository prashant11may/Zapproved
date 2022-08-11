package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "file:${user.dir}/Resources/config.properties", "file:${user.dir}/Resources/config2.properties" })

public interface PropertiesConfig extends Config {

	String URL();

	String UserName();

	String UserName2();

	String PWD();

	@DefaultValue("Local")
	String Execution();

}
