package fundamentals.java.patterns.templatemethod;

import java.util.List;

public abstract class TemplateConfig {
    public List<String> execute(List<String> appConfig){
        validateAppConfig(appConfig);
        config(appConfig);
        return posConfig(appConfig);
    }

    abstract void validateAppConfig(List<String> appConfig);
    abstract void config(List<String> appConfig);

    private List<String> posConfig(List<String> appConfig){
         appConfig.add("Pos Execution - Done");
        return appConfig;
    }
}


