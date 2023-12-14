package ch.heigvd.Shared;

import java.util.HashMap;
import java.util.Map;

public class TypeNews {
    public static Map<String, String> mapTypeIP = new HashMap<String, String>() {{
        put("WEATHER", "239.0.0.1");
        put("HEIG"   , "239.0.0.2");
        put("POLITIC", "239.0.0.3");
        put("SPORT"  , "239.0.0.4");
    }};
}
