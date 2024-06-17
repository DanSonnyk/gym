package fundamentals.java.patterns.templatemethod;

import java.util.ArrayList;
import java.util.List;

public class BuildConfigs {
    public static void main(String[] args) {
        final  List<TemplateConfig> templates = new ArrayList<>();
        templates.add(new ConfigAppCustomer());
        templates.add(new ConfigAppPayment());
        templates.add(new ConfigAppOrder());

        //Mock configurations
        List<String> appConfig = new ArrayList<>();
        appConfig.addFirst("Config instructions");

        templates.forEach(child -> System.out.println(child.execute(appConfig)));
    }
}
