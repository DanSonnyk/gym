package fundamentals.java.patterns.templatemethod;

import java.util.List;

public class ConfigAppPayment extends TemplateConfig{
    @Override
    void validateAppConfig(List<String> appConfig) {
        appConfig.add("Validate config - Done!");
    }

    @Override
    void config(List<String> appConfig) {
        appConfig.add("Connection and Post configs to payment Done!");
    }
}
