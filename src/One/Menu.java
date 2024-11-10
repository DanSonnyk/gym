package One;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu {
    //Dado que receba um mapa de menus
    //Retorne uma query SQL caso o menu seja true
    //Menus: "m1", true
    //Query: "SELECT * FROM table WHERE m1=m1 ... demais menus caso sejam true"
    public static void main(String[] args) {
        requestMenu(Map.of("valorA", true));
    }

    public static String requestMenu(Map<String, Boolean> filters){
        //Impl...
        if(filters.get("valorA") == true) {
            return "Select * from table where valorA = " + filters.keySet().stream().findFirst().get();
        }
        return"";
    }



































































    public String requestMenus(Map<String, Boolean> filters){
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM table");

        List<String> menus = new ArrayList<>();
        filters.forEach((string, aBoolean) -> {
            if (aBoolean){
                menus.add(string);
            }
        });

        menus.forEach(menu -> {
            if(menu.equalsIgnoreCase("m1")){
                queryBuilder.append("m1=m1");
            }
        });
        return queryBuilder.toString();
    }
}
