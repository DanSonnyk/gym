package fundamentals.java.patterns.templatemethod;

import java.util.List;

public class ConfigAppCustomer extends TemplateConfig{
    @Override
    void validateAppConfig(List<String> appConfig) {
        appConfig.add("Validate config Customer - Done!");
    }

    @Override
    void config(List<String> appConfig) {
        appConfig.add("Connection and Post configs to Customer Done!");
    }
}
